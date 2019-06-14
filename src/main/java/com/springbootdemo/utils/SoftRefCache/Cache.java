package com.springbootdemo.utils.SoftRefCache;

public interface Cache<K,V> {
   public V get(K key);
   public boolean set(K key,V value);
}
