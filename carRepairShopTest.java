import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class carRepairShopTest {
    carRepairShop<Saab95> saabShop = new carRepairShop<>(1);
    carRepairShop<Volvo240> volvoShop = new carRepairShop<>(1);
    carRepairShop<Car> carShop = new carRepairShop<>(2);
    Volvo240 v = new Volvo240(Color.black);
    Saab95 s = new Saab95(Color.BLACK);
    Saab95 s1 = new Saab95(Color.BLACK);

    @BeforeEach
    void setUp() {
    }

    @Test
    void submitCar() {
        //Behöver inte testa att lägga till fel i bil eftersom det då inte går att kompilera
        int sizeBefore = saabShop.getCars().size();
        saabShop.submitCar(s);
        assertEquals(sizeBefore+1, saabShop.getCars().size());
        assertFalse(saabShop.submitCar(s1));

        int sizeBeforeV = carShop.getCars().size();
        carShop.submitCar(s);
        assertEquals(sizeBefore+1, carShop.getCars().size());
        carShop.submitCar(v);
        assertFalse(carShop.submitCar(s1));
    }

    @Test
    void returnCar() {
        saabShop.submitCar(s);
        int sizeBefore = saabShop.getCars().size();
        assertEquals(saabShop.returnCar(), s);
        saabShop.submitCar(s);
        saabShop.returnCar();
        assertEquals(sizeBefore-1, saabShop.getCars().size());
    }
}