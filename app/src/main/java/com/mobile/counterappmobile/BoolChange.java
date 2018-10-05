package com.mobile.counterappmobile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ibrahim on 09/04/2018.
 */

//listen for boolean change
interface ConnectionBooleanChangedListener {
    public void OnMyBooleanChanged();
}

public class BoolChange {
    private static boolean myBoolean;
    private static List<ConnectionBooleanChangedListener> listeners = new ArrayList<ConnectionBooleanChangedListener>();

    public static boolean getMyBoolean() { return myBoolean; }

    public static void setMyBoolean(boolean value) {
        myBoolean = value;

        for (ConnectionBooleanChangedListener l : listeners) {
            l.OnMyBooleanChanged();
        }
    }

    public static void addMyBooleanListener(ConnectionBooleanChangedListener l) {
        listeners.add(l);
    }
}