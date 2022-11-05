import java.util.*;

public class StackArray<T> {

    private int capacity;
    private int num_items;
    private ArrayList<T> items;

    public StackArray() {

        this.capacity = 50;
        this.items = new ArrayList<>();

    }

    public StackArray(int capacity) {

        this.capacity = capacity;
        this.items = new ArrayList<>();

    }

    public int getCapacity() {

        return capacity;

    }

    public int getNumItems() {

        return num_items;

    }

    public ArrayList<T> getItems() {

        return items;

    }

    public void increaseCapacity(int capacity) {

        this.capacity = capacity;

    }

    public boolean isEmpty() {

        return num_items == 0;

    }

    public boolean isFull() {

        return capacity == num_items;

    }

    public void push(T item) {

        if (isFull()) {
            throw new IndexOutOfBoundsException("Stack Overflow!");
        }
        items.add(num_items, item);
        num_items++;

    }
    
    public T pop() {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack Underflow!");
        }
        T item = items.get(num_items - 1);
        num_items--;
        return item;

    }

    public T peek() {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack Underflow!");
        }
        return items.get(num_items - 1);
    
    }

    public int size() {

        return getNumItems();

    }

}