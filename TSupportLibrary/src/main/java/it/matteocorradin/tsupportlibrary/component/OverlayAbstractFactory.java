package it.matteocorradin.tsupportlibrary.component;

import android.content.Context;

import it.matteocorradin.tsupportlibrary.OverlayViewSupportActivity;

public abstract class OverlayAbstractFactory {
    public abstract SituatedComponent getSituatedComponent(Context context, OverlayViewSupportActivity overlayHandler);
    public abstract Integer getTag();
}
