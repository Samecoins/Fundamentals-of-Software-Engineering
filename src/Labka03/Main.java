package Labka03;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        scanner.close();

        DerivedArray derivedArray = new DerivedArray(size);
        System.out.println("Обработка и вывод элементов двумерного массива:");
        System.out.println(derivedArray.processMatrix());
    }
}
