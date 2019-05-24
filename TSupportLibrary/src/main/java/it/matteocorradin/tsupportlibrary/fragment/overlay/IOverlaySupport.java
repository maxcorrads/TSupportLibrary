package it.matteocorradin.tsupportlibrary.fragment.overlay;

import it.matteocorradin.tsupportlibrary.Optional;
import it.matteocorradin.tsupportlibrary.OverlayViewSupportActivity;

public interface IOverlaySupport {
    Optional<OverlayViewSupportActivity> getBaseActivity();
    boolean hideSoftInputBase();
}
