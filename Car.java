import java.awt.*;


public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    protected double x_value;
    protected  double y_value;
    protected String currentDirection;

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

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        try {  //  Sanity-check: Only accept values between 0 and 1
            if (amount < 0 || amount > 1)
                throw new IllegalArgumentException();
        }
        catch(Exception e){
            System.out.println("Fel, kontrollera att värdet är mellan 0 och 1: " + e);
       }
        incrementSpeed(amount);

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

    public void turnLeft(){
        currentDirection = "left";
        x_value = Move();
    }

    public void turnRight(){
        currentDirection = "right";
        x_value = Move();
    }
    public double Move(){
        double x = 0;
        switch(currentDirection){
            case "left":
                x = x_value - currentSpeed;
                break;
            case "right":
                x = x_value + currentSpeed;
                break;
        }
        return x;
    }
}