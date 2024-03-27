package Decorate;

public class DecorateTest {
    public static void main(String[] args) {
        Painting painting = new Painting("蒙娜丽莎的微笑");
        Glazing glazing = new Glazing();
        PutInFrame putInFrame = new PutInFrame();
        glazing.decorate(painting);
        putInFrame.decorate(glazing);
        putInFrame.display();
    }
}
