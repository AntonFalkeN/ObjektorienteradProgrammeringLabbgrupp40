import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Peterbilt388CarCarrier extends Scania{
    //private Car[] storage;
    ArrayList<Car> storage = new ArrayList<Car>(9);
    //Byt till gamla array och ha None istället för att ta bort
    //private int degree;
    private int currentLoad = 0;
    Peterbilt388CarCarrier(Color _color, int capacity){
        super(4, 200, _color, "Peterbilt388CarCarrier", 0, 0);
        //storage = new Car[capacity];
    }

    public ArrayList<Car> getStorage(){return storage;}
    public int getLoadSize(){return storage.size();}
    public int getDegree(){return angle;}

    @Override
    public void raise(){
        angle = 70;
    }

    @Override
    public void lower(){
            if (currentSpeed != 0) {
                throw new ArithmeticException("Bilen måste stå stilla för att fälla ner rampen!");
            }
            else {angle = 0;}
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
        double x = 0;
        switch(currentDirection){
            case "left":
                for(int i = 0; i < getStorage().size(); i++) {
                    storage[i].x_value = x_value - currentSpeed;
                    storage[i].y_value = y_value + currentSpeed;
                }
                x = x_value - currentSpeed;
                break;
                case "right":
                    for(int i = 0; i < getStorage().size(); i++) {
                        storage[i].x_value = x_value + currentSpeed;
                        storage[i].y_value = y_value + currentSpeed;
                    }
                    x = x_value + currentSpeed;
                    break;
            }
            y_value = y_value + currentSpeed;
            return x;
        }

    }
    public Car unload(){
        if (angle != 0) {//kanske gör en funktion som kollar degree för att undvika duplicering
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
