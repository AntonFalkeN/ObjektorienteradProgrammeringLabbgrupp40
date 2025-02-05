import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class carRepairShop<T>
{
    /*
    public T[] cars;
    public carRepairShop(int capacity){
        cars = new T[capacity];
    }
    public  T getData(){
        return data;
    }

     */
    private List<T> cars;
    private  int capacity;

    public carRepairShop(int capacity) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();

    }

    public List<T> getCars(){return cars;}

    public boolean submitCar(T car) {
        //if(Objects.equals(car.getClass(),type));
        if (cars.size() < capacity) {
            return cars.add(car);
        } else {
            System.out.println("This repair shop is full! Cannot add more cars.");
            return false;
        }
    }

    public T returnCar() {
        //eventuellt regplåt?
        // följer logiken av first in first out
        try{
            T temp = cars.getFirst();
            //if(Objects.equals(temp.getClass(),type)){
            cars.remove(temp);
            return temp;//}
            //return null;

        } catch (Exception e) {
            throw new ArrayIndexOutOfBoundsException("The shop is empty... Sure this was the right one????️");
        }
    }

}
