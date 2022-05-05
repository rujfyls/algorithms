import java.util.Arrays;

public class QuickSort {
    /*
    Выбирается опорный элемент, и те элементы которые меньше его переносятся влево, а те что больше
    переносятся вправо
    т.е. первая итерация делит на два массива, вторая итерация каждый делит еще на два массива и так далее,
    до тех пор пока не закончатся элементы, т.е. нечего будет разбивать на два
     */
    public static void main(String[] args) {
        int[] array = {54, 73, 34, 13, 27, 94, 1, 4, 99, 22, 31};

        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int from, int to) {
        if (from < to) { // если начальный индекс меньше окончательного,
            // т.е. если один элемент остался, то его не надо сортировать
            int divideIndex = partition(array, from, to); //индекс деления, или опорный элемент
            /*
            при первом прохождении вернется индекс 9 и получится массив
            [54, 73, 34, 13, 27, 31, 1, 4, 22, 99, 94]
            что означает что на 9 месте (99) все что левее то меньше его
            и слудующий проход будет от 0 до 8ого индекса
            и отсортируются 99 и 94
            и так далее....
             */
            quickSort(array, from, divideIndex - 1);

            quickSort(array, divideIndex, to);
        }
    }

    private static int partition(int[] array, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;
        int pivot = array[from + (to - from) / 2]; //выбираем средний элемент из этого подмассива
        // начинаем идти с двух сторон, если левый индекс меньше правого, т.е. есть чего сортировать
        while (leftIndex <= rightIndex) {
            /*
            происходит проход по левой части подмассива,
            пока перебираемые элементы меньше элемента из середины
            происходит смещение границы вправо ->|
             */
            while (array[leftIndex] < pivot) {
                leftIndex++;
            }
            //происходит смещение границы влево |<-
            while (array[rightIndex] > pivot) {
                rightIndex--;
            }
            /*
            смещение происходит до тех пор, пока левый индекс не становится больше
            опорного, а правый меньше опорного
            было: 123 78 6 45 910
                  ->|    _    |<-
             leftIndex = 3 (что равно числу 7)
             rightIndex = 7 (что равно числу 5)
             */
            if (leftIndex <= rightIndex) {
                swap(array, rightIndex, leftIndex); //меняем местами эти два индекса
                leftIndex++;
                rightIndex--;
            }
            /*
            получаем в итоге
            123 48 6 75 910
            leftIndex = 4
             rightIndex = 6
             прогоняем еще раз, и потом еще раз, когда Left & right не будут равны пол 5

             при таком легком примере все пройдет за один раз, но окгда очень сложный
             массив и индексы сошлись в у тебя всек равно отсается массив на подобии
             6 12 4 11   15   16 22 67 89
             то мы возвращаем индекс 4, и мы уверенны, что надо отсортировать только
             эти данные, в правой части нет значений меньше чем эти
             */
        }
        return leftIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}