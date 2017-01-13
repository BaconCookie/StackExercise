package stack;

/**
 * Created by laura on 12.01.17.
 */

public interface Stackable<T> {
    /**
     * Pushes element on top of the stack
     *
     * @param data elementToPush
     */
    void push(T data);

    /**
     * Returns the top element of the list while removing it from the stack
     *
     * @return topElement
     */
    T pop();

    /**
     * Returns the top element of the stack without removing it
     *
     * @return topElement
     */
    T peek();

    /**
     * Returns the size of the stack
     *
     * @return int size of the stack
     */
    int size();

    /**
     * Checks if the stack is empty
     *
     * @return  true   list is empty
     *          false  list is not empty
     */
    boolean empty();

    /**
     * Clears the stack
     */
    void clearAll();

    /**
     * Prints the complete stack
     */
    void printAll();
}