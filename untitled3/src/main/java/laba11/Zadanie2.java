package laba11;

import java.io.*;

public class Zadanie2 {

    static void prn(String arg) {
        System.out.println(arg);
    }


    static byte[] getInput() throws Exception {
        byte buf[] = new byte[150];
        int bytesRead = 0;
        System.out.println("Введите 15 температур (с пробелом):");

        while (bytesRead < 50) {
            int byteValue = System.in.read();
            if (byteValue == '\n') break;
            buf[bytesRead++] = (byte) byteValue;
        }
        return buf;
    }

    public static void main(String arg[]) throws Exception {

        byte buf[] = getInput();
        OutputStream fi0 = new FileOutputStream("temperatures.txt");
        fi0.write(buf);
        fi0.close();


        InputStream fi1 = new FileInputStream("temperatures.txt");
        int size = fi1.available();
        byte tempBuf[] = new byte[size];
        fi1.read(tempBuf);
        fi1.close();

        String tempStr = new String(tempBuf, 0, size);
        String[] temps = tempStr.trim().split(" ");

        double sum = 0;
        int count = 0;
        prn("Считанные температуры:");

        for (String temp : temps) {
            if (!temp.isEmpty()) {

                String normalizedTemp = temp.replace(',', '.');
                try {
                    double temperature = Double.parseDouble(normalizedTemp);
                    prn("Температура " + (count + 1) + ": " + temperature);
                    sum += temperature;
                    count++;
                } catch (NumberFormatException e) {
                    prn("Ошибка формата: " + temp);
                }
            }
        }

        if (count > 0) {
            double average = sum / count;
            prn("Средняя температура: " + average);
        } else {
            prn("Нет корректных температур для расчета");
        }
    }
}