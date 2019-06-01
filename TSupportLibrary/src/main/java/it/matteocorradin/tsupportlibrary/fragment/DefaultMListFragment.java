package it.matteocorradin.tsupportlibrary.fragment;

import it.matteocorradin.tsupportlibrary.adapter.DefaultAdapterDataGenericElementDiffCallback;
import it.matteocorradin.tsupportlibrary.adapter.DefaultHomeAdapter;
import it.matteocorradin.tsupportlibrary.adapter.HomeAdapter;

public abstract class DefaultMListFragment extends MListFragment {

    private HomeAdapter adapter;

    @Override
    protected HomeAdapter getAdapter() {
        if (adapter == null){
            adapter = new DefaultHomeAdapter(new DefaultAdapterDataGenericElementDiffCallback());
        }
        return adapter;
    }
}
