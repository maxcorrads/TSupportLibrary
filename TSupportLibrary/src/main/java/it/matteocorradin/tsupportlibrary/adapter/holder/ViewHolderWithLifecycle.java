package it.matteocorradin.tsupportlibrary.adapter.holder;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.support.annotation.NonNull;
import android.view.View;

import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataGenericElement;

public class ViewHolderWithLifecycle extends ViewHolder implements LifecycleOwner {

    public final LifecycleRegistry lifecycleRegistry;

    public ViewHolderWithLifecycle(@NonNull View itemView) {
        super(itemView);
        lifecycleRegistry = new LifecycleRegistry(this);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    public void bind(AdapterDataGenericElement item) {
        super.bind(item);
        lifecycleRegistry.markState(Lifecycle.State.RESUMED);
    }
}
