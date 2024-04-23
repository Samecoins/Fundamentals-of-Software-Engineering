package Labka01;

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

    public String arrayToString() {
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            sb.append(value).append(" ");  // Добавляем каждый элемент массива в строку с пробелом в качестве разделителя
        }
        return sb.toString().trim();  // Возвращаем строку, убирая лишний пробел в конце
    }
}