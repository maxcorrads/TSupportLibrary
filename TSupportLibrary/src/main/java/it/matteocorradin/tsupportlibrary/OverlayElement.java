package it.matteocorradin.tsupportlibrary;

import it.matteocorradin.tsupportlibrary.component.OverlayFactoryEnum;

public class OverlayElement {
    public Integer getTag() {
        return tag;
    }

    public OverlayFactoryEnum getFactoryEnum() {
        return factoryEnum;
    }

    private final Integer tag;
    private final OverlayFactoryEnum factoryEnum;

    public OverlayElement(Integer tag, OverlayFactoryEnum factoryEnum) {
        this.tag = tag;
        this.factoryEnum = factoryEnum;
    }
}
