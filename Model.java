import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class Model {
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();
    Point volvoWorkshopPoint = new Point(300,0);

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Point> points = new ArrayList<>();
    CarRepairShop<Volvo240> vCR = new CarRepairShop<>(9);
    Announcer announcer = new Announcer();
    CarView frame;
    VehicleFactory VF = new VehicleFactory();

    public void performAction(Car car){
       // points.add(volvoPoint);
       // points.add(saabPoint);
       // points.add(scaniaPoint);
        if(cars.size() > 0){
        chekCollision(car.getX(), car.getY(), car) ;
        car.move();
        int x = (int) Math.round(car.getX());
        int y = (int) Math.round(car.getY());
        moveit(x, y, car);
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();}
    }

    <T> void moveit(int x, int y, T car){
        if(cars.size() > 0){
            int index = cars.indexOf(car);
            points.get(index).x = x;
            points.get(index).y = y;
        }
        /*
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
        }*/
    }

    public void chekCollision(double x, double y, Car car){
        if (x > 700){
            car.setCurrentDirection("west");
        }
        else if (x < 0){

            car.setCurrentDirection("east");
        }
        else if (y > 450){

            car.setCurrentDirection("north");
        }
        else if (y < 0){

            car.setCurrentDirection("south");
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
            if (!vCR.getCars().contains(car)){
                car.gas(gas);
        }}
    }
    private void turboManager(boolean turboNextState) {
        if (turboNextState) {
            announcer.notifyTurbo(true);
        } else {
            announcer.notifyTurbo(false);
        }
    }
    public void setTurboOn(){
        turboManager(true);
    }
    public void setTurboOff(){
        turboManager(false);
    }
    private void rampManager(boolean rampNextState){
        for (Car car : cars){
            if (car instanceof Scania && rampNextState){
                car.setCurrentSpeed(0);
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
        announcer.notifyStartStop(true);
    }
    protected void stopAll(){
        announcer.notifyStartStop(false);
    }
    public void addCar(String name){
        if(cars.size() < 5)
        {
            if (Objects.equals(name, "")) {
                Car p = (Car) VF.CreateRandom();
                cars.add(p);
                announcer.subscribeStopStart(p);
                if(p instanceof Saab95){
                    announcer.subscribeTurboOn(p);
                }
                Point e = new Point();
                points.add(e);
            } else {
                Car p = (Car) VF.CreateVehicle(name);
                cars.add(p);
                announcer.subscribeStopStart(p);
                if(p instanceof Saab95){
                    announcer.subscribeTurboOn(p);
                }
                Point e = new Point();
                points.add(e);
            }
        }
        else
        {
            System.out.println("För många bilar!");
        }
    }
    public void removeCar(){
        if(!cars.isEmpty()){
            cars.remove(cars.getFirst());
            points.remove(points.getFirst());
        }
        System.out.println("Car removed");
        //frame.revalidate();
    }
}
