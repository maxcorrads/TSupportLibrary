package it.matteocorradin.tsupportlibrary.adapter.model;

import java.util.concurrent.ConcurrentHashMap;

public class AdapterDataElementClass {

    private static class ADETWithPosition{
        private final IAdapterDataElementType adet;
        private final int position;

        private ADETWithPosition(IAdapterDataElementType adet, int position) {
            this.adet = adet;
            this.position = position;
        }

        public IAdapterDataElementType getAdet() {
            return adet;
        }

        public int getPosition() {
            return position;
        }

    }

    private static final ConcurrentHashMap<String, ADETWithPosition> elements
            = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, ADETWithPosition> elementsPos
            = new ConcurrentHashMap<>();

    public synchronized static int addADET(IAdapterDataElementType adet){
        ADETWithPosition element;
        if (elements.containsKey(adet.getName())) {
            element = elements.get(adet.getName());
        } else {
            int pos = elements.size();
            element = new ADETWithPosition(adet, pos);
            elements.put(adet.getName(), element);
            elementsPos.put(pos, element);
        }
        assert element != null;
        return element.position;
    }

    public static IAdapterDataElementType getADET(final int n){
        ADETWithPosition element = elementsPos.get(n);
        assert element != null;
        return element.adet;
    }

}
