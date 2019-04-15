package shejimoshi.builder;

/*
/人2   头脑一般 身体好
 */
public class BuilderImpl2 implements Builder{
    PeoPle p2;

    public BuilderImpl2() {
        p2=new PeoPle();
    }

    @Override
    public void buildHead() {
        p2.setHead("60分头");
    }

    @Override
    public void buildBody() {
        p2.setBody("100分身体");
    }

    @Override
    public PeoPle createPeople() {
        return p2;
    }
}
