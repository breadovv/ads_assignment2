import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private Object[] elements;
    private int length;

    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    @Override
    public void add(T element) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = element;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (length == elements.length) {
            increaseCapacity();
        }
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        length++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(length - 1);
    }

//    @Override
//    public void remove(int index) {
//        checkIndex(index);
//        for (int i = index; i < length - 1; i++) {
//            elements[i] = elements[i + 1];
//        }
//        elements[--length] = null;
//    }
    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--length] = null;
        return removedElement;
    }


    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                T a = (T) elements[i];
                T b = (T) elements[j];
                if (((Comparable<T>) a).compareTo(b) > 0) {
                    elements[i] = b;
                    elements[j] = a;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        for (int i = 0; i < length; i++) {
            result[i] = elements[i];
        }
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            elements[i] = null;
        }
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            public boolean hasNext() {
                return index < length;
            }

            public T next() {
                return (T) elements[index++];
            }
        };
    }
}
