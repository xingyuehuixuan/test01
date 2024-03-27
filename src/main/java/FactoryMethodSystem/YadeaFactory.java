package FactoryMethodSystem;

public class YadeaFactory implements EBikesFactory{
    @Override
    public EBikes createEBikes() {
        return new Yadea();
    }
}
