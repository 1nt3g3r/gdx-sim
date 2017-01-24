package com.integer.gdx.sim;

import com.badlogic.gdx.utils.ObjectMap;

public class Data {
    private ObjectMap<String, Integer> ints = new ObjectMap<String, Integer>();
    private ObjectMap<String, Float> floats = new ObjectMap<String, Float>();
    private ObjectMap<String, Boolean> booleans = new ObjectMap<String, Boolean>();
    private ObjectMap<String, String> strings = new ObjectMap<String, String>();

    public void setInt(String key, int value) {
        ints.put(key, value);
    }

    public int getInt(String key) {
        return getInt(key, 0);
    }

    public int getInt(String key, int defValue) {
        if (!ints.containsKey(key)) {
            ints.put(key, defValue);
        }
        return ints.get(key);
    }

    public void removeInt(String key) {
        ints.remove(key);
    }

    public void changeInt(String key, int amount) {
        setInt(key, getInt(key) + amount);
    }

    public void setFloat(String key, float value) {
        floats.put(key, value);
    }

    public float getFloat(String key) {
        return getFloat(key, 0);
    }

    public float getFloat(String key, float defValue) {
        if (!floats.containsKey(key)) {
            floats.put(key, defValue);
        }
        return floats.get(key);
    }

    public void removeFloat(String key) {
        floats.remove(key);
    }

    public void changeFloat(String key, float amount) {
        setFloat(key, getFloat(key) + amount);
    }

    public void setBoolean(String key, boolean value) {
        booleans.put(key, value);
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defValue) {
        if (!booleans.containsKey(key)) {
            booleans.put(key, defValue);
        }
        return booleans.get(key);
    }

    public void removeBoolean(String key) {
        booleans.remove(key);
    }

    public void setString(String key, String value) {
        strings.put(key, value);
    }

    public String getString(String key) {
        return getString(key, "");
    }

    public String getString(String key, String defValue) {
        if (!strings.containsKey(key)) {
            strings.put(key, defValue);
        }
        return strings.get(key);
    }

    public void removeString(String key) {
        strings.remove(key);
    }
}
