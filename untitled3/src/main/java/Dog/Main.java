package Dog;

public class Main {
    public static void main(String[] args) {

        Dog[] dogs = {
                new Alabai("Барон", 3, "Очень большая"),
                new Ovcharka("Астра", 4, "Черно-коричневая"),
                new Taksa("Бублик", 2),
                new Dog("Шарик", 5)
        };


        for (Dog dog : dogs) {
            System.out.println("=== " + dog.getClass().getSimpleName() + " ===");
            System.out.println(dog.getInfo());
            dog.bark();


            if (dog instanceof Alabai) {
                ((Alabai) dog).getStick();
            } else if (dog instanceof Ovcharka) {
                ((Ovcharka) dog).guard();
            } else if (dog instanceof Taksa) {
                ((Taksa) dog).walk();
            }

            System.out.println();
        }



        Alabai alabai = new Alabai("Пончик", 4, "Гигантская");
        System.out.println("Размер алабая: " + alabai.getSizeType());
        alabai.setAge(5);
        System.out.println("Обновленный возраст: " + alabai.getAge() + " лет");

        Ovcharka ovcharka = new Ovcharka();
        ovcharka.setName("Бобик");
        ovcharka.setColor("Рыжая");
        System.out.println("\nНовая овчарка: " + ovcharka.getInfo());

        Taksa taksa = new Taksa();
        taksa.setName("Малыш");
        taksa.setAge(1);
        System.out.println("Такса: " + taksa.getInfo());
    }
}