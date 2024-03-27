package strategy;

public class TripMethodStrategy {
    private WyTour wyTour;

    public TripMethodStrategy(int i){
        wyTour = new WyTour();
        if (i == 1){
            wyTour.setTripMethod(new ByCar());
            wyTour.goOut();
        }else if (i == 2){
            wyTour.setTripMethod(new ByTrain());
            wyTour.goOut();
        }else if (i == 3) {
            wyTour.setTripMethod(new SelfDrive());
            wyTour.goOut();
        }

    }
}
