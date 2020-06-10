package Strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        Context context = new Context(new addOp());
        System.out.println("10 + 5 = " + context.eStrategy(10, 5));

        context = new Context(new subOp());
        System.out.println("10 - 5 = " + context.eStrategy(10, 5));
    }
}