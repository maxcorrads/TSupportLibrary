package it.matteocorradin.tsupportlibrary;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

public interface ActivityContextCallable {
    void call(@NonNull Activity activity, @NonNull Context context) throws Exception;
}
