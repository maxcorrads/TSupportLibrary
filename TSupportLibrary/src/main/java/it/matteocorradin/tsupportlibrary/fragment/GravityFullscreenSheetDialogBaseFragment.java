package it.matteocorradin.tsupportlibrary.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.Navigator;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

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

public abstract class GravityFullscreenSheetDialogBaseFragment extends DialogFragment implements IOverlaySupport, OverlayHandler, INavSupport {

    private static final int REQUEST_LOCATION = 2;

    private TNavSupport tNavSupport;
    private TOverlaySupport tOverlaySupport;

    public interface GravityFullscreenSheetDialogBaseFragmentListener{
        void onDismiss();
        void onClose();
    }

    protected GravityFullscreenSheetDialogBaseFragmentListener listener;
    public void setListener(GravityFullscreenSheetDialogBaseFragmentListener listener) {
        this.listener = listener;
    }

    protected abstract @LayoutRes
    int getLayoutResourceId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomGravityFullscreenSheetDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResourceId(), container, false);
        tNavSupport = new TNavSupport(view);
        return view;
    }

    protected void initView(View view){

    }

    public Optional<OverlayViewSupportActivity> getBaseActivity(){
        return tOverlaySupport.getBaseActivity();
    }

    public List<OverlayAbstractFactory> overlayElementList(){
        return new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tOverlaySupport = new TOverlaySupport(this, overlayElementList(), getActivity(), view, getContext());
        initView(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                int width = getSheetWidth();
                int height = getSheetHeight();
                dialog.getWindow().setLayout(width, height);
                dialog.getWindow().setGravity(getSheetGravity());
            }
        }
    }

    protected abstract int getSheetGravity();

    protected int getSheetHeight() {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    protected int getSheetWidth() {
        return ViewGroup.LayoutParams.WRAP_CONTENT;
    }

    @Override
    public void clickAction(SituatedComponent sender) {

    }

    @Override
    public boolean isOverlayEnabled() {
        return true;
    }

    public void goBack() {
        tNavSupport.goBack();
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
        return tOverlaySupport.hideSoftInputBase();
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
    public void pushFragmentSharedElement(@IdRes int id, Bundle args, Navigator.Extras navigatorExtras) {
        if (tNavSupport != null) {
            tNavSupport.pushFragmentSharedElement(id, args, navigatorExtras);
        }
    }

    public void reloadOverlays(){
        if (tOverlaySupport != null){
            tOverlaySupport.reloadOverlays();
        }
    }
}
