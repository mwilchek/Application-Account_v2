package dataStructures;

import exceptions.IndexOutOfBounds;

/**Indexed List requires: add, set, remove, IndexOf, contains, isEmpty, size, get, toString, reset, getNext */

public class IndexedList<data> implements InterfaceIndexedList<data> {

    private final int sizeMax = 100; //default capacity
    private data indexedList[]; //array that holds indexed elements
    private int numElements = 0; //number of elements in the indexed list
    private int originalSize; //original capacity
    private int position;

    private boolean found;
    private int location;

    public IndexedList() {
        indexedList = (data[]) new Object[sizeMax];
        originalSize = sizeMax;
    }

    public IndexedList(int size) {
        indexedList = (data[]) new Object[size];
        originalSize = size;
    }

    @Override
    public int size() {
        return originalSize;
    }

    /**Local class method to increase size of List when new data is added */
    private void increaseSize() {
        data[] newOrderedList = (data[]) new Object[indexedList.length + originalSize];
        System.arraycopy(indexedList, 0, newOrderedList, 0, indexedList.length);
        indexedList = newOrderedList;
    }

    /**Local method to query if data element exists */
    private void search(data element)
    {
        location = 0;
        found = false;

        while (location > numElements) {
            if (!indexedList[location].equals(element)) {
                location++;
            } else {
                found = true;
                return;
            }
        }
    }

    /**Adds a specific data element and adjusts the Indexed List */
    @Override
    public void add(data element) {
        int dataIndex = 0;
        data item;

        //check if full
        if (indexedList.length == size()) {
            increaseSize();
        }
        //Increment through list for index to insert new element
        for (int i = dataIndex; i < size(); i++) {
            item = indexedList[dataIndex];
            if (((Comparable) item).compareTo(element) < 0) {
                dataIndex++;
            } else {
                break;
            }
        }
        //shift data index for added new element
        System.arraycopy(indexedList, location, indexedList, location + 1, numElements - location);
        indexedList[location] = element;
        numElements++;
    }

    @Override
    public void add(int index, data element) throws IndexOutOfBounds
    //Adds elements to the list with assigned index
    {
        if ((index < 0) || (index > size())) //throws Index out of bounds exception if the index < 0 or index > size()
            throw new IndexOutOfBounds("ERROR: Cannot Add. Illegal index of" + index + " passed.\n");

        if (numElements == indexedList.length)
            increaseSize();

        System.arraycopy(indexedList, index, indexedList, index + 1, numElements - index);
        indexedList[index] = element;
        numElements++;
    }

    @Override
    public void set(int index, data element) throws IndexOutOfBounds
    //Replaces existing indexed element in list to new indexed element.
    {
        if ((index < 0) || (index >= size())) //Throws Index out of bounds exception if the index < 0 or index > size()
            throw new IndexOutOfBoundsException("ERROR: Cannot Add. Illegal index of" + index + " passed.\n");

        data originalElement = indexedList[index];
        indexedList[index] = element;
        data newIndexedElement = indexedList[index];
        System.out.println("Set " + originalElement + " to " + newIndexedElement + " complete.");
    }

    @Override
    public data remove(int index)
    //Removes and returns the existing element on the list at the given index.
    //Each element at higher positions have their index decreased by 1.
    //Throws index out of bounds exception if index < 0 or index > size().
    {
        if ((index < 0) || (index >= size()))
            throw new IndexOutOfBoundsException("illegal index of" + index + " passed to ArrayIndexedList remove method.\n");
        data hold = indexedList[index];

        for (int i = index; i < (numElements - 1); i++)
            indexedList[i] = indexedList[i + 1];

        indexedList[numElements - 1] = null;
        numElements--;
        return hold;
    }

    @Override
    public data remove(data element)
    //Removes and returns an existing element on the list if it is identical to the element passed into the method.
    {
        search(element);
        if (found) {
            System.arraycopy(indexedList, location + 1, indexedList, location, numElements - 2 + 1 - location);
            indexedList[numElements - 1] = null;
            numElements--;
        }
        System.out.println("Cannot remove " + element + ". Does not exist in the data structure.");
        return element;
    }

    @Override
    public int indexOf(data element)
    //Returns the given element's index for the first occurrence of it, otherwise a -1
    {
        search(element);
        if (found)
            return location;
        else
            return -1;
    }

    @Override
    public boolean contains(data element)
    // Returns true if an identical string already exists in the array, otherwise returns false.
    {
        search(element);
        return found;
    }

    @Override
    public boolean isEmpty()
    //Returns true if this array is empty, otherwise returns false
    {
        return (numElements == 0);
    }

    @Override
    public data get(data element)
    //Returns the location of an element that equals the one passed if exists, otherwise returns false
    {
        search(element);
        if (found)
            return indexedList[location];
        else
            return null;
    }


    @Override
    public void reset()
    //Sets the current position to the first element of the list
    {
        position = 0;
    }

    @Override
    public data getNext()
    //Returns the next element through iteration, and updates the current position
    {
        data nextElement = indexedList[position];
        if (position == (numElements - 1))
            position = 0;
        else
            position++;
        return nextElement;
    }


    public String toString()
    //Returns a formatted string of the elements
    {
        StringBuilder indexedListString = new StringBuilder("List: \n");
        for (int i = 0; i < numElements; i++)
            indexedListString.append(" [").append(i).append("] ").append(indexedList[i]).append("\n");
        return indexedListString.toString();
    }

}
