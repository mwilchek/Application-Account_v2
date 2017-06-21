package dataStructures;

/**
 * Stack requires: Push, pop, top, isEmpty, isFull (array), size, toString
 */

import exceptions.Overflow;
import exceptions.Underflow;

public class Stack<data> implements InterfaceStack<data> {
    protected final int sizeMax = 100; //default capacity
    protected data[] stack;  //holds stack elements
    protected int topIndex = -1; //index of top element in stack

    /**Default stack with no elements */
    public Stack() {
        stack = (data[]) new Object[sizeMax];
    }

    /**Stack with defined size and no elements */
    public Stack(int size) {
        stack = (data[]) new Object[size];
    }

    /**Returns current size of Stack */
    @Override
    public int size() {
        return stack.length;
    }

    /**Adds a specific data element to top of Stack */
    @Override
    public void push(data element) throws Overflow {
        if (!isFull()) {
            topIndex++;
            stack[topIndex] = element;
        } else
            throw new Overflow("Stack is FULL. Cannot push.");
    }

    /**Removes a specific data element to top of Stack */
    @Override
    public void pop() throws Underflow {
        if (!isEmpty()) {
            stack[topIndex] = null;
            topIndex--;
        } else
            throw new Underflow("Stack is EMPTY. Cannot pop.");
    }

    /**Get top data element in stack. */
    @Override
    public data top() throws Underflow {
        data topOfStack;
        if (!isEmpty())
            topOfStack = stack[topIndex];
        else
            throw new Underflow("Stack is EMPTY. Cannot return top.");
        return topOfStack;
    }

    /**Checks is Stack is empty or not */
    @Override
    public boolean isEmpty() {
        if (topIndex == -1)
            return true;
        else
            return false;
    }

    /**Checks is stack is full or not */
    @Override
    public boolean isFull() {
        if (topIndex == (stack.length - 1))
            return true;
        else
            return false;
    }

    public String toString() {
        String outString = "";
        for (int i = 0; i < this.stack.length; i++) {
            outString = outString + (stack[i] + ",");
        }
        outString = outString.replaceAll(",null", "");
        return outString;
    }

}
