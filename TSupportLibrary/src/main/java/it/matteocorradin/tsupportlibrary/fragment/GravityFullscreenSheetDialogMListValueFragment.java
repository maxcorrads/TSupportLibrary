package it.matteocorradin.tsupportlibrary.fragment;

public abstract class GravityFullscreenSheetDialogMListValueFragment<H> extends GravityFullscreenSheetDialogMListFragment {
    public interface GravityFullscreenSheetDialogBaseValueFragmentListener<H>{
        void onCloseWithValue(H value);
    }

    protected GravityFullscreenSheetDialogBaseValueFragment.GravityFullscreenSheetDialogBaseValueFragmentListener<H> valueListener;
    public void setValueListener(GravityFullscreenSheetDialogBaseValueFragment.GravityFullscreenSheetDialogBaseValueFragmentListener<H> valueListener) {
        this.valueListener = valueListener;
    }
}
