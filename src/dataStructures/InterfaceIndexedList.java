package dataStructures;

import exceptions.IndexOutOfBounds;

/**Indexed List requires: add, set, remove, IndexOf, contains, isEmpty, size, get, toString, reset, getNext */

public interface InterfaceIndexedList<data> {

    void add(data element);

    void add(int index, data element) throws IndexOutOfBounds;

    void set(int index, data element) throws IndexOutOfBounds;

    data remove(int index);

    data remove(data element);

    int indexOf(data element);

    boolean contains(data element);

    boolean isEmpty();

    int size();

    data get(data element);

    String toString();

    void reset();

    data getNext();
}
