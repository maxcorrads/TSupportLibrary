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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigator;

import java.util.ArrayList;
import java.util.List;

import it.matteocorradin.tsupportlibrary.Optional;
import it.matteocorradin.tsupportlibrary.OverlayViewSupportActivity;
import it.matteocorradin.tsupportlibrary.R;
import it.matteocorradin.tsupportlibrary.SysKb;
import it.matteocorradin.tsupportlibrary.component.OverlayAbstractFactory;
import it.matteocorradin.tsupportlibrary.component.OverlayHandler;
import it.matteocorradin.tsupportlibrary.component.SituatedComponent;
import it.matteocorradin.tsupportlibrary.fragment.nav.INavSupport;
import it.matteocorradin.tsupportlibrary.fragment.nav.TNavSupport;
import it.matteocorradin.tsupportlibrary.fragment.overlay.IOverlaySupport;
import it.matteocorradin.tsupportlibrary.fragment.overlay.TOverlaySupport;

public abstract class BaseFragment extends Fragment implements IOverlaySupport, OverlayHandler, INavSupport {

    private static final int REQUEST_LOCATION = 2;

    private TNavSupport tNavSupport;
    private TOverlaySupport tOverlaySupport;
    private float startZ;

    protected abstract @LayoutRes int getLayoutResourceId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResourceId(), container, false);
        onCreateViewSuperInit(view);
        return view;
    }

    protected void onCreateViewSuperInit(View view){
        tNavSupport = new TNavSupport(view);
    }

    protected void initView(View view){

    }

    public Optional<OverlayViewSupportActivity> getBaseActivity(){
        return tOverlaySupport.getBaseActivity();
    }

    protected List<OverlayAbstractFactory> overlayElementList(){
        return new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tOverlaySupport = new TOverlaySupport(this, overlayElementList(), getActivity(), view, getContext());
        initView(view);
    }

    @Override
    public void clickAction(SituatedComponent sender) {

    }

    @Override
    public boolean isOverlayEnabled() {
        return true;
    }

    public void goBack() {
        if (tNavSupport != null) {
            tNavSupport.goBack();
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

    //This method returns true if keyboard was shown before hiding.
    public boolean hideSoftInputBase() {
        if (tOverlaySupport != null) {
            return tOverlaySupport.hideSoftInputBase();
        }
        return false;
    }

    public void showFragmentFromModalBack(@IdRes int id){
        if (tNavSupport != null) {
            tNavSupport.showFragmentFromModalBack(id);
        }
    }
    public void showFragmentFromModalBack(@IdRes int id, Bundle args){
        if (tNavSupport != null) {
            tNavSupport.showFragmentFromModalBack(id, args);
        }
    }
    public void showFragment(@IdRes int id){
        if (tNavSupport != null) {
            tNavSupport.showFragment(id);
        }
    }
    public void showFragment(@IdRes int id, Bundle args){
        if (tNavSupport != null) {
            tNavSupport.showFragment(id, args);
        }
    }
    public void modalFragment(@IdRes int id){
        if (tNavSupport != null) {
            tNavSupport.modalFragment(id);
        }
    }
    public void modalFragment(@IdRes int id, Bundle args){
        if (tNavSupport != null) {
            tNavSupport.modalFragment(id, args);
        }
    }
    public void pushFragment(@IdRes int id){
        if (tNavSupport != null) {
            tNavSupport.pushFragment(id);
        }
    }
    public void pushFragment(@IdRes int id, Bundle args){
        if (tNavSupport != null) {
            tNavSupport.pushFragment(id, args);
        }
    }
    public void pushFragmentSharedElement(@IdRes int id, Bundle args, Navigator.Extras navigatorExtras){
        if (tNavSupport != null) {
            tNavSupport.pushFragmentSharedElement(id, args, navigatorExtras);
        }
    }

    public void reloadOverlays(){
        if (tOverlaySupport != null){
            tOverlaySupport.reloadOverlays();
        }
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (nextAnim != 0 && nextAnim != R.anim.nothing) {
            Animation nextAnimation = AnimationUtils.loadAnimation(getContext(), nextAnim);
            nextAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    if (getView() != null) {
                        startZ = ViewCompat.getTranslationZ(getView());
                        ViewCompat.setTranslationZ(getView(), 10f);
                    }
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (getView() != null) {
                        getView().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (getView() != null) {
                                    ViewCompat.setTranslationZ(getView(), startZ);
                                }
                            }
                        },100);
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            return nextAnimation;
        } else {
            return null;
        }
    }
}
