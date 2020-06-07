package AbstractFactoryPattern;

import fact.Circle;
import fact.Shape;
import fact.Square;

public class colorFactory extends AbstractFactory{
    @Override
    public color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {

            return null;
    }
}
