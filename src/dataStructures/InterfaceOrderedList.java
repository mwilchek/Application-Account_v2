package dataStructures;

/**Ordered List requires: add, remove, contains, isEmpty, size, get, toString, reset, getNext */

interface InterfaceOrderedList<data> {

    int size();

    void add(data element);

    boolean contains(data element);

    data remove(data element);

    data get(data element);

    String toString();

    void reset();

    data getNext();

    boolean isEmpty();

}
