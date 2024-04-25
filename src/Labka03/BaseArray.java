package Labka03;

import java.util.Arrays;
import java.util.Random;

public class BaseArray {
    protected int[] array;

    public BaseArray(int size) {
        array = new int[size];
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            array[i] = random.nextInt(11);
        }
    }

    public String transformationArray() {
        int sumEven = 0, sumOdd = 0;
        for(int i = 0; i < array.length; i++) {
            if(i % 2 == 0) {
                sumEven += array[i];
            } else {
                sumOdd += array[i];
            }
        }
        String result = "Сумма элементов на четных местах: " + sumEven + "\t" + "Сумма элементов на нечетных местах: " + sumOdd;
        return sumEven > sumOdd ? result + " (Четные больше)" : result + " (Нечетные больше)";
    }

    public String arrayToString() {
        return Arrays.toString(array);
    }

}