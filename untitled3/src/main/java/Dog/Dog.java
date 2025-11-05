package Dog;

public class Dog {

    private String name;


    private int age;


    public Dog() {
        this.name = "Неизвестно";
        this.age = 0;
    }


    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }


    public void bark() {
        System.out.println(name + " говорит: Гав-гав!");
    }


    public String getInfo() {
        return "Собака: " + name + ", Возраст: " + age + " лет";
    }

    @Override
    public String toString() {
        return getInfo();
    }
}