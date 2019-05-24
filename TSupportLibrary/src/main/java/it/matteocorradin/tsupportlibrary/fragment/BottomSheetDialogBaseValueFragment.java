package it.matteocorradin.tsupportlibrary.fragment;

public abstract class BottomSheetDialogBaseValueFragment<H> extends BottomSheetDialogBaseFragment {
    public interface BottomSheetDialogBaseValueFragmentListener<H>{
        void onCloseWithValue(H value);
    }

    protected BottomSheetDialogBaseValueFragmentListener<H> valueListener;
    public void setValueListener(BottomSheetDialogBaseValueFragmentListener<H> valueListener) {
        this.valueListener = valueListener;
    }
}
