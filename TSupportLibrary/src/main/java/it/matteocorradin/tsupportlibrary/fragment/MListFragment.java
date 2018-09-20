package it.matteocorradin.tsupportlibrary.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import it.matteocorradin.tsupportlibrary.adapter.HomeAdapter;
import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataGenericElement;
import it.matteocorradin.tsupportlibrary.adapter.utils.AdapterDataGenericElementDiffCallback;

public abstract class MListFragment extends BaseFragment {

    protected RecyclerView recyclerView;
    protected HomeAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(getRecyclerViewResourceId());

        Class<?> clazz = getAdapterClass();
        if (clazz != null) {
            Constructor<?> ctor;
            try {
                ctor = clazz.getConstructor(HomeAdapter.class);
                Object object = ctor.newInstance(new AdapterDataGenericElementDiffCallback());
                if (object instanceof HomeAdapter) {
                    recyclerView.setAdapter((HomeAdapter) object);
                }
            } catch (IllegalAccessException | java.lang.InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        recyclerView.setLayoutManager(getLayoutManager());
        List<RecyclerView.ItemDecoration> itemDecorations = getItemDecorations();
        if (itemDecorations.size() > 0){
            for (RecyclerView.ItemDecoration itemDecoration: itemDecorations){
                recyclerView.addItemDecoration(itemDecoration);
            }
        }
        recyclerView.setAdapter(adapter);
    }

    protected abstract Class<HomeAdapter> getAdapterClass();

    protected abstract @IdRes int getRecyclerViewResourceId();

    protected void updateList(){
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

}
