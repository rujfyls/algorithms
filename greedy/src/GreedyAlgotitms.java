import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgotitms {
    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println("Из полученного массива получилось сделать вот такое большое число: "
                + maxNumberFromDigits(digits));

        int[] stations = {0, 200, 375, 550, 750, 950};
        System.out.println("Минимальное количество остановок для заправки нужно совершить: "
                + minStops(stations, 400));
    }

    //O(n*log(n))
    public static String maxNumberFromDigits(int[] i) {
//        StringBuilder result = new StringBuilder();
//        Arrays.sort(i); //O(n*log(n))
//        for (int d = i.length - 1; d >= 0; d--) {
//            result.append(i[d]);
//        }
//        return result.toString();
        //-----------------------------
        return String.join("", Arrays.stream(i).boxed().sorted(Collections.reverseOrder())
                .map(String::valueOf).toArray(String[]::new));
    }

    public static int minStops(int[] stations, int capacity) {
        int result = 0; //оптимальное количество остановок
        int currentStop = 0;

        while (currentStop < stations.length - 1) {
            int nextStop = currentStop;

            while (nextStop < stations.length - 1 &&
                    stations[nextStop + 1] - stations[currentStop] <= capacity) {
                nextStop++;
            }
            if (currentStop == nextStop) {
                return -1;
            }
            if (nextStop < stations.length - 1) {
                result++;
            }

            currentStop = nextStop;
        }

        return result;
    }
}
