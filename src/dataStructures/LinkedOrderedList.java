package dataStructures;

public class LinkedOrderedList<data> implements InterfaceOrderedList<data>  {

    private int numElements;
    private LinkedListNode<data> currentPos;

    private boolean found;
    private LinkedListNode<data> location;
    private LinkedListNode<data> previous;
    private LinkedListNode<data> LLOrderedList;


    public LinkedOrderedList() {
        numElements = 0;
        LLOrderedList = null;
        currentPos = null;
    }


    protected void find(data target) {
        location = LLOrderedList;
        found = false;

        while(location != null)
        {
            if (location.getElement().equals(target))
            {
                found = true;
                return;
            } else {
                previous = location ;
                location = location.getPointer();
            }
        }
    }

    @Override
    public void add(data element)
    //Adds elements to the list.
    {
        LinkedListNode<data> prevLoc;
        LinkedListNode<data> location;
        data listElement;

        location = LLOrderedList;
        prevLoc = null;

        while (location != null) {
            listElement = location.getElement();
            if (((Comparable) listElement).compareTo(element) < 0) {
                prevLoc = location;
                location = location.getPointer();
            }
            else
                break;
        }
        LinkedListNode<data> newNode = new LinkedListNode<data>(element);

        if (prevLoc == null) {
            newNode.setPointer(LLOrderedList);
            LLOrderedList = newNode;
        }
        else {
            newNode.setPointer(location);
            prevLoc.setPointer(newNode);
        }
        numElements++;
    }

    @Override
    public data remove(data element)
    //Removes and returns an existing element on the list if it is identical to the element passed into the method.
    {
        find(element);
        if(found) {
            if (LLOrderedList == location)
                LLOrderedList = LLOrderedList.getPointer();
            else
                previous.setPointer(location.getPointer());
            numElements--;
        }
        return element;
    }

    @Override
    public boolean contains(data element)
    // Returns true if an identical string already exists in the list, otherwise returns false.
    {
        find(element);
        return found;
    }

    @Override
    public boolean isEmpty()
    //Returns true if this list is empty, otherwise returns false.
    {
        return (numElements == 0);
    }

    @Override
    public int size()
    // returns the number of strings in the list.
    {
        return numElements;
    }

    @Override
    public data get(data element)
    //Returns an equivalent object on the list, if it exists.
    {
        find(element);
        if (found)
            return location.getElement();
        else
            return null;
    }

    @Override
    public void reset()
    //Sets the current position to the first element of the list.
    {
        currentPos = LLOrderedList;
    }

    @Override
    public data getNext()
    //Returns the next element through iteration, and updates the current position.
    {
        data next = currentPos.getElement();
        if (currentPos.getPointer() == null)
            currentPos = LLOrderedList;
        else
            currentPos = currentPos.getPointer();
        return next;
    }

    public String toString()
    //Returns a formatted string of the elements in this stack.
    {
        LinkedListNode<data> currNode = LLOrderedList;
        String LLOrderedListString ="List:\n";
        while (currNode != null) {
            LLOrderedListString = LLOrderedListString + " " + currNode.getElement() + "\n";
            currNode = currNode.getPointer();
        }
        return LLOrderedListString;
    }

}

