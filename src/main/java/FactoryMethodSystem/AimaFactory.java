package FactoryMethodSystem;

public class AimaFactory implements EBikesFactory{
    @Override
    public EBikes createEBikes() {
        return new Aima();
    }
}
