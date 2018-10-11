package it.matteocorradin.tsupportlibrary.adapter.utils;

import android.view.View;

public abstract class OnClickListenerWithValue<T> implements View.OnClickListener {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
