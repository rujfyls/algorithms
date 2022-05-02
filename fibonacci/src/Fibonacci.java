public class Fibonacci {
    /*
    Это представление третьего числа, сложением двух предыдущих
    0 1 <-фиксированные 1 2 3 5 8 13 21 34 55 89 144
    описывает размножение кроликов
     */
    public static void main(String[] args) {
//        System.out.println(fibNaiv(7));
        System.out.println(fibEffective(100));
    }

    //наивных, медленный, очевидный   O(2^n)
    private static long fibNaiv(int n) {
        if (n <= 1) {
            return n;
        }
        return fibNaiv(n - 2) + fibNaiv(n - 1);
    /*
                                   7
                       5                            6
                3          4                     4         5
           1    2         2     3            2    3       3    4
           1   0   1| 0   1 |1   2        0   1|1  2|  1   2|2   3
                                0    1          0   1|  0   1|0  1| 1  2
                                                                     0   1
     Здесь очень много повторных вычислений, чтобы от этого избавиться придумали
     мемоизацию
    */
    }

    // O(n)
    private static long fibEffective(int n) {
        long[] array = new long[n + 1];

        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }


}
