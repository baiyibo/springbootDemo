package shejimoshi.builder;

/*
*优点：

使用建造者模式可以使客户端不必知道产品内部组成的细节。
具体的建造者类之间是相互独立的，这有利于系统的扩展。
具体的建造者相互独立，因此可以对建造的过程逐步细化，而不会对其他模块产生任何影响。

缺点：

建造者模式所创建的产品一般具有较多的共同点，其组成部分相似；如果产品之间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制。
如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大
*
* */
//客户
public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        PeoPle p1 = director.createPeoPle(new BuilderImpl1());
        PeoPle p2 = director.createPeoPle(new BuilderImpl2());

        System.out.println(p1.getHead()+"====="+p1.getBody());
        System.out.println(p2.getHead()+"====="+p2.getBody());

    }
}
