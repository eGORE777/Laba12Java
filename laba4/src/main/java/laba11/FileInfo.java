package laba11;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileInfo {
    public static void main(String[] args) {
        try {

            Path filePath = Paths.get("personal_info.txt");
            String personalInfo = """
                ФИО: Трофимов Егор Александрович
                Возраст: 20
                Город: Минск
                Профессия: Студент
                Дата создания: %s
                """.formatted(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));


            Files.writeString(filePath, personalInfo, StandardOpenOption.CREATE);
            System.out.println("✓ Файл создан: " + filePath.toAbsolutePath());


            System.out.println("\n=== ИНФОРМАЦИЯ О ФАЙЛЕ ===");
            System.out.println("Имя файла: " + filePath.getFileName());
            System.out.println("Путь: " + filePath.toAbsolutePath());
            System.out.println("Размер: " + Files.size(filePath) + " байт");
            System.out.println("Время последнего изменения: " +
                    Files.getLastModifiedTime(filePath));
            System.out.println("Доступен для чтения: " + Files.isReadable(filePath));
            System.out.println("Доступен для записи: " + Files.isWritable(filePath));


            System.out.println("\n=== СОДЕРЖИМОЕ ФАЙЛА ===");
            String content = Files.readString(filePath);
            System.out.println(content);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}