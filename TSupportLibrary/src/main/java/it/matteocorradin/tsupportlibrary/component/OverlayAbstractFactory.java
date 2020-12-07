package it.matteocorradin.tsupportlibrary.component;

import android.content.Context;

public abstract class OverlayAbstractFactory {
    public abstract SituatedComponent getSituatedComponent(Context context, OverlayHandler overlayHandler);
    public abstract Integer getTag();
}
