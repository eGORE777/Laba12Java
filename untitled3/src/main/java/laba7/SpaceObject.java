package laba7;


public abstract class SpaceObject {

    private String name;
    private double weight;

    public SpaceObject(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }


    public abstract void launch();


    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return String.format("%s (вес: %.2f кг)", name, weight);
    }
}