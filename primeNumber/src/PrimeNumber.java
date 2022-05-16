import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
    //простое число это то что делится на себя И на 1... 5 делится только на себя и на 1...
    // а вот 4 это составное число, так как делится на 2, 61-простое, 60-составное
    // 1 это не простое число, т.к. делится только на себя

    public static void main(String[] args) {
        System.out.println(getListPrimeNumbers(100));
        System.out.println(isPrime(61));
    }

    public static List<Integer> getListPrimeNumbers(int max) {
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < max; i++) { //начинаем убирать с 2ки, т.к. оно первое простое число, потом каждое 3, 4 и т.д.
            if (isPrime[i]) {
                for (int j = 2 * i; j < max; j += i) { //и погнали, каждое второе число уже состовное, значит ставим false
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
