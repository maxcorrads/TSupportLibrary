package it.matteocorradin.tsupportlibrary.component;

import android.view.View;
import android.widget.RelativeLayout;

public class SituatedComponent implements ISituatedComponent{

    private final View mView;
    private final RelativeLayout.LayoutParams mParams;

    public SituatedComponent(View view, RelativeLayout.LayoutParams params) {
        this.mView = view;
        this.mParams = params;
    }

    public View getView() {
        return mView;
    }

    @Override
    public RelativeLayout.LayoutParams getParams() {
        return mParams;
    }

}
