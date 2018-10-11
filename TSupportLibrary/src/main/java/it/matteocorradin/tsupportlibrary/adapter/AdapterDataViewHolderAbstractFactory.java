package it.matteocorradin.tsupportlibrary.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import it.matteocorradin.tsupportlibrary.adapter.holder.ViewHolder;

public abstract class AdapterDataViewHolderAbstractFactory {
    @NonNull
    public abstract ViewHolder getViewHolder(ViewGroup parent);
}
