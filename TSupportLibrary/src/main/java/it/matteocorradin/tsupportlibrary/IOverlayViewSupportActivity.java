package it.matteocorradin.tsupportlibrary;

import android.view.View;

import java.util.List;

import androidx.annotation.NonNull;
import it.matteocorradin.tsupportlibrary.component.SituatedComponent;

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