package it.matteocorradin.tsupportlibrary.adapter.model;

import it.matteocorradin.tsupportlibrary.adapter.AdapterDataViewHolderAbstractFactory;

public interface IAdapterDataElementType {
    String getName();
    int getId();
    AdapterDataViewHolderAbstractFactory getFactory();
}
