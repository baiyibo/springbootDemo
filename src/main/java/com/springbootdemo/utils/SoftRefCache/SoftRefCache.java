package com.springbootdemo.utils.SoftRefCache;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentHashMap;

//抽象类实现cache接口  get set 方法  抽象方法createval 每个子类必须自己实现自己的创建新value的方法
public abstract   class SoftRefCache<K, V> implements Cache<K, V>{

    //缓存map
    private ConcurrentHashMap<K,MoreInfoReference<V>> cache=new ConcurrentHashMap<K,MoreInfoReference<V>>();

    //失效的软引用队列  （被回收的软引用存放的队列）
    private ReferenceQueue<V> queue =new ReferenceQueue<V>();

    public V get(K key) {
        V value = null;
        if(cache.containsKey(key)){
            //从缓存map 中 根据key取到对应软引用
            MoreInfoReference<V> softReference=cache.get(key);
           //对应的引用 .get方法获取
            value=softReference.get();
        }

        //引用为null则表示该 软引用已经被gc回收  需要重新创建新value返回(表示缓存中没有了 需要重新从原路查询并放入缓存)
        if(value==null){
            // 清除缓存中失效元素
            clearRefQueue();
            value = createValue(key);
           // 创建新引用放入缓存
            MoreInfoReference<V>  newRef= new MoreInfoReference<V>(key,value,queue);
           cache.put(key,newRef);
        }else{
            System.out.println("数据来自缓存");
        }



        return value;
    }

    public boolean set(K key, V value) {
        MoreInfoReference<V>  newRef= new MoreInfoReference<V>(key,value,queue);
        cache.put(key,newRef);
        return true;
    }

    /**
     * 定义创建值的方法
     * @return
     */
    protected abstract V createValue(K key);



    /**
     从软引用队列中移除无效引用(ReferenceQueue.poll 为出队列操作  ,意为返回弱引用对象的同时在队列中清除了该对象 )，
     * 同时从cache中删除无效缓存 map.remove
     */
    @SuppressWarnings("unchecked")
    protected void clearRefQueue() {
        MoreInfoReference<V> refValue = null;
        while((refValue = (MoreInfoReference<V>) queue.poll()) != null) {
            K key = (K) refValue.getInfo();
            cache.remove(key);
        }
    }

}
