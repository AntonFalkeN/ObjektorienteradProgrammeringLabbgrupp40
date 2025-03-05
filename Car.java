import java.awt.*;


public abstract class Car extends Vehicle {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors,enginePower, color, modelName);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
    }

    public int getNrDoors(){return nrDoors;}
    public double getEnginePower(){
        return enginePower;
    }

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

}