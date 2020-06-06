package Singleton;

class SingleObj {
    private static SingleObj singerObj =new SingleObj();

    private SingleObj(){}

    public static SingleObj getsingerObj(){
        return singerObj;
    }

    public void showMessage(){
        System.out.println("Im singleleton!");
    }


}
