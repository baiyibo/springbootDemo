package shejimoshi.proxy.staticProxy;

public class SingerMan implements Singer{
    @Override
    public void sing(String name) {
     System.out.println(name+" is sing......");
    }
}
