package tests;

import dataStructures.OrderedList;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class OrderedListTest {
    @Test
    public void size() {
        OrderedList a = new OrderedList();
        System.out.println();
        System.out.println("Testing size()...");
        System.out.println("New stack created with default size of: " + a.size());

        OrderedList b = new OrderedList(110);
        System.out.println("New stack created with custom size of: " + b.size());

        System.out.println("Comparison of sizes (0 is both equal, " +
                "1 is default stack less than custom, " +
                "-1 is custom is less than default): " + Integer.compare(a.size(), b.size()));
    }

    @Test
    public void add() {
        OrderedList a = new OrderedList(15);
        Random rand = new Random();
        for (int i = 0; i < a.size(); i++){
            int  n = rand.nextInt(50) + 1;
            a.add(n);
        }
        System.out.println();
        System.out.println("Testing add()...");
        System.out.println("Filled Ordered List with random values from 1-50.");
        System.out.println(a.toString());
    }

    @Test
    public void remove() {
        OrderedList a = new OrderedList(4);
        a.add(2);
        a.add(44);
        a.add(7);
        a.add(14);
        System.out.println();
        System.out.println("Testing remove()...");
        System.out.println("Filled Ordered List, of size 4, with values: ");
        System.out.println(a.toString());
        a.remove(14);
        System.out.println("Testing removal of '14' : ");
        System.out.println("Updated List : " + a.toString());
    }

    @Test
    public void contains() {
        OrderedList a = new OrderedList(200);
        Random rand = new Random();
        for (int i = 0; i < a.size(); i++){
            int  n = rand.nextInt(50) + 1;
            a.add(n);
        }
        System.out.println();
        System.out.println("Testing contains()...");
        System.out.println("Filled Ordered List, of size 200, with random values from 1-50.");
        System.out.println("Does element '5' exist?: " + a.contains(5));
    }

    @Test
    public void get() {
        OrderedList a = new OrderedList(4);
        a.add(2);
        a.add(44);
        a.add(7);
        a.add(14);
        System.out.println();
        System.out.println("Testing get()...");
        int getValue = (int) a.get(7);
        System.out.println("3 + " + getValue + " = " + (3 + getValue)); //Answer 10
    }

    @Test
    public void reset() {
        OrderedList a = new OrderedList(4);
        a.add(2);
        a.add(44);
        System.out.println();
        System.out.println("Testing reset()...");
        System.out.print("The position for lookup has been set to: " + a.reset());
    }

    @Test
    public void getNext() {
        OrderedList a = new OrderedList(4);
        a.add(2);
        a.add(44);
        a.add(7);
        a.add(14);
        System.out.println();
        System.out.println("Testing getNext()...");
        System.out.println("Data element: " + a.getNext());
    }

    @Test
    public void isEmpty() {
        OrderedList a = new OrderedList();
        System.out.println();
        System.out.println("Testing isEmpty()...");
        System.out.println("The Ordered List is empty: " + a.isEmpty());
    }

}