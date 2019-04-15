package shejimoshi.Strategy;

public class Contex {
    Strategy strategy;

    public Contex(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void celue(){
        strategy.celue();
    }
}
