import java.util.Iterator;

public class ReverseLinkedList {
    public static void main(String[] args) {
        SingleLinkList<Number> contactList = new SingleLinkList<>();

        contactList.addToEnd(new Number(1));
        contactList.addToEnd(new Number(2));
        contactList.addToEnd(new Number(3));
        contactList.addToEnd(new Number(4));
        contactList.addToEnd(new Number(5));

        for(Number contact: contactList) {
            System.out.println(contact);
        }

        contactList.reverse();

        System.out.println("------------------------");

        for(Number contact: contactList) {
            System.out.println(contact);
        }
    }

    static class Number {
        int id;

        public Number(int id) {
            this.id = id;

        }

        @Override
        public String toString() {
            return "Contact{" +
                    "id=" + id +
                    '}';
        }
    }

    public static class SingleLinkList<T> implements Iterable<T> {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T> {
            T data;
            ListItem<T> next;

            @Override
            public String toString() {
                return "ListItem{" +
                        "data=" + data +
                        ", next=" + next +
                        '}';
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addToEnd(T item) {
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;
            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        /*
        есть список 1 2 3 4 5
        хвост= 5
        голова= 1
         */
        public void reverse() {
            if (!isEmpty() && head.next != null) { // Если список не пустой и вообще не один элемент
                tail = head; //теперь в хвосте у нас первый элемент
                ListItem<T> current = head.next; // сохраним второй элемент со всеми ссылками в доп переменную
                head.next = null; // теперь первый элемент не на что не ссылается
                //теперь у нас в конце первый элемент
                while (current != null) {
                    ListItem<T> next = current.next; // сохраним третий элемент со всеми ссылками до 5ого
                    current.next = head; // а текущий элемент будет ссылаться на голову т.е. 2->1->null
                    head = current; // теперь голова это два, нужно чтоюы следующий элемент ссылался уже на 2ку
                    current = next; // текущий элемент теперь 3ий
                    /*
                    если третий элемент не null, то мы сохраним в отдельную переменную сслыки на 4ый и 5ый элемент
                    а третьему сошлемся на голову, что сейчас является 2ка, получится 3-2-1-null
                    третий сделаем головой
                    текущий 4ку
                    4 сошлется на 3ку
                    4ка станет головой
                    а текущая станет 5ка
                    в переменную next передадим null
                    5ке передадим следующий элемент голову что была 4ка
                    головой сделаем 5ку
                    текущему элемент сделаем следуюший что у нас Null, не выполнится условие while и мы выйдем из цикла
                     */
                }
            }
        }

        @Override
        public String toString() {
            return "SingleLinkList{" +
                    "head=" + head +
                    ", tail=" + tail +
                    '}';
        }
    }
}
