package laba7;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<SpaceObject> spaceObjects = new ArrayList<>();


        Rocket falcon9 = new Rocket("Falcon 9", 549000, 7, "Керосин + Жидкий кислород");
        Rocket soyuz = new Rocket("Союз", 308000, 8, "Керосин");


        Satellite hubble = new Satellite("Хаббл", 11110, "Космический телескоп", 547);
        Satellite gps = new Satellite("GPS Navstar", 2030, "Навигационная система", 20200);
        Satellite meteor = new Satellite("Метеор-М", 2700, "Метеорологический", 832);


        spaceObjects.add(falcon9);
        spaceObjects.add(soyuz);
        spaceObjects.add(hubble);
        spaceObjects.add(gps);
        spaceObjects.add(meteor);

        System.out.println("=== ЗАПУСК КОСМИЧЕСКИХ ОБЪЕКТОВ ===\n");


        for (SpaceObject obj : spaceObjects) {
            System.out.println("Подготовка к запуску: " + obj);
            obj.launch();
        }


        System.out.println("=== Полиморфизм ===");
        demonstratePolymorphism(spaceObjects);
    }


    private static void demonstratePolymorphism(List<SpaceObject> objects) {
        System.out.println("\nОбщее количество космических объектов: " + objects.size());

        int rockets = 0;
        int satellites = 0;

        for (SpaceObject obj : objects) {
            if (obj instanceof Rocket) {
                rockets++;
            } else if (obj instanceof Satellite) {
                satellites++;
            }
        }

        System.out.println("Ракет: " + rockets);
        System.out.println("Спутников: " + satellites);
    }
}