import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, 34, 8, 546, 12, 234, 3, 4, 7};
        for (int step = 0; step < array.length; step++) {
            int index = min(array, step);
            int temp = array[step];
            array[step] = array[index];
            array[index] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    private static int min(int[] array, int start) {
        int min = array[start];
        int index = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}
