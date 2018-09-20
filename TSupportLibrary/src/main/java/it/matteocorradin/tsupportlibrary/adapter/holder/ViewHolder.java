package it.matteocorradin.tsupportlibrary.adapter.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataGenericElement;

public class ViewHolder extends RecyclerView.ViewHolder {

    Context mContext;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mContext = itemView.getContext();
    }


    public void bind(AdapterDataGenericElement generic) {

    }
}
