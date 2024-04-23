package Labka01;

import java.util.Scanner;
class Main{
    public static void main(String[] arg) {

        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[scanner.nextInt()];
        ArrayProcessor processor = new ArrayProcessor(mas);
        System.out.println(processor.processArray());

        System.out.println("Введите количество строк матрицы: ");
        int rows = scanner.nextInt();

        System.out.println("Введите максимальное количество столбцов матрицы: ");
        int maxColumns = scanner.nextInt();

        MatrixProcessor matrixProcessor = new MatrixProcessor(rows, maxColumns);

        // Вызов метода обработки прямоугольной матрицы
        matrixProcessor.processRectangularMatrix();

        // Генерация вывода для оценки изменений в матрице
        System.out.println("Матрица после обработки: ");
        for (int[] row : matrixProcessor.getMatrix()) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // Вызов метода обработки непрямоугольной матрицы
        String result = matrixProcessor.processIrregularMatrix();
        System.out.println(result);

        // Обрабатка строки матрицы, как одномерные массивы
        matrixProcessor.processPrintResults();
    }
}