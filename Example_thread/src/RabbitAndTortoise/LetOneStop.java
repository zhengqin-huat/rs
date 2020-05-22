package RabbitAndTortoise;

public class LetOneStop implements Animal.Calltoback {


    Animal an;

    // 获取动物对象，可以传入兔子或乌龟的实例
    public LetOneStop(Animal an) {
        this.an = an;
    }

    // 让动物的线程停止
    @Override
    public void win() {
        // 线程停止
        an.stop();
    }


}
