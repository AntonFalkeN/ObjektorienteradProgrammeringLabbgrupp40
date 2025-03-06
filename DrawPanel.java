import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage volvoWorkshopImage;
    ArrayList<BufferedImage> imageList = new ArrayList<>();

    Model model = CarController.returnModel();
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        imageList.add(volvoImage);
        imageList.add(saabImage);
        imageList.add(scaniaImage);

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);// Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int ofsett = 0;
        for (Car car : model.cars){
            Image image;
            Point point;
            if (car instanceof Volvo240) {
                image = volvoImage;
                point = model.volvoPoint;
            }
            else if(car instanceof Saab95){
                image = saabImage;
                point = model.saabPoint;
            }
            else if(car instanceof Scania){
                image = scaniaImage;
                point = model.scaniaPoint;
            }
            else {
                image = volvoImage;
                point = model.volvoPoint;
            }
            g.drawImage(image, point.x, point.y + ofsett, null);
            ofsett += 100;
        }/*
        g.drawImage(volvoImage, model.volvoPoint.x, model.volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, model.saabPoint.x, model.saabPoint.y + 100, null);
        g.drawImage(scaniaImage, model.scaniaPoint.x, model.scaniaPoint.y + 200, null);*/
        g.drawImage(volvoWorkshopImage, model.volvoWorkshopPoint.x, model.volvoWorkshopPoint.y, null);
    }
}