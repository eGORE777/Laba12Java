package laba11;

import java.io.*;

public class Zadanie1 {

    static void prn(String arg) {
        System.out.println(arg);
    }

    public static void main(String arg[]) {
        try {

            FileOutputStream fi0 = new FileOutputStream("personal_info.txt");
            String info = "Имя: Трофимов Егор Александрович\nРод деятельности: студент\nГруппа: Т-319";
            fi0.write(info.getBytes());
            fi0.close();

            prn("Файл создан успешно");


            File fileobj = new File("personal_info.txt");
            prn("Name of file: " + fileobj.getName());
            prn("Size of file: " + fileobj.length() + " Bytes");
            prn("Last modified: " + fileobj.lastModified());
            prn("Parent: " + fileobj.getParent());
            prn("Path: " + fileobj.getPath());
            prn("Abs Path: " + fileobj.getAbsolutePath());
            prn("File " + (fileobj.exists() ? "exists" : "not exist"));
            prn(fileobj.canRead() ? "can read" : "can't read");
            prn(fileobj.canWrite() ? "can write" : "can't write");
            prn("This is " + (fileobj.isDirectory() ? "" : "not") + " directory");
            prn("This is " + (fileobj.isAbsolute() ? "absolute" : "not absolute"));


            prn("\nFile content:");
            InputStream fio1 = new FileInputStream("personal_info.txt");
            int size = fio1.available();
            prn("Available Bytes: " + size);

            for (int cnt = 0; cnt < size; cnt++) {
                System.out.print((char) fio1.read());
            }
            fio1.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}