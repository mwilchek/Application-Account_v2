package dataStructures;

/**
 * Created by seeme on 6/14/2017.
 */
public class LinkedListNode <data> {

    private data element;
    LinkedListNode pointer;

    public LinkedListNode(data element) {
        this.element = element;
        this.pointer = null;
    }

    public LinkedListNode(data element, LinkedListNode pointer) {
        this.element = element;
        this.pointer = pointer;
    }

    public data getElement() {
        return element;
    }

    public void setElement(data element) {
        this.element = element;
    }

    public LinkedListNode getPointer() {
        return pointer;
    }

    public void setPointer(LinkedListNode pointer) {
        this.pointer = pointer;
    }
}
