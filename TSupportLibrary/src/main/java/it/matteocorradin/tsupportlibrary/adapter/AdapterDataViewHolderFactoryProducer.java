package it.matteocorradin.tsupportlibrary.adapter;

import androidx.annotation.NonNull;

public abstract class AdapterDataViewHolderFactoryProducer {

    @NonNull
    public abstract AdapterDataViewHolderAbstractFactory getFactory(int viewType);
}
