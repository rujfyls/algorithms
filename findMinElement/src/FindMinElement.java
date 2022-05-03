public class FindMinElement {
    public static void main(String[] args) {
        int[] array = {5, 34, 8, 546, 12, 234, 80, 4, 7};
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(min);
    }
}
