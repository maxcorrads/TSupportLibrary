package it.matteocorradin.tsupportlibrary.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import it.matteocorradin.tsupportlibrary.adapter.DefaultAdapterDataGenericElementDiffCallback;
import it.matteocorradin.tsupportlibrary.adapter.DefaultHomeAdapter;
import it.matteocorradin.tsupportlibrary.adapter.HomeAdapter;
import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataGenericElement;

public abstract class BottomSheetDialogMListFragment extends BottomSheetDialogBaseFragment {

    protected RecyclerView recyclerView;
    private HomeAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(getRecyclerViewResourceId());

        recyclerView.setLayoutManager(getLayoutManager());
        List<RecyclerView.ItemDecoration> itemDecorations = getItemDecorations();
        if (itemDecorations.size() > 0){
            for (RecyclerView.ItemDecoration itemDecoration: itemDecorations){
                recyclerView.addItemDecoration(itemDecoration);
            }
        }
        recyclerView.setAdapter(getAdapter());
    }

    protected abstract @IdRes int getRecyclerViewResourceId();

    protected void updateList(){
        HomeAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.submitList(getList());
            adapter.notifyDataSetChanged();
        }
    }

    protected abstract List<AdapterDataGenericElement> getList();

    protected RecyclerView.LayoutManager getLayoutManager(){
        return new LinearLayoutManager(getContext());
    }

    protected List<RecyclerView.ItemDecoration> getItemDecorations(){
        return new ArrayList<>();
    }

    protected HomeAdapter getAdapter() {
        if (adapter == null){
            adapter = new DefaultHomeAdapter(new DefaultAdapterDataGenericElementDiffCallback());
        }
        return adapter;
    }

}
