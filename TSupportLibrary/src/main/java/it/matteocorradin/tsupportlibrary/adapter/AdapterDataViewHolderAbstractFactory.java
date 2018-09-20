package it.matteocorradin.tsupportlibrary.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import it.matteocorradin.tsupportlibrary.adapter.holder.ViewHolder;

public abstract class AdapterDataViewHolderAbstractFactory {
    @NonNull
    public abstract ViewHolder getViewHolder(ViewGroup parent);
}
