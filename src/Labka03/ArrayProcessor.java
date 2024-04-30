package Labka03;

import java.util.Random;

public class ArrayProcessor {
    protected int[] array;

    public ArrayProcessor(int size) {
        Random random = new Random();
        array = new int[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(11);
        }
    }

    public String processArray() {
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sumEven += array[i];
            } else {
                sumOdd += array[i];
            }
        }

        if (sumEven > sumOdd) {
            return "Сумма на четных местах (" + sumEven + ") больше суммы на нечетных местах (" + sumOdd + ")";
        } else if (sumEven < sumOdd) {
            return "Сумма на нечетных местах (" + sumOdd + ") больше суммы на четных местах (" + sumEven + ")";
        } else {
            return "Суммы равны (" + sumEven + ")";
        }
    }

    public String arrayToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
