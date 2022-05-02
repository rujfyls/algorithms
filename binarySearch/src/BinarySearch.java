public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10, 14, 29, 56};
        System.out.println(searchIndex(array, 4, 0, array.length - 1));
    }

    public static int searchIndex(int[] array, int key, int from, int to) {
        int middle = (to + from) / 2;

        if (array[middle] > key) {
            return searchIndex(array, key, from, middle);
        }
        if (array[middle] < key) {
            return searchIndex(array, key, middle + 1, to);
        }
        if (array[middle] == key) {
            return middle;
        }
        return -1;
    }
}
