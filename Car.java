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

    protected double speedFactor(){return 0;}

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void turnLeft(){
        x_value = Move("left");
        currentDirection = "left";
    }

    public void turnRight(){
        x_value = Move("right");
        currentDirection = "right";
    }
    public double Move(String direction){
        double x = 0;
        switch(direction){
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