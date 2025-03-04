import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Peterbilt388CarCarrier extends Truck implements Loadable {
    private Storage<Car> storage;

    public Peterbilt388CarCarrier(int capacity) {
        super(2, 200, Color.red, "Peterbilt388CarCarrier", 70);
        this.storage = new Storage<>(capacity);
    }

    public int getLoadSize() {
        return storage.getSize();
    }


    @Override
    public void raise(int amount){
        super.raise(70);
    }

    @Override
    public void lower(int amount){
        super.lower(70);
    }


    @Override
    public void move(){
        super.move();
        for(int i = 0; i < storage.getSize(); i++) {
            storage.getStorage().get(i).setX(getX());
        }
    }

    public void load(Car car){
        if (ramp.isLowered() && car.getY()-getY() < 5 && car.getX() - getX() < 5 && !Objects.equals(car.getModelName(), "Peterbilt388CarCarrier") && getCurrentSpeed() == 0){
            storage.addItem(car);
            car.setY(getY());
            car.setX(getX());
        }
        else{
            throw new ArithmeticException("Bilen måste vara närmare och rampen måste vara nere!");
        }
    }

    public Car unload(){
        if (ramp.isLowered()) {
            Car returnCar = storage.removeLast();
            returnCar.setX(getX()-1);
            returnCar.setY(getY());
            return returnCar;
        } else{
            throw new ArithmeticException("Rampen måste vara nere!");
        }
    }

    @Override
    protected double speedFactor() {
        return 0;
    }
}
