import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Peterbilt388CarCarrier extends Car{
    //private Car[] storage;
    ArrayList<Car> storage = new ArrayList<Car>(9);
    //Byt till gamla array och ha None istället för att ta bort
    private int degree;
    private int currentLoad = 0;
    Peterbilt388CarCarrier(Color _color, int capacity){
        super(4, 200, _color, "Peterbilt388CarCarrier", 0);
        //storage = new Car[capacity];
    }

    public ArrayList<Car> getStorage(){return storage;}
    public int getDegree(){return degree;}

    public void rampUp(){
        degree = 70;
    }

    public void rampDown(){
            if (currentSpeed != 0) {
                throw new ArithmeticException("Bilen måste stå stilla för att fälla ner rampen!");
            }
            else {degree = 0;}
    }

    public void loadCar(Car car){
        if (degree == 0 && car.y_value-y_value < 2 && car.x_value - x_value < 5 && !Objects.equals(car.getModelName(), "Peterbilt388CarCarrier") && currentSpeed == 0){
            storage.add(car);
            currentLoad +=1;
            car.y_value = y_value;
            car.x_value = x_value;
            //overridea move så att vi kan ändra alla bilars x och y värden under tiden som lastbilen kör
        }
        else{
            throw new ArithmeticException("Bilen måste vara närmare och rampen måste vara nere!");
        }
    }
    public Car unloadCar(){
        if (degree != 0) {//kanske gör en funktion som kollar degree för att undvika duplicering
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
    //Glöm inte Junit tester
}
