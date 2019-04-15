package shejimoshi.builder;

/*
具体建造者
/人1   头脑好 身体一般
 */
public class BuilderImpl1  implements Builder{
    PeoPle p1;

    public BuilderImpl1() {
        p1=new PeoPle();
    }

    @Override
    public void buildHead() {
        p1.setHead("100分头");
    }

    @Override
    public void buildBody() {
     p1.setBody("60分身体");
    }

    @Override
    public PeoPle createPeople() {
        return p1;
    }
}
