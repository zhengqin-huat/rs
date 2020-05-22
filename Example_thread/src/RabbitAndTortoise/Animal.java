package RabbitAndTortoise;


public abstract class Animal extends Thread {
    public int length = 6;// 比赛长度


    public abstract void runing();

    @Override
    public void run() {
        super.run();
        while (length > 0) {
            runing();
        }
    }

    // 在需要回调数据的地方（两个子类需要），声明一个接口
    public static interface Calltoback {
        public void win();
    }

    // 2.创建接口对象
    public Calltoback calltoback;
}