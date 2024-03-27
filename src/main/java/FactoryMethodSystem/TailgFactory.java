package FactoryMethodSystem;

public class TailgFactory implements EBikesFactory{
    @Override
    public EBikes createEBikes() {
        return new Tailg();
    }
}
