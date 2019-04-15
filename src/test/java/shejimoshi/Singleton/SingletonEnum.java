package shejimoshi.Singleton;

public enum SingletonEnum {
    /**
     * 定义一个枚举的元素，它就代表了Singleton的一个实例。
     */
    SINGLETON;
    /**
     * 单例可以有自己的操作
     */
    public void singletonOperation(){
        //功能处理
        System.out.println("枚举实现单例");
    }
}
