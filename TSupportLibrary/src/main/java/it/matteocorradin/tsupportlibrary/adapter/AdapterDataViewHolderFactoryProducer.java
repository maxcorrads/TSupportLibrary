package it.matteocorradin.tsupportlibrary.adapter;

import android.support.annotation.NonNull;

public abstract class AdapterDataViewHolderFactoryProducer {

    @NonNull
    public abstract AdapterDataViewHolderAbstractFactory getFactory(int viewType);
}
