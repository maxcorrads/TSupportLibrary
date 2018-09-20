package it.matteocorradin.tsupportlibrary;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.util.HashMap;

/**
 * Created by matteocorradin on 09/01/18.
 */

public class SizeUtils {

    private static HashMap<String, Object> cache = new HashMap<>();

    private static Float getCachedValueFloat(String key){
        Object cachedValue = cache.get(key);
        if (cachedValue != null){
            if (cachedValue instanceof Float) {
                return (Float) cachedValue;
            }
        }
        return null;
    }

    private static Integer getCachedValueInt(String key){
        Object cachedValue = cache.get(key);
        if (cachedValue != null){
            if (cachedValue instanceof Integer) {
                return (Integer) cachedValue;
            }
        }
        return null;
    }

    public static float dipToPixels(Context context, float dipValue) {
        String key = "dp"+dipValue;
        Float value = getCachedValueFloat(key);
        if (value != null){
            return value;
        }else{
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            float calc = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
            cache.put(key, calc);
            return calc;
        }
    }

    public static float dipToPixels(Context context, Double dipValue) {
        return dipToPixels(context, dipValue.floatValue());
    }

    public static int dipToPixelsInt(Context context, float dipValue) {
        String key = "dp"+dipValue;
        Float value = getCachedValueFloat(key);
        if (value != null){
            return value.intValue();
        }else{
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            float calc = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
            cache.put(key, calc);
            return (int)calc;
        }
    }

    public static float spToPixelsFloat(float sp, Context context) {
        String key = "sp"+sp;
        Float value = getCachedValueFloat(key);
        if (value != null){
            return value;
        }else{
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            float calc = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
            cache.put(key, calc);
            return calc;
        }
    }

    public static int spToPixels(float sp, Context context) {
        String key = "sp"+sp;
        Float value = getCachedValueFloat(key);
        if (value != null){
            return value.intValue();
        }else{
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            float calc = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
            cache.put(key, calc);
            return (int) calc;
        }
    }

}
