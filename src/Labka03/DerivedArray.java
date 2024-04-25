package Labka03;

public class DerivedArray extends BaseArray {
    private int[][] matrix;

    public DerivedArray(int size) {
        super(size);

        matrix = new int[size][];
        for(int i = 0; i < size; i++) {
            matrix[i] = new int[(int) (Math.random() * 10) + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10) + 1;
            }
        }
    }

    public String processMatrix() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            BaseArray rowProcessor = new BaseArray(row.length);
            rowProcessor.array = row;
            sb.append("Строка: ").append(rowProcessor.arrayToString())
                    .append(" -> ").append(rowProcessor.transformationArray()).append("\n");
        }
        return sb.toString();
    }

}
