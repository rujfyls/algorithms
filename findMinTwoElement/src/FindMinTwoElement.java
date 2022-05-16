public class FindMinTwoElement {
    public static void main(String[] args) {
        int[] array = {23, 5, 78, 54, 978, 36, 12, 234, 35, 79, 65, 78, 77};

        int min = Integer.MAX_VALUE;
        int minTwo = Integer.MIN_VALUE;

        for (int j : array) {
            if (j < min) {
                minTwo = min;
                min = j;
            } else if (j < minTwo && j != min) {
                minTwo = j;
            }
        }
        System.out.println(min); //минимальный элемент
        if (minTwo != Integer.MIN_VALUE) {
            System.out.println(minTwo); //второй минимальный элемент
        } else {
            System.out.println("второго по минимальность элемента нет");
        }
    }
}
