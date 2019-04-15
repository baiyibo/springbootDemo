package shejimoshi.Strategy;

import shejimoshi.OB.ObUser;
import shejimoshi.OB.User;
import shejimoshi.OB.WechatServer;
/*
* 重点在于：给对象传入什么样的策略，就执行什么样的动作。
优点在于：可以轻易的扩展与改变策略，可以动态改变对象的行为。
缺点在于：客户端必须知道所有的策略类，并自行决定使用哪一种。每个具体的策略都会产生一个新类，这样会造成很多策略类。
*
* */
public class Test {
    public static void main(String[] args) {
        Contex contex=new Contex(new Strategy1());
        contex.celue();
        contex.setStrategy(new Strategy2());
        contex.celue();

    }
}
