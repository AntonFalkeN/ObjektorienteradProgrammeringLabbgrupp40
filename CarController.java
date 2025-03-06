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
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    private final int delay = 50;
    //Model model = new Model();
    //methods:

    public Timer timer = new Timer(delay, new TimerListener());
    static Model model = new Model();

    public static Model returnModel(){
        return model;
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */


    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            for (Car car : model.cars) {
                model.performAction(car);
            }
        }
    }

    // Calls the gas method for each car once

    public void brake(int amount) {
        model.brake(amount);
    }

    public void gas(int amount) {
        model.gas(amount);
    }

    void setTurboOn(){
        model.setTurboOn();
    }
    void setTurboOff(){
        model.setTurboOff();
    }

    void raiseBed(){
        model.raiseBed();
    }
    void lowerBed(){
        model.lowerBed();
    }
    protected void startAll(){
       model.startAll();
    }
    protected void stopAll(){
        model.stopAll();
    }
    public void addCar(String name){model.addCar(name);}
    void removeCar(){model.removeCar();}
}
