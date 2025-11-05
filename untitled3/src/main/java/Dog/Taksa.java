package Dog;

public class Taksa extends Dog {

    public Taksa() {
        super();
    }

    public Taksa(String name, int age) {
        super(name, age);
    }

    public void walk() {
        System.out.println(getName() + " Гуляет");
    }

    @Override
    public void bark() {
        System.out.println(getName() + " говорит: Гав!");
    }

    @Override
    public String getInfo() {
        return "Такса: " + getName() + ", Возраст: " + getAge() + " лет";
    }
}