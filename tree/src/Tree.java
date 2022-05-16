import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    //Граф - абстрактная структура, состоящая из узлов, соединенных ребрами...
    //Пример это города, и соединяющие их дороги
    //Дерево - частный случай графа, т.е. в нем нет возможности движения по кругу это нижние узлы не соединены
    //и должна быть вершина
    //TreeSet & TreeMap это красно-черное дерево
    //бинарное дерево содержит только двух потомков
    public static void main(String[] args) {
        InnerTreeClass tree = new InnerTreeClass(20,
                new InnerTreeClass(7,
                        new InnerTreeClass(4, null,
                                new InnerTreeClass(6, null, null)),
                        new InnerTreeClass(9, null, null)),
                new InnerTreeClass(35,
                        new InnerTreeClass(31, new InnerTreeClass(28, null, null), null),
                        new InnerTreeClass(40, new InnerTreeClass(38, null, null),
                                new InnerTreeClass(52, null, null))));
        System.out.println(tree.sum());
        System.out.println(sumDeep(tree));
        System.out.println(sumWide(tree));
    }

    static class InnerTreeClass {
        int value;
        InnerTreeClass left;
        InnerTreeClass right;

        public InnerTreeClass(int value, InnerTreeClass left, InnerTreeClass right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int sum() {
            int sum = value;

            if (left != null) {
                sum += left.sum();
            }

            if (right != null) {
                sum += right.sum();
            }

            return sum;
        }
    }

    //лучше реализовывать через стек - это обход в глубину
    // обход получается сверху вниз сначала верхушка, потом два корня этой верхушки
    public static int sumDeep(InnerTreeClass root) {
        Stack<InnerTreeClass> stack = new Stack<>();
        stack.push(root);

        int sum = 0;

        while (!stack.isEmpty()) {
            InnerTreeClass node = stack.pop();
            sum += node.value;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return sum;
    }

    //реализация через очередь - это обход в ширину
    //обход сначала самый нижний уровень, у кого все листья null null, а потом подниматься вверх к вершине
    //обход в ширину нужен для поиска ближайшего значения
    public static int sumWide(InnerTreeClass root) {
        Deque<InnerTreeClass> queue = new ArrayDeque<>();
        queue.push(root);

        int sum = 0;

        while (!queue.isEmpty()) {
            InnerTreeClass node = queue.pop();
            sum += node.value;

            if (node.right != null) {
                queue.push(node.right);
            }

            if (node.left != null) {
                queue.push(node.left);
            }
        }

        return sum;
    }
}
