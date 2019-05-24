package it.matteocorradin.tsupportlibrary.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

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
        holder.bind(getItem(position), this);
    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder holder) {
        super.onViewRecycled(holder);
        if (holder instanceof ViewHolderWithLifecycle){
            ((ViewHolderWithLifecycle) holder).lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof ViewHolderWithLifecycle){
            ((ViewHolderWithLifecycle) holder).lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (holder instanceof ViewHolderWithLifecycle){
            ((ViewHolderWithLifecycle) holder).lifecycleRegistry.markState(Lifecycle.State.RESUMED);
            holder.bind(getItem(holder.getAdapterPosition()), this);
        }
    }

    public abstract AdapterDataViewHolderFactoryProducer getAdapterDataViewHolderFactoryProducer();

}