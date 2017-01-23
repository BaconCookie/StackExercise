package stack;

/**
 * Created by laura on 12.01.17.
 */

public class Stack<T> implements Stackable<T> {
    private Node top;
    private int size = 0;

    private class Node {
        public T data;
        public Node next;
    }

    @Override
    public void push(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top;

        size++;
        top = newNode;
    }

    @Override
    public T pop() {
        if (top != null) {
            T data = top.data;
            top = top.next;

            size--;
            return data;
        } else {
            System.out.println("Stack is empty!");
            return null;
        }
    }

    @Override
    public T peek() {
        if (top != null) {
            return top.data;
        } else {
            System.out.println("Stack is empty!");
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return (top == null && size == 0);
    }

    @Override
    public void clearAll() {
        top = null;
        size = 0;
    }

    @Override
    public void printAll() {
        //System.out.println(getClass().getSimpleName());

        if (!empty()) {
            Node temp = top;
            int element = size;
            System.out.println("Stack elements, from top to the bottom: ");
            while (temp != null) {
                System.out.println("Element " + element + " = " + temp.data);
                temp = temp.next;
                element--;
            }
        } else {
            System.out.println("Stack is empty!");
        }
    }
}