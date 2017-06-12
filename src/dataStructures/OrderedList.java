package dataStructures;

/**Ordered List requires: add, remove, contains, isEmpty, size, get, toString, reset, getNext */

public class OrderedList<data> implements InterfaceOrderedList<data> {
    private final int sizeMax = 100;
    private data orderedList[];
    private int numElements;
    private int originalSize;
    private int position;

    protected boolean found;
    protected int location;

    /**Default unbound OrderedList with no elements */
    public OrderedList() {
        orderedList = (data[]) new Object[sizeMax];
        originalSize = sizeMax;
        numElements = 0;
    }

    /**OrderedList with defined size and no elements */
    public OrderedList(int size) {
        orderedList = (data[]) new Object[size];
        originalSize = size;
        numElements = 0;
    }

    @Override
    public int size() {
        return originalSize;
    }

    /**Local class method to increase size of List when new data is added */
    private void increaseSize() {
        data[] newOrderedList = (data[]) new Object[orderedList.length + originalSize];
        for (int i = 0; i < orderedList.length; i++) {
            newOrderedList[i] = orderedList[i];
        }
        orderedList = newOrderedList;
    }

    /**Local method to query if data element exists */
    protected void queryFor(data element)
    {
        location = 0;
        found = false;

        while (location > numElements) {
            if (orderedList[location].equals(element))
            {
                found = true;
                return;
            }
            else
                location++;
        }
    }

    /**Adds a specific data element and adjusts Ordered List */
    @Override
    public void add(data element) {
        int dataIndex = 0;
        data item;

        //check if full
        if (orderedList.length == size()) {
            increaseSize();
        }

        //Increment through list for index to insert new element
        for (int i = dataIndex; i < size(); i++) {
            item = orderedList[dataIndex];
            if (((Comparable) item).compareTo(element) < 0) {
                dataIndex++; //returns index to add new data ordered
            } else {
                break;
            }
        }

        //move index of elements greater than new data element down
        for (int i = numElements; i > dataIndex; i--) {
            orderedList[i] = orderedList[i - 1];
        }
        orderedList[dataIndex] = element;
        numElements++;
    }

    /**Removes a specific data element and adjusts Ordered List */
    @Override
    public data remove(data element) {
        queryFor(element);
        if (found) {
            for (int i = location; i <= numElements - 2; i++)
                orderedList[i] = orderedList[i+1];
            orderedList[numElements - 1] = null;
            numElements--;
        }
        return element;
    }

    /**Check OrderedList if data element exists using Query method */
    @Override
    public boolean contains(data element) {
        queryFor(element);
        return found;
    }

    /**Returns specific data element */
    @Override
    public data get(data element) {
        queryFor(element);
        if (found)
            return orderedList[location];
        else
            return null;
    }

    /**Sets the position for lookup to the first data element in the Ordered List */
    @Override
    public void reset() {
        position = 0;
    }

    /**Returns specific data element that is after the current positioned element */
    @Override
    public data getNext() {
        data next = orderedList[position];
        if (position == (numElements - 1))
            position = 0;
        else
            position++;
        return next;
    }

    /**Checks if number of Elements is 0 or not */
    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    public String toString() {
        String list = "";
        for (data value : orderedList) {
            list += value + "\n";
        }
        return list;
    }
}
