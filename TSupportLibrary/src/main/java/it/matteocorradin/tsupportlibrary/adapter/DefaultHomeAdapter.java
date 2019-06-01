package it.matteocorradin.tsupportlibrary.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataGenericElement;

public class DefaultHomeAdapter extends HomeAdapter {
    private DefaultAdapterDataViewHolderFactoryProducer appAdapterDataViewHolderFactoryProducer;

    public DefaultHomeAdapter(@NonNull DiffUtil.ItemCallback<AdapterDataGenericElement> diffCallback) {
        super(diffCallback);
    }

    @Override
    public AdapterDataViewHolderFactoryProducer getAdapterDataViewHolderFactoryProducer() {
        if (appAdapterDataViewHolderFactoryProducer == null) {
            appAdapterDataViewHolderFactoryProducer = new DefaultAdapterDataViewHolderFactoryProducer();
        }
        return appAdapterDataViewHolderFactoryProducer;
    }

}