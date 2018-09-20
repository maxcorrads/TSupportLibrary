package it.matteocorradin.tsupportlibrary;

/**
 * Created by matteocorradin on 28/06/17.
 */

public interface InvokeTwoData<T,V,X>  {
    T call(V data, X value);
}