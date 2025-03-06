import java.awt.*;

public class Application {
    public static void main(String[] args) {
        // Instance of this class
        //Model model = new Model();
        CarController cc = new CarController();
        //cc.cars.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.model.frame = new CarView("CarSim 1.0", cc);

        Car volvo = (Car)cc.model.VF.CreateVehicle("Volvo240");
        Car saab = (Car)cc.model.VF.CreateVehicle("Saab95");
        Car Scania = (Car)cc.model.VF.CreateVehicle("Scania");
        cc.model.cars.add(volvo);
        cc.model.cars.add(saab);
        cc.model.cars.add(Scania);
        cc.model.announcer.subscribeStopStart(volvo);
        cc.model.announcer.subscribeStopStart(saab);
        cc.model.announcer.subscribeTurboOn(saab);
        cc.model.announcer.subscribeStopStart(Scania);

        // Start the timer
        cc.timer.start();

    }
}
