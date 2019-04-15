package shejimoshi.builder;

//指挥者（导演者）
public class Director {

    public PeoPle createPeoPle(Builder builder){
        builder.buildBody();
        builder.buildHead();
       return builder.createPeople();
    }
}
