package it.matteocorradin.tsupportlibrary.adapter;

import androidx.annotation.NonNull;

import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataElementClass;

public class DefaultAdapterDataViewHolderFactoryProducer extends AdapterDataViewHolderFactoryProducer {

    @NonNull
    @Override
    public AdapterDataViewHolderAbstractFactory getFactory(int viewType) {
        return AdapterDataElementClass.getADET(viewType).getFactory();
    }

}
