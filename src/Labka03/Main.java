package Labka03;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        ArrayProcessor processor = new ArrayProcessor(size);
        System.out.println("Сгенерированный массив: " + processor.arrayToString());
        System.out.println(processor.processArray());

        System.out.println();
        System.out.println();

        System.out.print("Введите количество строк массива: ");
        int rows = scanner.nextInt();

        TwoDimArrayProcessor processorMatrix = new TwoDimArrayProcessor(rows);
        processorMatrix.processArray();
        scanner.close();
    }
}
