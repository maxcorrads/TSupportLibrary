package it.matteocorradin.tsupportlibrary.fragment;

public abstract class BottomSheetDialogMListValueFragment<H> extends BottomSheetDialogMListFragment {
    public interface BottomSheetDialogBaseValueFragmentListener<H>{
        void onCloseWithValue(H value);
    }

    protected BottomSheetDialogBaseValueFragmentListener<H> valueListener;
    public void setValueListener(BottomSheetDialogBaseValueFragmentListener<H> valueListener) {
        this.valueListener = valueListener;
    }
}
