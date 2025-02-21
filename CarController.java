import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    CarRepairShop<Volvo240> vCR = new CarRepairShop<>(9);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        //cc.cars.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        //Gör i main
        Volvo240 v = new Volvo240(Color.black);
        Saab95 s = new Saab95(Color.blue);
        Scania sc = new Scania();

        cc.cars.add(v);
        cc.cars.add(s);
        cc.cars.add(sc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                chekCollision(car.getX(), car.getY(), car) ;
                car.Move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
        public void chekCollision(double x, double y, Car car){
            if (x > 700){
                car.currentDirection = "west";
            }
            else if (x < 0){
                car.currentDirection = "east";
            }
            else if (y > 450){
                car.currentDirection = "north";
            }
            else if (y < 0){
                car.currentDirection = "south";
            }
            else if(car instanceof Volvo240){chekVolvoWorkshopCollision(x, y, car);}
        }
    }

    private void chekVolvoWorkshopCollision(double x, double y, Car car){
        double workshopX = frame.drawPanel.volvoWorkshopPoint.getX();
        double workshopY = frame.drawPanel.volvoWorkshopPoint.getY();
        double workShopHeight = frame.drawPanel.volvoWorkshopImage.getHeight();
        double workShopWidth = frame.drawPanel.volvoWorkshopImage.getWidth();
        if (x >= workshopX && x <= workshopX + workShopWidth && y >= workshopY && y <= workshopY+workShopHeight && !vCR.getCars().contains(car)){
            vCR.submitCar((Volvo240)car);
            car.stopEngine();
            //cars.remove(car); Kommer fungera efter rekonstruktionsplanen
        }
    }

    // Calls the gas method for each car once

    public void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(gas);
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
       for (Car car : cars) {
            car.gas(gas);
        }
    }
    private void turboManager(boolean turboNextState){
        for (Car car : cars){
            if (car instanceof Saab95 && turboNextState){
                ((Saab95) car).setTurboOn();}
            else if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void setTurboOn(){
        turboManager(true);
    }
    void setTurboOff(){
        turboManager(false);
    }
    private void rampManager(boolean rampNextState){
        for (Car car : cars){
            if (car instanceof Scania && rampNextState){
                car.currentSpeed = 0;
                ((Scania) car).raise(70);
            }
            else if (car instanceof Scania){
                ((Scania) car).lower(70);
            }
        }
    }
    void raiseBed(){
        rampManager(true);
    }
    void lowerBed(){
        rampManager(false);
    }
    protected void startAll(){
       for (Car car:cars) {
           car.startEngine();
       }
    }
    protected void stopAll(){
        for (Car car:cars) {
            car.stopEngine();
        }
    }
}
