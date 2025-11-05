package laba7;


public class Satellite extends SpaceObject {

    private String purpose;
    private int orbitHeight;

    public Satellite(String name, double weight, String purpose, int orbitHeight) {
        super(name, weight);
        this.purpose = purpose;
        this.orbitHeight = orbitHeight;
    }

    @Override
    public void launch() {
        System.out.printf("  Спутник '%s' запущен.%n", getName());
        System.out.printf("   Назначение: %s%n", purpose);
        System.out.printf("   Высота орбиты: %d км%n", orbitHeight);
        System.out.println("   Развертывание солнечных панелей...");
        System.out.println("   Калибровка оборудования...");
        System.out.println("   Спутник успешно начал работу.\n");
    }

    public String getPurpose() {
        return purpose;
    }

    public int getOrbitHeight() {
        return orbitHeight;
    }
}