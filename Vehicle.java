import java.awt.*;

public class Vehicle {
    private double currentSpeed;
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Movement movement;

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName){
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed = 0;
        this.movement = new Movement();
    }

    public double getCurrentSpeed() { return currentSpeed; }
    public void setCurrentSpeed(double speed) { this.currentSpeed = speed; } // Setter
    public String getModelName(){return modelName;}
    public Color getColor(){return color;}
    public void setColor(Color clr){color = clr;}

    public void turnNorth(){movement.turnNorth();}
    public void turnEast(){movement.turnEast();}
    public void turnWest(){movement.turnWest();}
    public void turnSouth(){movement.turnSouth();}
    public void move() {movement.move(currentSpeed);}

    public double getX(){return movement.getX();}
    public void setX(double amount){movement.setX(amount);}
    public double getY() {return movement.getY(); }
    public void setY(double amount){movement.setY(amount);}
}
