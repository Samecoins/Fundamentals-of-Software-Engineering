package Labka04_1;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Checker {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFile)));

            String trimmedContent = content.trim();

            int result = checkString(trimmedContent);

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(String.valueOf(result));
            writer.close();

        } catch (IOException error) {
            System.err.println("Ошибка при чтении файла или записи в файл: " + error.getMessage());
        }
    }

    private static int checkString(String str) {
        try {
            Integer.parseInt(str);
            return 1;
        } catch (NumberFormatException i) {
            try {
                Double.parseDouble(str);
                return 2;
            } catch (NumberFormatException j) {
                return 0;
            }
        }
    }
}
