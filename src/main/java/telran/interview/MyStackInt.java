package telran.interview;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStackInt {
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> maxStack = new LinkedList<>();

    public void push(int num) {
        stack.addFirst(num);
        if (maxStack.isEmpty() || num >= maxStack.getFirst()) {
            maxStack.addFirst(num);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int num = stack.removeFirst();
        if (num == maxStack.getFirst()) {
            maxStack.removeFirst();
        }
        return num;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMaxElement() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.getFirst();
    }
}