package org.snowcorp.textview;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by Akshay Raj on 28-04-2017.
 * akshay@snowcorp.org
 * www.snowcorp.org
 */

class FontCache {

    private static Hashtable<String, Typeface> fontCache = new Hashtable<>();

    static Typeface get(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if(tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            }
            catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}