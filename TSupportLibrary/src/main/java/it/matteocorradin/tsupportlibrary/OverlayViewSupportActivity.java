package it.matteocorradin.tsupportlibrary;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.matteocorradin.tsupportlibrary.component.OverlayFactoryEnum;
import it.matteocorradin.tsupportlibrary.component.OverlayFactoryProducer;
import it.matteocorradin.tsupportlibrary.component.OverlayHandler;
import it.matteocorradin.tsupportlibrary.component.SituatedComponent;
import it.matteocorradin.tsupportlibrary.component.VoidOverlayHandler;


public abstract class OverlayViewSupportActivity extends AppCompatActivity implements IOverlayViewSupportActivity {

    private HashMap<Integer, SituatedComponent> situatedComponentHashMap = new HashMap<>();

    private OverlayHandler overlayHandler;

    protected abstract RelativeLayout overlayContainerView();
    @NonNull
    public OverlayHandler overlayHandler() {
        return overlayHandler != null ? overlayHandler : VoidOverlayHandler.newInstance();
    }

    public void setOverlayHandler(OverlayHandler overlayHandler) {
        this.overlayHandler = overlayHandler;
    }

    @Override
    public boolean hasOverlay() {
        RelativeLayout overlayContainerView = overlayContainerView();
        if (overlayContainerView != null){
            return overlayContainerView.getChildCount() > 0;
        }
        return false;
    }

    @Override
    public void removeOverlay() {
        if (hasOverlay()) {
            RelativeLayout overlayContainerView = overlayContainerView();
            if (overlayContainerView != null) {
                overlayContainerView.removeAllViews();
            }
        }
    }

    @Override
    public void hideOverlay() {
        RelativeLayout overlayContainerView = overlayContainerView();
        if (overlayContainerView != null) {
            overlayContainerView.setVisibility(View.INVISIBLE);
        }
    }

    public void addOverlayInternal(SituatedComponent view, Integer tag) {
        view.getView().setTag(tag);
        RelativeLayout overlayContainerView = overlayContainerView();
        if (overlayContainerView != null){
            situatedComponentHashMap.put(tag, view);
            overlayContainerView.addView(view.getView(),view.getParams());
            showOverlay();
        }
    }

    private boolean hasOverlay(Integer tag) {
        RelativeLayout overlayContainerView = overlayContainerView();
        if (overlayContainerView != null) {
            for (int i = 0; i<overlayContainerView.getChildCount(); i++){
                if (overlayContainerView.getChildAt(i).getTag().equals(tag)){
                    return true;
                }
            }
        }
        return false;
    }

    private void addOverlay(OverlayFactoryEnum factoryEnum, Integer tag) {
        if (!hasOverlay(tag)) {
            OverlayFactoryProducer producer = getOverlayFactoryProducer();
            if (producer != null) {
                addOverlayInternal(producer.getFactory(factoryEnum).getSituatedComponent(this, this), tag);
            }
        }
    }

    @Override
    public void addOverlay(List<OverlayElement> overlayElementList) {
       List<OverlayElement> elementsToAdd = removeOverlayNotContainedIn(overlayElementList);
       for (OverlayElement element: elementsToAdd) {
           addOverlay(element.getFactoryEnum(), element.getTag());
       }
    }

    private List<OverlayElement> removeOverlayNotContainedIn(List<OverlayElement> overlayElementList) {
        RelativeLayout overlayContainerView = overlayContainerView();
        List<OverlayElement> result = new ArrayList<>();
        List<Integer> tags = new ArrayList<>();
        for (OverlayElement element: overlayElementList){
            result.add(element);
            tags.add(element.getTag());
        }
        List<View> toRemove = new ArrayList<>();
        if (overlayContainerView != null) {
            for (int i = 0; i < overlayContainerView.getChildCount(); i++) {
                if (overlayContainerView.getChildAt(i).getTag() instanceof Integer) {
                    if (tags.contains((Integer) overlayContainerView.getChildAt(i).getTag())) {
                        result.remove(overlayElementList.get(tags.indexOf((Integer) overlayContainerView.getChildAt(i).getTag())));
                    } else {
                        situatedComponentHashMap.remove((Integer) overlayContainerView.getChildAt(i).getTag());
                        toRemove.add(overlayContainerView.getChildAt(i));
                    }
                }
            }
            for (int i = 0; i < toRemove.size(); i++) {
                overlayContainerView.removeView(toRemove.get(i));
            }
        }
        return result;
    }

    @Override
    public void showOverlay() {
        RelativeLayout overlayContainerView = overlayContainerView();
        if (overlayContainerView != null) {
            overlayContainerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public SituatedComponent getOverlay(Integer tag) {
        return situatedComponentHashMap.get(tag);
    }

    @NonNull
    @Override
    public <T extends View> Optional<T> getOverlay(Class<T> resClass, Integer tag) {
        SituatedComponent situatedComponent = getOverlay(tag);
        if (situatedComponent != null){
            if (resClass.isInstance(situatedComponent.getView())){
                return Optional.of((T) situatedComponent.getView());
            }
        }
        return Optional.empty();
    }

    @NonNull
    @Override
    public <T extends View> Optional<T> getOverlay(Class<T> resClass) {
        for (SituatedComponent situatedComponent: situatedComponentHashMap.values()){
            if (resClass.isInstance(situatedComponent.getView())){
                return Optional.of((T) situatedComponent.getView());
            }
        }
        return Optional.empty();
    }

    protected abstract OverlayFactoryProducer getOverlayFactoryProducer();
}
