import java.util.Random;
import java.util.Scanner;

public class ArrayProcessor {
    protected int[] array;

    public ArrayProcessor(int[] array) {
        this.array = array;
    }

    public String processArray() {
        Random random = new Random();

        int sumEven = 0;
        int sumOdd = 0;

        for(int i = 0; i < array.length; i++ ) {
            array[i] = random.nextInt(11);

            if(i % 2 == 0) {
                sumOdd = sumOdd + array[i];
            } else {
                sumEven = sumEven + array[i];
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();

        if (sumEven > sumOdd) {
            return "Сумма элементов на четных позициях больше: " + sumEven;
        } else {
            return "Сумма элементов на нечетных позициях больше: " + sumOdd;
        }
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[scanner.nextInt()];
        ArrayProcessor processor = new ArrayProcessor(mas);
        System.out.println(processor.processArray());
    }
}
