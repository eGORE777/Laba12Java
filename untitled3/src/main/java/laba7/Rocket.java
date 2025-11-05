package laba7;


public class Rocket extends SpaceObject {

    private int maxSpeed;
    private String fuelType;

    public Rocket(String name, double weight, int maxSpeed, String fuelType) {
        super(name, weight);
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    @Override
    public void launch() {
        System.out.printf(" Ракета '%s' запущена.%n", getName());
        System.out.printf("   Максимальная скорость: %d км/с%n", maxSpeed);
        System.out.printf("   Тип топлива: %s%n", fuelType);
        System.out.println("   Обратный отсчет: 3,2,1 - Запуск");
        System.out.println("   Ракета успешно вышла на орбиту.\n");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getFuelType() {
        return fuelType;
    }
}