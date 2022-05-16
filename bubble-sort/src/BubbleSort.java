import java.util.Arrays;

//O(n*n) т.к. 2 цикла, и один в другом
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {9, 6, 8, 5, 7, 4, 2, 3, 1, 13, 15, 12, 54};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        //---------------------------------------------
        int[] array2 = {9, 6, 8, 5, 7, 4, 2, 3, 1, 13, 15, 12, 54};

        boolean isSorted = false;
        int count = 0;
        while (!isSorted) {
            isSorted = true;
            for (int j = 1; j < array2.length - count; j++) {
                if (array2[j] < array2[j-1]) {
                    int temp = array2[j-1];
                    array2[j-1] = array2[j];
                    array2[j] = temp;
                    isSorted = false;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(array2));
    }
}
