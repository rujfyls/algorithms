public interface Queue<T> {
    void add(T item); //добавить в конец очереди
    T remove(); // извлечение элемента из начала очереди
    boolean isEmpty();
}