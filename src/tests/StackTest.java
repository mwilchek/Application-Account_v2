package tests;

import dataStructures.Stack;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Created by seeme on 6/11/2017.
 */
public class StackTest {
    @Test
    public void size() throws Exception {
        Stack a = new Stack();
        System.out.println();
        System.out.println("Testing size()...");
        System.out.println("New stack created with default size of: " + a.size());

        Stack b = new Stack(200);
        System.out.println("New stack created with custom size of: " + b.size());

        System.out.println("Comparison of sizes (0 is both equal, " +
                "1 is default stack less than custom, " +
                "-1 is custom is less than default): " + Integer.compare(a.size(), b.size()));
    }

    @Test
    public void push() throws Exception {
        Stack a = new Stack();
        a.push(20);
        a.push(15);
        a.push(2);
        System.out.println();
        System.out.println("Testing push()...");
        System.out.println("Pushed 3 elements to stack: " + a.toString());

    }

    @Test
    public void pop() throws Exception {
        Stack a = new Stack(5);
        Random rand = new Random();
        for (int i = 0; i < a.size(); i++){
            int  n = rand.nextInt(50) + 1;
            a.push(n);
        }

        System.out.println();
        System.out.println("Testing pop()...");
        System.out.println("Current Stack: " + a.toString());
        System.out.println("Popping");
        a.pop();
        System.out.println("Popping");
        a.pop();
        System.out.println("Updated Stack: " + a.toString());
    }

    @Test
    public void top() throws Exception {
        Stack a = new Stack(5);
        Random rand = new Random();
        for (int i = 0; i < a.size(); i++){
            int  n = rand.nextInt(50) + 1;
            a.push(n);
        }

        System.out.println();
        System.out.println("Testing top()...");
        System.out.println("Current Stack: " + a.toString());
        System.out.println();
        System.out.println("Top of Stack is: " + a.top().toString());
    }

    @Test
    public void isEmpty() throws Exception {
        Stack a = new Stack(5);
        System.out.println();
        System.out.println("Testing isEmpty()...");
        System.out.println("The stack is empty: " + a.isEmpty());

    }

    @Test
    public void isFull() throws Exception {
        Stack a = new Stack(5);
        Random rand = new Random();
        for (int i = 0; i < a.size(); i++){
            int  n = rand.nextInt(50) + 1;
            a.push(n);
        }
        System.out.println();
        System.out.println("Testing isFull()...");
        System.out.println("The stack is full: " + a.isFull());

    }

}