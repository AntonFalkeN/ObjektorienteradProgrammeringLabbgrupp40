import java.awt.*;


public abstract class Car{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed;
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Movement movement;

    public Car(int _nrDoors, double _enginePower, Color _color, String _modelName){
        nrDoors = _nrDoors;
        enginePower = _enginePower;
        color = _color;
        modelName = _modelName;
        currentSpeed = 0;
        movement = new Movement();
    }

    public int getNrDoors(){return nrDoors;}
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed() { return currentSpeed; }
    public void setCurrentSpeed(double speed) { this.currentSpeed = speed; } // Setter
    public String getModelName(){return modelName;}
    public Color getColor(){return color;}
    public void setColor(Color clr){color = clr;}

    public void startEngine(){setCurrentSpeed(0.1);}
    public void stopEngine(){setCurrentSpeed(0);}

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    protected void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1) //  Sanity-check: Only accept values between 0 and 1
            throw new IllegalArgumentException();
        else {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1) { //  Sanity-check: Only accept values between 0 and 1
            throw new IllegalArgumentException();
        } else {
            decrementSpeed(amount);
        }
    }

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