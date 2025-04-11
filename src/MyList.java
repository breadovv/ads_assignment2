public interface MyList<T> extends Iterable<T> {

    void add(T item);                         // Add to end
    void set(int index, T item);              // Replace at index
    void add(int index, T item);              // Insert at index
    void addFirst(T item);                    // Add to beginning
    void addLast(T item);                     // Add to end

    T get(int index);                         // Get by index
    T getFirst();                             // Get first element
    T getLast();                              // Get last element

    T remove(int index);                   // Remove by index
    void removeFirst();                       // Remove first element
    void removeLast();                        // Remove last element

    void sort();                              // Sort list (natural order)

    int indexOf(Object object);               // First occurrence
    int lastIndexOf(Object object);           // Last occurrence
    boolean exists(Object object);            // Check if exists

    Object[] toArray();                       // Convert to Object array

    void clear();                             // Remove all elements
    int size();                               // Return current size
}
