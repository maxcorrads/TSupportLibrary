package it.matteocorradin.tsupportlibrary.fragment.nav;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;

import it.matteocorradin.tsupportlibrary.R;

public class TNavSupport implements INavSupport {

    private View mView;

    public TNavSupport(View mView) {
        this.mView = mView;
    }

    private View getView() {
        return mView;
    }

    public void showFragmentFromModalBack(@IdRes int id) {
        showFragment(id, null);
    }

    public void showFragmentFromModalBack(@IdRes int id, Bundle args) {
        View view = this.getView();
        if (view != null) {
            NavController navController = Navigation.findNavController(getView());
            NavOptions options = new NavOptions.Builder().setEnterAnim(it.matteocorradin.tsupportlibrary.R.anim.nothing_reverse).setExitAnim(it.matteocorradin.tsupportlibrary.R.anim.slide_out_bottom).setPopEnterAnim(it.matteocorradin.tsupportlibrary.R.anim.nav_default_pop_enter_anim).setPopExitAnim(it.matteocorradin.tsupportlibrary.R.anim.slide_out_bottom)
                    .build();
            navController.navigate(id, args, options);
        }
    }

    public void showFragment(@IdRes int id) {
        showFragment(id, null);
    }

    public void showFragment(@IdRes int id, Bundle args) {
        View view = this.getView();
        if (view != null) {
            NavController navController = Navigation.findNavController(getView());
            NavOptions options = new NavOptions.Builder().setEnterAnim(0).setExitAnim(0).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.slide_out_bottom)
                    .build();
            navController.navigate(id, args, options);
        }
    }

    public void modalFragment(@IdRes int id) {
        modalFragment(id, null);
    }

    public void modalFragment(@IdRes int id, Bundle args) {
        View view = this.getView();
        if (view != null) {
            NavController navController = Navigation.findNavController(getView());
            //NavOptions options = new NavOptions.Builder().setEnterAnim(R.anim.slide_in_bottom).setExitAnim(R.anim.nothing).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.slide_out_bottom)
            NavOptions options = new NavOptions.Builder().setEnterAnim(R.anim.slide_in_bottom).setExitAnim(R.anim.nothing).setPopExitAnim(R.anim.slide_out_bottom)
                    .build();
            navController.navigate(id, args, options);
        }
    }

    public void pushFragment(@IdRes int id) {
        pushFragment(id, null);
    }

    public void pushFragment(@IdRes int id, Bundle args) {
        View view = this.getView();
        if (view != null) {
            NavController navController = Navigation.findNavController(getView());
            NavOptions options = new NavOptions.Builder().setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
                    .build();
            navController.navigate(id, args, options);
        }
    }

    public void pushFragmentSharedElement(@IdRes int id, Bundle args, Navigator.Extras navigatorExtras){
        View view = this.getView();
        if (view != null) {
            NavController navController = Navigation.findNavController(getView());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                NavOptions options = new NavOptions.Builder().setEnterAnim(android.R.anim.fade_in).setExitAnim(android.R.anim.fade_out).setPopEnterAnim(android.R.anim.fade_in).setPopExitAnim(android.R.anim.fade_out)
                        .build();
                navController.navigate(id, args, options, navigatorExtras);
            }else {
                NavOptions options = new NavOptions.Builder().setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
                        .build();
                navController.navigate(id, args, options, navigatorExtras);
            }
        }
    }

    public void goBack() {
        View view = this.getView();
        if (view != null) {
            try {
                Navigation.findNavController(view).navigateUp();
            }catch (Exception ignore){
                
            }
        }
    }

}
