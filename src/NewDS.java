import java.util.ArrayList;
import java.util.List;

public class NewDS {

    private char[] chars = {'B', 'b', 'A', 'a'};

    private int[][] data = {
            {5, 5},
            {4, 4}
    };

    public int getValue(int row, int col) {
        return data[row][col];
    }

    // Method to get a specific row sum
    public double getRowSum(int row) {
        int rowSums = 0;
        for (int i = 0; i < data[row].length; i++) {
            rowSums += data[row][i];
        }
        return rowSums;
    }

    // Method to get a specific column sum
    public double getColSum(int col) {
        int colSums = 0;
        for (int[] datum : data) {
            colSums += datum[col];
        }
        return colSums;
    }

    public List<Object> getAllSums() {
        List<Object> sums = new ArrayList<>();

        // Añadir los caracteres a la lista
        List<Character> charList = new ArrayList<>();
        for (char c : chars) {
            charList.add(c);
        }
        sums.add(charList);

        // Añadir las sumas de filas y columnas
        List<Double> sumList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            sumList.add(getRowSum(i));
        }
        for (int i = 0; i < data[0].length; i++) {
            sumList.add(getColSum(i));
        }
        sums.add(sumList);

        return sums;
    }

    // Method to get the total sum
    public int getTotalSum() {
        int totalSum = 0;
        for (int i = 0; i < data.length; i++) {
            totalSum += getRowSum(i);
        }
        return totalSum;
    }


}
