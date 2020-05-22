import java.util.Objects;

public class Bank {
    // 假设一个账户有1000块钱
    static double money = 1000;
    // 柜台Counter取钱的方法
    private void Counter(double money) {
        Bank.money -= money;
        System.out.println("柜台取钱" + money + "元，还剩" + Bank.money + "元！");
    }
    // ATM取钱的方法
    private void ATM(double money) {
        Bank.money -= money;
        System.out.println("ATM取钱" + money + "元，还剩" + Bank.money + "元！");
    }

    //提供一个对外取款途径，防止直接调取方法同时取款时，并发余额显示错误
    public synchronized void outMoney(double money, String mode) throws Exception{
        if(money > Bank.money){
            //校验余额是否充足
            throw new Exception("取款金额"+money+",余额只剩"+Bank.money+"，取款失败");
        }
        if(Objects.equals(mode, "ATM")){
            ATM(money);
        } else {
            Counter(money);
        }
    }}
 
