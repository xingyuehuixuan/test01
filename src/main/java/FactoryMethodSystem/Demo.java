package FactoryMethodSystem;

public class Demo {
    public static void main(String[] args) {
        EBikesFactory eBikesFactory = new AimaFactory();
        EBikes aima = eBikesFactory.createEBikes();
        aima.bike();
        EBikesFactory eBikesFactory1 = new YadeaFactory();
        EBikes yadea = eBikesFactory1.createEBikes();
        yadea.bike();
        EBikesFactory eBikesFactory2 = new TailgFactory();
        EBikes tailg = eBikesFactory2.createEBikes();
        tailg.bike();
    }
}
