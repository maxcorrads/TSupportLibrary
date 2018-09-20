package it.matteocorradin.tsupportlibrary;

import android.support.annotation.NonNull;
import android.view.View;

import it.matteocorradin.tsupportlibrary.component.SituatedComponent;

import java.util.List;

public interface IOverlayViewSupportActivity {

    boolean hasOverlay();
    void removeOverlay();
    void hideOverlay();
    void showOverlay();
    void addOverlay(List<OverlayElement> overlayElementList);
    SituatedComponent getOverlay(Integer tag);
    @NonNull
    <T extends View> Optional<T> getOverlay(Class<T> resClass, Integer tag);
    @NonNull
    <T extends View> Optional<T> getOverlay(Class<T> resClass);
}
