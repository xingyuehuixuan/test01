package Decorate;

public class Painting {
    private String name;
    public Painting() {
    }

    public Painting(String name) {
        this.name = name;
    }
    public void display(){
        System.out.println(this.name + "被挂在墙上");
    }
}
