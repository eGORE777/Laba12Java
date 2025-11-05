package laba11;

import java.io.*;
import java.util.Random;

public class Zadanie3 {

    static void prn(String arg) {
        System.out.println(arg);
    }

    public static void main(String arg[]) throws Exception {
        OutputStream fi0 = new FileOutputStream("numbers.txt");
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            int number = rand.nextInt(201) - 50;
            String numStr = String.valueOf(number);
            if (i < 19) numStr += " ";
            fi0.write(numStr.getBytes());
        }
        fi0.close();
        prn("Файл с числами создан");


        InputStream fi1 = new FileInputStream("numbers.txt");
        int size = fi1.available();
        byte numBuf[] = new byte[size];
        fi1.read(numBuf);
        fi1.close();

        String numbersStr = new String(numBuf, 0, size);
        String[] numbers = numbersStr.split(" ");


        OutputStream negStream = new FileOutputStream("negative.txt");
        OutputStream lowStream = new FileOutputStream("low_range.txt");
        OutputStream midStream = new FileOutputStream("mid_range.txt");
        OutputStream highStream = new FileOutputStream("high_range.txt");

        for (String numStr : numbers) {
            try {
                int number = Integer.parseInt(numStr.trim());


                if (number < 0) {
                    negStream.write((numStr + " ").getBytes());
                } else if (number >= 0 && number <= 50) {
                    lowStream.write((numStr + " ").getBytes());
                } else if (number > 50 && number <= 100) {
                    midStream.write((numStr + " ").getBytes());
                } else {
                    highStream.write((numStr + " ").getBytes());
                }
            } catch (NumberFormatException e) {
                prn("Ошибка числа: " + numStr);
            }
        }


        negStream.close();
        lowStream.close();
        midStream.close();
        highStream.close();

        prn("Числа разделены по файлам:");
        prn("- negative.txt: отрицательные числа");
        prn("- low_range.txt: 0-50");
        prn("- mid_range.txt: 51-100");
        prn("- high_range.txt: больше 100");
    }
}