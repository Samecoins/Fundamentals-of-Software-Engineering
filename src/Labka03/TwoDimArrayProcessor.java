package Labka03;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class TwoDimArrayProcessor extends ArrayProcessor {
    private int[][] twoDimArray;

    public TwoDimArrayProcessor(int rows) {
        super(0); // Вызов конструктора суперкласса с size = 0 (не используется в двумерном кейсе)
        Scanner scanner = new Scanner(System.in);
        twoDimArray = new int[rows][];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            System.out.print("Введите количество столбцов для строки " + (i + 1) + ": ");
            int cols = scanner.nextInt();
            twoDimArray[i] = new int[cols];
            System.out.print("Введите элементы строки: ");
            for (int j = 0; j < cols; j++) {
                twoDimArray[i][j] = random.nextInt(-4,9);
            }
        }
    }

    public String processArray() {
        if (isRectangular()) {
            processRectangular();
        } else {
            processJagged();
        }
        return null;
    }

    private boolean isRectangular() {
        int firstRowLength = twoDimArray[0].length;
        for (int[] row : twoDimArray) {
            if (row.length != firstRowLength) {
                return false;
            }
        }
        return true;
    }

    private void processRectangular() {
        System.out.println("\nОбработка прямоугольного массива:");
        for (int i = 0; i < twoDimArray.length; i++) {
            array = twoDimArray[i]; // Текущая строка для базового обработчика
            boolean hasOddNegative = Arrays.stream(array).anyMatch(x -> x % 2 != 0 && x < 0);
            System.out.println(Arrays.toString(twoDimArray[i]));
            if (hasOddNegative) {
                int maxPos = Arrays.stream(twoDimArray).flatMapToInt(Arrays::stream)
                        .filter(x -> x > 0)
                        .max()
                        .orElse(0);
                System.out.println("Вставка строки после строки " + (i + 1) + ": " + maxPos);
            }
        }
    }

    private void processJagged() {
        System.out.println("\nОбработка непрямоугольного массива:");
        int minLen = Arrays.stream(twoDimArray)
                .mapToInt(array -> array.length)
                .min()
                .orElse(0);
        for (int[] row : twoDimArray) {
            if (row.length == minLen) {
                array = row;
                int sumEven = 0, sumOdd = 0;
                for (int i = 0; i < row.length; i++) {
                    if (i % 2 == 0) sumEven += row[i];
                    else sumOdd += row[i];
                    System.out.println(Arrays.toString(twoDimArray[i]));
                }

                System.out.println("Сумма четных: " + sumEven + ", Сумма нечетных: " + sumOdd);
            }
        }
    }
}



