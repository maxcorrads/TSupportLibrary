package it.matteocorradin.tsupportlibrary.adapter.model;

import androidx.annotation.NonNull;

public abstract class AdapterDataGenericElementWithValue<T> extends AdapterDataGenericElement {

    private final T value;

    public AdapterDataGenericElementWithValue(int type, @NonNull T value) {
        super(type);
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}

