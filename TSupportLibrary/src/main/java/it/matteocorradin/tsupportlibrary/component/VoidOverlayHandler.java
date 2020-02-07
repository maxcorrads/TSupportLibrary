package it.matteocorradin.tsupportlibrary.component;

public class VoidOverlayHandler implements OverlayHandler {

    public static VoidOverlayHandler newInstance(){
        return new VoidOverlayHandler();
    }

    @Override
    public void clickAction(SituatedComponent sender) {

    }

    @Override
    public boolean isOverlayEnabled() {
        return true;
    }

}
