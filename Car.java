import java.awt.*;

public abstract class Car {
    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name


    public Car(int _nrDoors, double _enginePower, Color _color, String _modelName,double _currentSpeed){
        nrDoors = _nrDoors;
        enginePower = _enginePower;
        color = _color;
        modelName = _modelName;
        currentSpeed = _currentSpeed;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public String getModelName(){return modelName;}
    public Color getColor(){return color;}

    public void setColor(Color clr){color = clr;}

    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

    protected double speedFactor(){return 0;}

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount < 0 || amount > 1) { //  Sanity-check: Only accept values between 0 and 1
            return;
        }

        double originalSpeed = currentSpeed;
        incrementSpeed(amount);
        if (originalSpeed > currentSpeed) { // Sanity-check: speed can't decrease
            return;
        }

        if (currentSpeed > enginePower) { // Sanity-check: currentSpeed can't exceed enginePower
            currentSpeed = enginePower;
        }

    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount < 0 || amount > 1) { //  Sanity-check: Only accept values between 0 and 1
            return;
        }

        double originalSpeed = currentSpeed;
        decrementSpeed(amount);
        if (originalSpeed < currentSpeed) { // Sanity-check: speed can't increase
            return;
        }

        if (currentSpeed < 0) { // Sanity-check: currentSpeed can't be lower than 0
            currentSpeed = 0;
        }

    }


}

