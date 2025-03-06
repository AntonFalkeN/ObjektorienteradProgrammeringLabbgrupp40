import java.util.ArrayList;
import java.util.List;

class CarRepairShop<T>{

    private Storage<T> storage;

    public CarRepairShop(int capacity) {
        this.storage = new Storage<>(capacity);
    }

    public List<T> getCars(){return storage.getStorage();}

    public boolean submitCar(T car) {
        return storage.addItem(car);
    }

    public T returnCar() {
        return storage.removeFirst(); // FIFO
    }

}
