package com.springbootdemo.utils.SoftRefCache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class MoreInfoReference<T> extends SoftReference<T> {
    private Object info;
    public MoreInfoReference(Object info,T referent, ReferenceQueue<? super T> q) {
        super(referent, q);
        this.info=info;
    }

    public Object getInfo() {
        return this.info;
    }
}
