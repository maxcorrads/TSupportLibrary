package it.matteocorradin.tsupportlibrary.adapter;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import it.matteocorradin.tsupportlibrary.adapter.holder.ViewHolder;
import it.matteocorradin.tsupportlibrary.adapter.holder.ViewHolderWithLifecycle;
import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataGenericElement;

public abstract class HomeAdapter extends ListAdapter<AdapterDataGenericElement, ViewHolder> {

    public HomeAdapter(@NonNull DiffUtil.ItemCallback<AdapterDataGenericElement> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getAdapterDataViewHolderFactoryProducer().getFactory(viewType).getViewHolder(parent);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder holder) {
        super.onViewRecycled(holder);
        if (holder instanceof ViewHolderWithLifecycle){
            ((ViewHolderWithLifecycle) holder).lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
        }
    }

    public abstract AdapterDataViewHolderFactoryProducer getAdapterDataViewHolderFactoryProducer();

}