import java.util.Arrays;

public class Memoization {
    /*
    Вариант кэширования данных, чтобы не делать одни и те же операции
     */
    public static void main(String[] args) {
        int n = 100;
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
        System.out.println(fibNaiv(n, mem));
    }

    // O(n)
    private static long fibNaiv(int n, long[] mem) {
        if (mem[n] != -1) {
            return mem[n];
        }
        if (n <= 1) {
            return n;
        }
        long result = fibNaiv(n - 2, mem) + fibNaiv(n - 1, mem);
        mem[n] = result;

        return result;
    }
}
