import java.util.*;

public class QueueArray<T> {

    private int capacity;
    private int rear = 0;
    private int front = 0;
    private ArrayList<T> items = new ArrayList<>();
    private int num_items = 0;

    public QueueArray() {

        this.capacity = 50;

    }

    public QueueArray(int capacity) {

        this.capacity = capacity;

    }

    public int getCapacity() {

        return capacity;

    }

    public ArrayList<T> getItems() {

        return items;

    }

    public int getNumItems() {

        return num_items;

    }

    public int getRear() {

        return rear;

    }

    public int getFront() {

        return front;

    }

    public boolean isEmpty() {

        return num_items == 0;
        
    }

    public boolean isFull() {

        return num_items == capacity;

    }

    public void enqueue(T item) {

        if (isFull()) {
            throw new IndexOutOfBoundsException("Queue Overflow!");
        }
        items.add(rear, item);
        rear = (rear + 1) % capacity;
        num_items++;

    }

    public T dequeue() {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue Underflow!");
        }
        T item = items.get(front);
        front = (front + 1) % capacity;
        num_items--;
        return item;

    }

    public int size() {

        return getNumItems();

    }

}