package Strategy;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public int eStrategy(int num1, int num2){
        return strategy.opration(num1,num2);
    }
}
