import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Model {
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();
    Point volvoWorkshopPoint = new Point(300,0);


    ArrayList<Car> cars = new ArrayList<>();
    CarRepairShop<Volvo240> vCR = new CarRepairShop<>(9);

    CarView frame;

    public void performAction(Car car){
        chekCollision(car.getX(), car.getY(), car) ;
        car.Move();
        int x = (int) Math.round(car.getX());
        int y = (int) Math.round(car.getY());
        moveit(x, y, car);
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
    }

    <T> void moveit(int x, int y, T car){
        if (car instanceof Volvo240) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        }
        else if(car instanceof Saab95){
            saabPoint.x = x;
            saabPoint.y = y;
        }
        else if(car instanceof Scania){
            scaniaPoint.x = x;
            scaniaPoint.y = y;
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

    private void chekVolvoWorkshopCollision(double x, double y, Car car){
        double workshopX = volvoWorkshopPoint.getX();
        double workshopY = volvoWorkshopPoint.getY();
        double workShopHeight = frame.drawPanel.volvoWorkshopImage.getHeight();
        double workShopWidth = frame.drawPanel.volvoWorkshopImage.getWidth();
        if (x >= workshopX && x <= workshopX + workShopWidth && y >= workshopY && y <= workshopY+workShopHeight && !vCR.getCars().contains(car)){
            vCR.submitCar((Volvo240)car);
            car.stopEngine();
            //cars.remove(car); Kommer fungera efter rekonstruktionsplanen
        }
    }
    public void brake(int amount){
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(gas);
        }}
    public void gas(int amount){
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }}
    private void turboManager(boolean turboNextState){
        for (Car car : cars){
            if (car instanceof Saab95 && turboNextState){
                ((Saab95) car).setTurboOn();}
            else if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }}}
    public void setTurboOn(){
        turboManager(true);
    }
    public void setTurboOff(){
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
            }}}
    public void raiseBed(){
        rampManager(true);
    }
    public void lowerBed(){
        rampManager(false);
    }
    protected void startAll(){
        for (Car car: cars) {
            car.startEngine();
        }
    }
    protected void stopAll(){
        for (Car car: cars) {
            car.stopEngine();
        }
    }
}
