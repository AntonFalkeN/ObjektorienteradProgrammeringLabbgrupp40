import java.awt.*;

public class VehicleFactory {
    private Color color = Color.BLACK;

    public VehicleFactory() {

    }

    ;

     Object CreateVehicle(String model) {
        Object v;

        switch (model) {
            case "Saab95":
                v = new Saab95(color);
                return v;
            case "Volvo240":
                v = new Volvo240(color);
                return v;
            case "Scania":
                v = new Scania();
            case "Peter":
                v = new Peterbilt388CarCarrier(9);
                return v;
            default:
                throw new ClassCastException();
        }
    }
}