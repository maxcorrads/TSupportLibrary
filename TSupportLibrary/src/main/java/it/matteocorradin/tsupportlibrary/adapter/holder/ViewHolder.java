package it.matteocorradin.tsupportlibrary.adapter.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import it.matteocorradin.tsupportlibrary.adapter.model.AdapterDataGenericElement;

public class ViewHolder extends RecyclerView.ViewHolder {

    protected Context mContext;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mContext = itemView.getContext();
    }


    public void bind(AdapterDataGenericElement generic) {

    }
}
