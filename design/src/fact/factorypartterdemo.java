package fact;
//工厂模式
public class factorypartterdemo {

    public static void main(String[] arge){

        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = ShapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();
        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = ShapeFactory.getShape("SQUARE");
        //调用 Square 的 draw 方法
        shape3.draw();

    }

}
