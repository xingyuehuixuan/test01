package strategy;

public class WyTour {
    private TripMethod tripMethod;

    public TripMethod getTripMethod() {
        return tripMethod;
    }

    public void setTripMethod(TripMethod tripMethod) {
        this.tripMethod = tripMethod;
    }

    public void goOut(){
        tripMethod.tripMethod();
    }
}
