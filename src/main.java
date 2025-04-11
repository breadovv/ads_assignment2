public class main {
    public static void main(String[] args) {
        System.out.println("=== Testing MyArrayList ===");
        MyList<Integer> arrayList = new MyArrayList<>();
        testList(arrayList);

        System.out.println("\n=== Testing MyLinkedList ===");
        MyList<Integer> linkedList = new MyLinkedList<>();
        testList(linkedList);

        System.out.println("\n=== Testing MyStack ===");
        testStack();

        System.out.println("\n=== Testing MyQueue ===");
        testQueue();

        System.out.println("\n=== Testing MyMinHeap ===");
        testMinHeap();
    }

    private static void testList(MyList<Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
        printList("After adding 10, 20, 30:", list);

        list.add(1, 15);
        printList("After inserting 15 at index 1:", list);

        list.addFirst(5);
        list.addLast(35);
        printList("After addFirst(5) and addLast(35):", list);

        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        list.set(2, 17);
        printList("After setting index 2 to 17:", list);

        list.remove(2);
        printList("After removing element at index 2:", list);

        list.removeFirst();
        list.removeLast();
        printList("After removeFirst() and removeLast():", list);

        list.add(20);
        list.add(20);
        printList("After adding two more 20s:", list);
        System.out.println("indexOf(20): " + list.indexOf(20));
        System.out.println("lastIndexOf(20): " + list.lastIndexOf(20));
        System.out.println("exists(17): " + list.exists(17));
        System.out.println("exists(20): " + list.exists(20));

        list.sort();
        printList("After sort():", list);

        Object[] array = list.toArray();
        System.out.print("toArray(): ");
        for (Object obj : array) {
            System.out.print(obj + " ");
        }
        System.out.println();

        list.clear();
        System.out.println("After clear(), size: " + list.size());
    }

    private static void printList(String message, MyList<?> list) {
        System.out.print(message + " ");
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void testStack() {
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        System.out.println("Top of stack (peek): " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }

    private static void testQueue() {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        System.out.println("Front of queue (peek): " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }

    private static void testMinHeap() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(40);
        heap.add(10);
        heap.add(30);
        heap.add(5);

        System.out.println("Peek min: " + heap.peek());
        System.out.println("Extract min: " + heap.extractMin());
        System.out.println("Extract min: " + heap.extractMin());
        System.out.println("Heap size after extraction: " + heap.size());
    }
}
