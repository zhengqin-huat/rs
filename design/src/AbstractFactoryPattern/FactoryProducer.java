package AbstractFactoryPattern;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
    if(choice.equalsIgnoreCase("SHAPE")){
        return new shapeFactory();
    } else if(choice.equalsIgnoreCase("COLOR")){
        return new colorFactory();
    }
    return null;

}
}
