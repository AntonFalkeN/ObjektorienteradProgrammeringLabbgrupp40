import java.util.ArrayList;
import java.util.List;

public class Storage<T> {
    private List<T> storage;
    private int capacity;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.storage = new ArrayList<>();

    }

    public List<T> getItems(){return storage;}

    public boolean addItem(T item) {
        if (storage.size() < capacity) {
            return storage.add(item);
        } else {
            System.out.println("This repair shop is full! Cannot add more items.");
            return false;
        }
    }

    public T removeFirst() { // FIFO (First In, First Out)
        if (storage.isEmpty()) {
            throw new IllegalStateException("The shop is empty... Sure this was the right one????️");
        }
        return storage.remove(0); // Removes the first element
    }

    public T removeLast() { // LIFO (Last In, First Out)
        if (storage.isEmpty()) {
            throw new IllegalStateException("The shop is empty... Sure this was the right one????️");
        }
        return storage.remove(storage.size() - 1); // Removes the last element
    }

    public int getSize() {
        return storage.size();
    }

    public List<T> getStorage(){return new ArrayList<>(storage);}

}
