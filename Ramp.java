public class Ramp {
    private int angle;
    private final int maxAngle;

    public Ramp(int maxAngle) {
        this.angle = 0;
        this.maxAngle = maxAngle;
    }

    public void raise(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        } else {
            angle = Math.min(angle + amount, maxAngle);
        }
    }


    public void lower(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        } else {
            angle = Math.max(angle - amount, 0);
        }
    }

    public int getAngle() {return angle;}

    public boolean isLowered(){return angle == maxAngle;}
}
