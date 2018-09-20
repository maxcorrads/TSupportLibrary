package it.matteocorradin.tsupportlibrary.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import it.matteocorradin.tsupportlibrary.Optional;
import it.matteocorradin.tsupportlibrary.OverlayElement;
import it.matteocorradin.tsupportlibrary.OverlayViewSupportActivity;
import it.matteocorradin.tsupportlibrary.R;
import it.matteocorradin.tsupportlibrary.SysKb;
import it.matteocorradin.tsupportlibrary.component.OverlayHandler;
import it.matteocorradin.tsupportlibrary.component.SituatedComponent;

public abstract class BaseFragment extends Fragment implements OverlayHandler {

    private static final int REQUEST_LOCATION = 2;

    protected abstract @LayoutRes int getLayoutResourceId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResourceId(), container, false);
        return view;
    }

    protected void initView(View view){
        final OverlayHandler overlayHandler = this;
        getBaseActivity().ifPresent(new Optional.Action<OverlayViewSupportActivity>() {
            @Override
            public void apply(OverlayViewSupportActivity activity) {
                activity.addOverlay(overlayElementList());
                activity.setOverlayHandler(overlayHandler);
            }
        });
    }

    protected Optional<OverlayViewSupportActivity> getBaseActivity(){
        FragmentActivity fragmentActivity = getActivity();
        if (fragmentActivity instanceof OverlayViewSupportActivity) {
            OverlayViewSupportActivity activity = (OverlayViewSupportActivity) getActivity();
            if (activity != null) {
                return Optional.of(activity);
            }
        }
        return Optional.empty();
    }

    protected List<OverlayElement> overlayElementList(){
        return new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void clickAction(SituatedComponent sender) {

    }

    protected void goBack() {
        View view = this.getView();
        if (view != null) {
            Navigation.findNavController(view).navigateUp();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION){
            gpsPermissionChanged();
        }
    }

    protected void gpsPermissionChanged() {

    }

    public void requestGps() {
        Context context = getContext();
        if (context != null) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
            }
        }
    }

    @SuppressLint("MissingPermission")
    protected Location getMyLocation() {
        Activity activity = getActivity();
        if (SysKb.hasGpsPermission(getContext()) && activity != null) {
            LocationManager lm = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
            Location myLocation = null;
            if (lm != null) {
                myLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
            if (myLocation == null) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_FINE);
                String provider;
                if (lm != null) {
                    provider = lm.getBestProvider(criteria, true);
                    myLocation = lm.getLastKnownLocation(provider);
                }
            }
            return myLocation;
        }
        return null;
    }

    protected void pushFragment(@IdRes int id) {
        View view = this.getView();
        if (view != null) {
            NavController navController = Navigation.findNavController(getView());
            NavOptions options = new NavOptions.Builder().setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
                    .build();
            navController.navigate(id, null, options);
        }
    }
}
