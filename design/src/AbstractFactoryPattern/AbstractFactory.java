package AbstractFactoryPattern;

import fact.Shape;

public abstract class AbstractFactory {
    public abstract color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
