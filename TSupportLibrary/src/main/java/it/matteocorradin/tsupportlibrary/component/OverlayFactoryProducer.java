package it.matteocorradin.tsupportlibrary.component;

import androidx.annotation.NonNull;

public abstract class OverlayFactoryProducer {

    @NonNull
    public abstract OverlayAbstractFactory getFactory(OverlayFactoryEnum factoryEnum);

}
