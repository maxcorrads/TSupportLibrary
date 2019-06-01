package it.matteocorradin.tsupportlibrary.adapter;

import androidx.annotation.NonNull;

import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataGenericElement;
import it.matteocorradin.tsupportlibrary.adapter.utils.AdapterDataGenericElementDiffCallback;

public class DefaultAdapterDataGenericElementDiffCallback extends AdapterDataGenericElementDiffCallback {
    @Override
    public boolean areItemsTheSame(@NonNull AdapterDataGenericElement oldItem, @NonNull AdapterDataGenericElement newItem) {
        return super.areItemsTheSame(oldItem, newItem);
    }
}
