package Lesson2;

import java.util.InputMismatchException;

/**
 * Обработайте возможные исключительные ситуации. "Битые" значения
 * в исходном массиве считайте нулями. Можно внести в код правки,
 * которые считаете необходимыми
 */
public class Task2 {
    public static void main(String[] args) {
        String[][] arr0 = new String[][] {
            {"1", "1", "1", "1", "1"},
            {"1", "1", "1", "1", "1"},
            {"1", "1", "1", "1", "1"},
            {"1", "1", "1", "1", "1"},
            {"1", "1", "1", "1", "1"}
    };

    String[][] arr = new String[][] {
            {"1", "1"},
            {"1", "1", "1", "1", "1"},
            {"1", "2"},
            {"3", "3"},
            {"2", "6"}
    };
        //System.out.println(sum2d(arr0));
        System.out.println(sum2d(arr));
    }
    private static int sum2d(String[][] arr) {
        int sum = 0;
        try{
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 5; j++) {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println(e.getMessage()+" не число");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println("Результат: " + sum2d(copy(arr, 5)));
        }
        return sum;
    }

    private static String[][] copy(String[][] arr, int length) {
        for (int i = 0; i < length; i++) {
            String[] elem = arr[i];
            if (elem.length < length) {
                String[] temp = new String[length];
                System.arraycopy(elem, 0, temp, 0, elem.length);
                for (int k = elem.length; k < length; k++) {
                    temp[k] = "0";
                }
                elem = temp;
                arr[i] = elem;
            }
        }
        return arr;
    }
}
