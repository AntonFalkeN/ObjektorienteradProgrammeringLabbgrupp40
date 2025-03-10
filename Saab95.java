import java.awt.*;

class Saab95 extends Car {
    private boolean turboOn;


    public Saab95(Color _color) {
        super(2,125, _color, "Saab95");
        this.turboOn = false;
    }

    public void setTurboOn(){
        turboOn = true;
        System.out.println("Turbo är på!");
    }

    public void setTurboOff(){
        turboOn = false;
        System.out.println("Turbo är av!");
    }

    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void Move(String direction) {
        move();
        return;
    }
}