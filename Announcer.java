import java.util.ArrayList;

public class Announcer {
    public ArrayList<Car> turboOnSubscribers = new ArrayList<>();
    ArrayList<Car> stopStartAllSubscribers = new ArrayList<>();

    public void subscribeTurboOn(Car car) {
        turboOnSubscribers.add(car);
    }
    public void unsubscribeTurboOn(Car car) {
        turboOnSubscribers.remove(car);
    }
    public void subscribeStopStart(Car car) {
        stopStartAllSubscribers.add(car);
    }
    public void unsubscribeStopStart(Car car) {
        stopStartAllSubscribers.remove(car);
    }
    public void notifyStartStop(boolean state){
        for (Car car : stopStartAllSubscribers){
            System.out.println("pooooopopop");
        }
    }
    public void notifyTurbo(boolean state){
        for (Car car : turboOnSubscribers)
        {
            if(state){
                ((Saab95)car).setTurboOn();
            }
            else{
                ((Saab95)car).setTurboOff();
            }
        }
    }
}