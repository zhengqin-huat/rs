package AbstractFactoryPattern;

import fact.Circle;
import fact.Shape;
import fact.Square;

public class shapeFactory extends AbstractFactory{
    @Override
    public color getColor(String color) {

        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape==null){
            return null;
        }else if (shape.equalsIgnoreCase("circle")){
            return new Circle();
        }else if (shape.equalsIgnoreCase("square")){
            return new Square();
        }

            return null;
    }
}
