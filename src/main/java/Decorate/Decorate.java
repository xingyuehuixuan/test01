package Decorate;

public class Decorate extends Painting{
    protected Painting painting;
    public void decorate(Painting painting){
        this.painting = painting;
    }
    public void display(){
        if (painting != null){
            painting.display();
        }
    }
}
