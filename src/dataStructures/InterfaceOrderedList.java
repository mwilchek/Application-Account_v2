package dataStructures;

/**Ordered List requires: add, remove, contains, isEmpty, size, get, toString, reset, getNext */

interface InterfaceOrderedList<data> {

    void add(data element);

    data remove(data element);

    boolean contains(data element);

    boolean isEmpty();

    int size();

    data get(data element);

    String toString();

    void reset();

    data getNext();

}
