package Singleton;

public class singletondemo {
    public static void main(String[] args) {
        SingleObj singleObj = SingleObj.getsingerObj();
        singleObj.showMessage();
    }
}
