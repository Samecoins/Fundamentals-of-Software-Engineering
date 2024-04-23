package Labka01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MatrixProcessor extends ArrayProcessor {
    private int[][] matrix;

    public MatrixProcessor(int rows, int maxColumns) {
        super(new int[0]);
        Random random = new Random();
        this.matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int[random.nextInt(maxColumns) + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(-9,10) ;
            }
        }
    }

    public void processPrintResults() {
        for (int[] row : matrix) {
            ArrayProcessor processor = new ArrayProcessor(row);
            System.out.println("Строка: " + processor.arrayToString());
            System.out.println(processor.processArray());
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    // Метод обработки прямоугольного массива
    public void processRectangularMatrix() {
        ArrayList<int[]> newMatrix = new ArrayList<>();
        int maxPositive = Integer.MIN_VALUE; // максимальное положительное число

        for (int i = 0; i < matrix.length; i++) {
            newMatrix.add(matrix[i]);
            boolean addRow = false;

            // Поиск максимального положительного
            for (int value : matrix[i]) {
                if (value > maxPositive) {
                    maxPositive = value;
                }
                if (value < 0 && value % 2 != 0) {
                    addRow = true;
                }
            }

            if (addRow) {
                int[] additionalRow = Arrays.copyOf(matrix[i], matrix[i].length);
                newMatrix.add(additionalRow);
            }
        }

        matrix = newMatrix.toArray(new int[0][]);
    }

    // Метод обработки непрямоугольного массива
    public String processIrregularMatrix() {
        int minLength = Integer.MAX_VALUE;
        int[] shortestRow = null;

        for (int[] row : matrix) {
            if (row.length < minLength) {
                minLength = row.length;
                shortestRow = row;
            }
        }

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < shortestRow.length; i++) {
            if ((i + 1) % 2 == 0) {
                sumEven += shortestRow[i];
            } else {
                sumOdd += shortestRow[i];
            }
        }

        if (sumEven > sumOdd) {
            return "Сумма элементов на четных местах больше: " + sumEven;
        } else {
            return "Сумма элементов на нечетных местах больше: " + sumOdd;
        }
    }

    public void printMatrix() {
        for (int[] row : matrix) {
            ArrayProcessor rowProcessor = new ArrayProcessor(row);
            System.out.println(rowProcessor.arrayToString());
        }
    }

}
