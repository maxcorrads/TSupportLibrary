package it.matteocorradin.tsupportlibrary.adapter.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
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
