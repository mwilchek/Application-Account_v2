package dataStructures;

interface InterfaceList<data> {
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
