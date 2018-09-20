package it.matteocorradin.tsupportlibrary.adapter.utils;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataGenericElement;


public class AdapterDataGenericElementDiffCallback extends DiffUtil.ItemCallback<AdapterDataGenericElement> {
    @Override
    public boolean areItemsTheSame(@NonNull AdapterDataGenericElement oldItem, @NonNull AdapterDataGenericElement newItem) {
        return oldItem.getType() == newItem.getType();
    }

    @Override
    public boolean areContentsTheSame(@NonNull AdapterDataGenericElement oldItem, @NonNull AdapterDataGenericElement newItem) {
        return oldItem == newItem;
    }
}
