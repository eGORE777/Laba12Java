import java.util.Arrays;
import java.util.Scanner;

class Main {

    static int[] task1() {
        System.out.println("Задание 1");

        int[] arr = {5, 2, 8, 1, 9, 3, 7};
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        if (arr.length == 0) {
            System.out.println("Массив пуст");
            return new int[0];
        }

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) maxIndex = i;
            if (arr[i] < arr[minIndex]) minIndex = i;
        }

        System.out.println("Минимальный элемент: " + arr[minIndex] + " (индекс " + minIndex + ")");
        System.out.println("Максимальный элемент: " + arr[maxIndex] + " (индекс " + maxIndex + ")");

        int start = Math.min(maxIndex, minIndex);
        int end = Math.max(maxIndex, minIndex);

        int[] result = new int[arr.length - (end - start + 1)];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < start || i > end) {
                result[index++] = arr[i];
            }
        }

        System.out.println("Результат: " + Arrays.toString(result));
        return result;
    }

    static int[][] task2() {
        System.out.println("\nЗадание 2");

        int[][] matrix = {
                {5, 2, 8},
                {1, 9, 3},
                {7, 4, 6}
        };

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        if (matrix.length == 0) {
            System.out.println("Матрица пуста");
            return matrix;
        }

        int minValue = matrix[0][0];
        int minRow = 0;
        int minCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minValue) {
                    minValue = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        System.out.println("Минимальный элемент: " + minValue + " (строка " + minRow + ", столбец " + minCol + ")");

        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }

        for (int i = 0; i < matrix.length; i++) {
            result[i][minCol] = matrix[minRow][i];
            result[minRow][i] = matrix[i][minCol];
        }

        System.out.println("Результат:");
        printMatrix(result);
        return result;
    }

    static int[] task3() {
        System.out.println("\n=== Задание 3 ===");

        int[] arr = {5, 2, 8, 1, 9, 3, 7};
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        if (arr.length == 0) {
            System.out.println("Массив пуст");
            return new int[0];
        }

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) maxIndex = i;
            if (arr[i] < arr[minIndex]) minIndex = i;
        }

        System.out.println("Меняем местами: " + arr[minIndex] + " (индекс " + minIndex + ") и " + arr[maxIndex] + " (индекс " + maxIndex + ")");

        int[] result = Arrays.copyOf(arr, arr.length);
        int temp = result[minIndex];
        result[minIndex] = result[maxIndex];
        result[maxIndex] = temp;

        System.out.println("Результат: " + Arrays.toString(result));
        return result;
    }

    static double task4() {
        System.out.println("\nЗадание 4");

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        if (matrix.length == 0) {
            System.out.println("Матрица пуста");
            return 0;
        }

        int n = matrix.length;
        int sum = 0;
        int[] diagonalElements = new int[n];

        for (int i = 0; i < n; i++) {
            int element = matrix[i][n - 1 - i];
            sum += element;
            diagonalElements[i] = element;
        }

        double average = (double) sum / n;

        System.out.println("Элементы побочной диагонали: " + Arrays.toString(diagonalElements));
        System.out.println("Сумма: " + sum + ", количество: " + n);
        System.out.printf("Среднее арифметическое: %.2f\n", average);

        return average;
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Выполнение всех заданий по порядку:\n");
        task1();
        task2();
        task3();
        task4();
        System.out.println("\nВсе задания выполнены!");
    }
}