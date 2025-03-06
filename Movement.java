public class Movement {
    private double x;
    private double y;
    protected String currentDirection;

    public void turnNorth(){
        currentDirection = "north";
    }
    public void turnEast(){
        currentDirection = "east";
    }
    public void turnWest(){
        currentDirection = "west";
    }
    public void turnSouth(){
        currentDirection = "south";
    }

    public void move(double currentSpeed){
        switch(currentDirection){
            case "west":
                x = x - currentSpeed;
                break;
            case "east":
                x = x + currentSpeed;
                break;
            case "north":
                y = y + currentSpeed;
                break;
            case "south":
                y = y - currentSpeed;
                break;
            default:
                currentDirection = "east";
                move(currentSpeed);
        }
    }

    public double getX(){
        return x;
    }
    public void setX(double amount) {x = amount;}
    public double getY() {
        return y;
    }
    public void setY(double amount) {y = amount;}
}
