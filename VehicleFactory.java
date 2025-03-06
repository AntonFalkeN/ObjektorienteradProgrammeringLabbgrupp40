import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

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
                return v;
            case "Peter":
                v = new Peterbilt388CarCarrier(9);
                return v;
            default:
                throw new ClassCastException();
        }
    }
    public Object CreateRandom(){
         List<String> randomList = new ArrayList<>();
         randomList.add("Volvo240");
         randomList.add("Saab95");
         randomList.add("Scania");
         int randomNum = (int)(Math.random() * 3);
         String x = randomList.get(randomNum);
         Object car = CreateVehicle(x);
         return car;
    }
}