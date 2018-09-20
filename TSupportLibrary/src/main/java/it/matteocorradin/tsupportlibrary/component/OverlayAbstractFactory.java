package it.matteocorradin.tsupportlibrary.component;

import android.content.Context;
import android.widget.RelativeLayout;

import it.matteocorradin.tsupportlibrary.OverlayViewSupportActivity;

public abstract class OverlayAbstractFactory {
    public abstract SituatedComponent getSituatedComponent(Context context, OverlayViewSupportActivity overlayHandler, final RelativeLayout.LayoutParams params);
    public abstract SituatedComponent getSituatedComponent(Context context, OverlayViewSupportActivity overlayHandler);
}
