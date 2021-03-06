import java.util.Arrays;

public class MergeSort {
    // тут как и быстрая сортировка, разделяй и властвуй, но работает в обратном порядке,
    // тут сразу массив разделяется на мелкие части, по одному элементу,
    // потом они объединяются первый со вторым в два эелемента, но отсортированны между собой,
    // потом в 4 элемента, тоже отсортированны и так далее
    /*
    еще раз, какой принцип есть массив src1{1,2,4,9,9}
    есть src2 {3,5,7,8}
    есть массив в который они вливаются dest
    у src1 есть index1 для пробежки по этому массиву
    у src2 соотвественно index 2
    мы начинаем вливать и сравниваем первые индексы массива, видим что
    у первого 1 а у второго 3, соответственно в массив dest переходит 1 из src1, а Index1++
    сравниваем индекс1 = 1 со значением 2, и индекс 2 = 0 со значением 3, видим что
    до сих пор элемент из первого массива меньше чем из второго, поэтому снова его вливаем в массив
    dest и увеличиваем индекс1, по итогу у нас

    index1 = 2
    index2 = 0
    потом увеличится индекс 2, так как у него элемент 3 на 0 позиции
    и так далее
     */
    public static void main(String[] args) {
        int[] array = {54, 73, 34, 13, 27, 94, 1, 4, 99, 22, 31, 101};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        int n = array.length;
        if (n < 2) { //если массив меньше 2х элементов то останавливаем
            return;
        }
        int middle = n / 2; // берем средний элемент массива
        int[] leftArray = new int[middle]; //создаем массив для левой части
        int[] rightArray = new int[n - middle]; // создаем массив для правой части

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i]; // заполняем левый массив
        }
        for (int i = middle; i < n; i++) {
            rightArray[i - middle] = array[i]; //заполняем правый массив
        }
        mergeSort(leftArray); //делим до тех пор, пока не будут массивы по 2а элемента
        mergeSort(rightArray);
        //как только один массив разделили на множество массивов с 2мя элементами, начинаем их объединять
        /*
        array будет в конечном итоге равен 2м элементам, например 54 и 73, левый из их этого, так как он разделен
        будет равен 54, а правый 73... они попробуют снова зайти разделится, но не выполнять условие n<2 и выйдут из метода
        на этот клубок будет потихоньку раскручиваться
         */
        merge(array, leftArray, rightArray);//[54,73] [54] [73]
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int pivotLeft = 0;
        int pivotRight = 0;
        int index = 0;

        while (pivotLeft < left.length && pivotRight < right.length) { //пока индексы левого и правого массива меньше размеров их массивов
            if (left[pivotLeft] < right[pivotRight]) { //если элемент левого массива меньше элемента из правого массива
                array[index++] = left[pivotLeft++];//то в выходной массив записывается элемент первго массива,
                // и в обоих массивах поднимается индекс
            } else {
                array[index++] = right[pivotRight++];//если нет, то записывается из правого массива
            }
        }
        /*
        это на случай если массивы разной длины, левый 5 а правый 6 например
         */
        while (pivotLeft < left.length) { // если левый остался
            array[index++] = left[pivotLeft++]; //то дописываем в хвост
        }
        while (pivotRight < right.length) { // если правый остался
            array[index++] = right[pivotRight++]; // то его записываем в хвост
        }
    }
}
