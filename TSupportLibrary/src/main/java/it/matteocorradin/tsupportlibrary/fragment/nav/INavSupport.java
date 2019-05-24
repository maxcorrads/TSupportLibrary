package it.matteocorradin.tsupportlibrary.fragment.nav;

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.navigation.Navigator;

public interface INavSupport {
    void showFragment(@IdRes int id);
    void showFragment(@IdRes int id, Bundle args);
    void modalFragment(@IdRes int id);
    void modalFragment(@IdRes int id, Bundle args);
    void pushFragment(@IdRes int id);
    void pushFragment(@IdRes int id, Bundle args);
    void pushFragmentSharedElement(@IdRes int id, Bundle args, Navigator.Extras navigatorExtras);
    void goBack();
}
