package laba11;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path filePath = Paths.get("temperatures.txt");

        try {
            System.out.println("=== Введите температуры (15 штук) ===");
            List<Double> temperatures = new ArrayList<>();

            for (int i = 1; i <= 15; i++) {
                System.out.print("Температура " + i + ": ");
                double temp = scanner.nextDouble();
                temperatures.add(temp);
            }


            StringBuilder sb = new StringBuilder();
            for (Double temp : temperatures) {
                sb.append(temp).append("\n");
            }

            Files.writeString(filePath, sb.toString(), StandardOpenOption.CREATE);
            System.out.println("✓ Температуры сохранены в файл: " + filePath.toAbsolutePath());


            List<String> lines = Files.readAllLines(filePath);
            double sum = 0;
            int count = 0;

            System.out.println("\n=== температуры в файле ===");
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    try {
                        double temperature = Double.parseDouble(line.trim());
                        System.out.printf("Температура: %.2f°C\n", temperature);
                        sum += temperature;
                        count++;
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка формата в строке: '" + line + "'");
                    }
                }
            }

            if (count > 0) {
                double average = sum / count;
                System.out.println("\n=== РЕЗУЛЬТАТ ===");
                System.out.printf("Средняя температура: %.2f°C\n", average);
                System.out.println("Обработано записей: " + count);
            } else {
                System.out.println("Нет данных для расчета средней температуры");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}