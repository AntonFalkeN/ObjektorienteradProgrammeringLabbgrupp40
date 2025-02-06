import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Peterbilt388CarCarrier extends Scania implements Loadable {
    //private Car[] storage;
    ArrayList<Car> storage = new ArrayList<Car>(9);
    private int currentLoad = 0;
    Peterbilt388CarCarrier(int capacity){
        super();

        //super(2, 200, Color.red, "Scania", 0);
        //storage = new Car[capacity];
    }

    public ArrayList<Car> getStorage(){return storage;}
    public int getLoadSize(){return storage.size();}
    public int getDegree(){return angle;}

    @Override
    public void raise(int amount){
        amount = 70;
        super.raise(70);
    }

    @Override
    public void lower(int amount){
        amount = 70;
        super.lower(70);
    }

    public void load(Car car){
        if (angle == 0 && car.y_value-y_value < 2 && car.x_value - x_value < 5 && !Objects.equals(car.getModelName(), "Peterbilt388CarCarrier") && currentSpeed == 0){
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
