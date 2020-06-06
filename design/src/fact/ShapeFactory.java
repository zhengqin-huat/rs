package fact;

public class ShapeFactory {


    public static Shape getShape(String shapeType){
        if (shapeType==null){
            return null;
        }
        if (shapeType.equalsIgnoreCase("Circle")){
            return new Circle();
        }
        if (shapeType.equalsIgnoreCase("square")){
            return new Square();
        }
        return null;
    }

}
