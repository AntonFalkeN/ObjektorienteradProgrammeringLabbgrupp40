import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Peterbilt388CarCarrier extends Truck implements Loadable {
    //private Car[] storage;
    ArrayList<Car> storage = new ArrayList<Car>(9);
    private int currentLoad = 0;
    private int capacity;
    Peterbilt388CarCarrier(int capacity){
        super(2, 200, Color.red, "Scania", 0);
        this.capacity = capacity;
    }

    public ArrayList<Car> getStorage(){return storage;}
    public int getLoadSize(){return storage.size();}

    @Override
    public void raise(int amount){
        super.raise(70);
    }

    @Override
    public void lower(int amount){
        super.lower(70);
    }

    public void load(Car car){

        if (angle == 70 && car.y_value-y_value < 5 && car.x_value - x_value < 5 && !Objects.equals(car.getModelName(), "Peterbilt388CarCarrier") && currentSpeed == 0){
            storage.add(car);
            currentLoad +=1;
            car.y_value = y_value;
            car.x_value = x_value;
        }
        else{
            throw new ArithmeticException("Bilen måste vara närmare och rampen måste vara nere!");
        }
    }

    @Override
    public double Move(){
        super.Move();
        for(int i = 0; i < getStorage().size(); i++) {
            storage.get(i).x_value = storage.get(i).Move();
        }
        return 0;
    }


    public Car unload(){
        if (angle != 70) {//kanske gör en funktion som kollar degree för att undvika duplicering
            throw new ArithmeticException("Rampen måste vara nere!");
        }
        Car returnCar = storage.get(currentLoad-1);
        storage.remove(currentLoad-1);
        returnCar.x_value = x_value - 1;
        returnCar.y_value = y_value;
        return returnCar;
        }

    @Override
    protected double speedFactor() {
        return 0;
    }
}
