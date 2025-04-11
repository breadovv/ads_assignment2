public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item); // adds to the tail
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.remove(0); // removes from the head
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
