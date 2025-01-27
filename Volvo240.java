import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    Volvo240(int _nrDoors, double _enginePower, Color _color, String _modelName, double _currentSpeed){
        super(_nrDoors, _enginePower, _color, _modelName, _currentSpeed);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override public void incrementSpeed(double amount){
	    double currentSpeed = getCurrentSpeed();
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    @Override public void decrementSpeed(double amount){
        double currentSpeed = getCurrentSpeed();
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
