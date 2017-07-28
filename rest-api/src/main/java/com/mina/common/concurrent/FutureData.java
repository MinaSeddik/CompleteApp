package com.mina.common.concurrent;

/**
 * Created by menai on 2017-07-21.
 */
public class FutureData<K, V> {

    private K key;
    private V value;

    private boolean fail = false;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean isFail() {
        return fail;
    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }

}
