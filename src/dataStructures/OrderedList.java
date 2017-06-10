package dataStructures;

public class OrderedList<data> implements InterfaceList<data>{
    private final int sizeMax = 100;
    private data orderdList[];
    private int numElement;
    private int originalSize;

    /**Default unbound OrderedList with no elements */
    public OrderedList() {
        orderdList = (data[]) new Object[sizeMax];
        originalSize = sizeMax;
        numElement = 0;
    }

    /**OrderedList with defined size and no elements */
    public OrderedList(int size) {
        orderdList = (data[]) new Object[size];
        originalSize = size;
        numElement = 0;
    }

    @Override
    public int size() {
        return originalSize;
    }

    @Override
    public void add(data element) {
        int dataIndex = 0;
        data item;
        //check if the array is full
        if (orderdList.length == size()) {
            enlarge();
        }

        //search for location to insert the new element
        for (int i = dataIndex; i < size(); i++) {
            item = orderdList[dataIndex];
            if (((Comparable) item).compareTo(element) < 0) {
                dataIndex++;
            } else {
                break;
            }
        }

        //shifting
        for (int i = numElement; i > dataIndex; i--) {
            orderdList[i] = orderdList[i - 1];
        }
        orderdList[dataIndex] = element;
        numElement++;
    }

    @Override
    public boolean contains(data element) {
        return false;
    }

    @Override
    public data remove(data element) {
        return null;
    }

    @Override
    public data get(data element) {
        return null;
    }

    @Override
    public void reset() {

    }

    @Override
    public data getNext() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private void enlarge() {
        data[] largerList = (data[]) new Object[2 * originalSize];
        for (int i = 0; i < orderdList.length; i++) {
            largerList[i] = orderdList[i];
        }
        orderdList = largerList;
    }

    public String toString() {
        String list = "";
        for (data value : orderdList) {
            list += value + "\n";
        }
        return list;
    }
}
