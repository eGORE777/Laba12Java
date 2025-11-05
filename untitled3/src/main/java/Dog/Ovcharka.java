package Dog;

public class Ovcharka extends Dog {
    private String color;

    public Ovcharka() {
        super();
        this.color = "Коричневая";
    }

    public Ovcharka(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void guard() {
        System.out.println(getName() + " Сторожит дом");
    }

    @Override
    public void bark() {
        System.out.println(getName() + " говорит: Гав-гав-гав!");
    }

    @Override
    public String getInfo() {
        return "Овчарка: " + getName() + ", Возраст: " + getAge() +
                " лет, Окрас: " + color;
    }
}