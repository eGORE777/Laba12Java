package Dog;

public class Alabai extends Dog {
    private String SizeType;

    public Alabai() {
        super();
        this.SizeType = "Большая";
    }

    public Alabai(String name, int age, String SizeType) {
        super(name, age);
        this.SizeType = SizeType;
    }

    public String getSizeType() {
        return SizeType;
    }

    public void setSizeType(String sizeType) {
        this.SizeType = sizeType;
    }


    public void getStick() {
        System.out.println(getName() + " приносит палку");
    }

    @Override
    public void bark() {
        System.out.println(getName() + " говорит: г а в");
    }

    @Override
    public String getInfo() {
        return "Алабай: " + getName() + ", Возраст: " + getAge() +
                " лет, Размер: " + SizeType;
    }
}