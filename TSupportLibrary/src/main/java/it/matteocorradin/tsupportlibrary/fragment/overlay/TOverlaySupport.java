package it.matteocorradin.tsupportlibrary.fragment.overlay;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.FragmentActivity;

import java.util.List;

import it.matteocorradin.tsupportlibrary.Optional;
import it.matteocorradin.tsupportlibrary.OverlayViewSupportActivity;
import it.matteocorradin.tsupportlibrary.component.OverlayAbstractFactory;
import it.matteocorradin.tsupportlibrary.component.OverlayHandler;

public class TOverlaySupport implements IOverlaySupport {

    private OverlayHandler overlayHandler;
    private List<OverlayAbstractFactory> overlayElementList;
    private FragmentActivity fragmentActivity;
    private View view;
    private Context context;

    public TOverlaySupport(OverlayHandler overlayHandler, List<OverlayAbstractFactory> overlayElementList, FragmentActivity fragmentActivity, View view, Context context) {
        this.overlayHandler = overlayHandler;
        this.overlayElementList = overlayElementList;
        this.fragmentActivity = fragmentActivity;
        this.view = view;
        this.context = context;
        initView();
    }

    @Override
    public Optional<OverlayViewSupportActivity> getBaseActivity() {
        if (fragmentActivity instanceof OverlayViewSupportActivity) {
            OverlayViewSupportActivity activity = (OverlayViewSupportActivity) fragmentActivity;
            return Optional.of(activity);
        }
        return Optional.empty();
    }

    protected void initView(){
        getBaseActivity().ifPresent(new Optional.Action<OverlayViewSupportActivity>() {
            @Override
            public void apply(OverlayViewSupportActivity activity) {
                activity.addOverlay(overlayElementList);
                activity.setOverlayHandler(overlayHandler);
            }
        });
    }

    public boolean hideSoftInputBase() {
        if (context != null && view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            return imm != null && imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return false;
    }

}
