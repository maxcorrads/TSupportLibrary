package it.matteocorradin.tsupportlibrary.listener;

/*
  Created by matteocorradin on 14/07/17.
 */

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CompositeListener implements View.OnClickListener {
    private List<View.OnClickListener> registeredListeners = new ArrayList<View.OnClickListener>();

    public void registerListener (View.OnClickListener listener) {
        registeredListeners.add(listener);
    }

    public void removeListener (View.OnClickListener listener){
        registeredListeners.remove(listener);
    }

    @Override
    public void onClick(View v) {
        for (View.OnClickListener listener : registeredListeners) {
            listener.onClick(v);
        }
    }
}
