package laba11;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class NumberRangeSplitter {
    public static void main(String[] args) {
        try {

            Path sourceFile = Paths.get("numbers.txt");
            Random random = new Random();


            StringBuilder numbersContent = new StringBuilder();
            System.out.println("=== ГЕНЕРАЦИЯ ЧИСЕЛ ===");
            for (int i = 0; i < 20; i++) {
                int number = random.nextInt(151) - 50; // от -50 до 100
                numbersContent.append(number).append("\n");
                System.out.println("Сгенерировано число: " + number);
            }

            Files.writeString(sourceFile, numbersContent.toString(), StandardOpenOption.CREATE);
            System.out.println("✓ Исходный файл создан: " + sourceFile.toAbsolutePath());


            List<String> lines = Files.readAllLines(sourceFile);
            List<Integer> numbers = new ArrayList<>();

            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    numbers.add(Integer.parseInt(line.trim()));
                }
            }


            List<Integer> negativeNumbers = new ArrayList<>();
            List<Integer> zeroToFifty = new ArrayList<>();
            List<Integer> fiftyOneToHundred = new ArrayList<>();
            List<Integer> aboveHundred = new ArrayList<>();

            for (int number : numbers) {
                if (number < 0) {
                    negativeNumbers.add(number);
                } else if (number >= 0 && number <= 50) {
                    zeroToFifty.add(number);
                } else if (number > 50 && number <= 100) {
                    fiftyOneToHundred.add(number);
                } else {
                    aboveHundred.add(number);
                }
            }


            System.out.println("\n=== СОЗДАНИЕ ФАЙЛОВ ===");
            writeNumbersToFile(negativeNumbers, "negative_numbers.txt", "Отрицательные числа");
            writeNumbersToFile(zeroToFifty, "0_to_50.txt", "Числа от 0 до 50");
            writeNumbersToFile(fiftyOneToHundred, "51_to_100.txt", "Числа от 51 до 100");
            writeNumbersToFile(aboveHundred, "above_100.txt", "Числа больше 100");


            System.out.println("\n=== СТАТИСТИКА ===");
            System.out.println("Всего чисел: " + numbers.size());
            System.out.println("Отрицательных чисел: " + negativeNumbers.size() + " " + negativeNumbers);
            System.out.println("Чисел от 0 до 50: " + zeroToFifty.size() + " " + zeroToFifty);
            System.out.println("Чисел от 51 до 100: " + fiftyOneToHundred.size() + " " + fiftyOneToHundred);
            System.out.println("Чисел больше 100: " + aboveHundred.size() + " " + aboveHundred);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: неверный формат числа в файле");
        }
    }

    private static void writeNumbersToFile(List<Integer> numbers, String fileName, String description)
            throws IOException {
        if (!numbers.isEmpty()) {
            Path filePath = Paths.get(fileName);
            StringBuilder content = new StringBuilder(description + ":\n");

            for (int number : numbers) {
                content.append(number).append("\n");
            }

            Files.writeString(filePath, content.toString(), StandardOpenOption.CREATE);
            System.out.println("✓ Создан файл: " + filePath.getFileName() +
                    " (чисел: " + numbers.size() + ")");
        } else {
            System.out.println("✗ Файл " + fileName + " не создан (нет чисел в диапазоне)");
        }
    }
}