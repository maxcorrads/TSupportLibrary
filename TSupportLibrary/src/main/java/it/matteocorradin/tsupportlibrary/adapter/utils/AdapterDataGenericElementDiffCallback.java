package it.matteocorradin.tsupportlibrary.adapter.utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
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
