package shejimoshi.builder;

//建造者接口
public interface Builder {
    void buildHead();
    void buildBody();
    PeoPle createPeople();
}
