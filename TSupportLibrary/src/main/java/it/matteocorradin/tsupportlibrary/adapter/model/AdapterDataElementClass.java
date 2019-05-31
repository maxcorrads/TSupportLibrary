package it.matteocorradin.tsupportlibrary.adapter.model;

import java.util.ArrayList;

public class AdapterDataElementClass {

    private static final ArrayList<String> elements
            = new ArrayList<>();

    public static void addADET(String adet){
        if (!elements.contains(adet)){
            elements.add(adet);
        }
    }

    public static IAdapterDataElementType getADET(final int n){
        final String adet = elements.get(n);
        return new IAdapterDataElementType() {
            @Override
            public String getName() {
                return adet;
            }

            @Override
            public int getId() {
                return n;
            }
        };
    }

}
