import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Filters {
    private BufferedImage image;

    public Filters(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage grayScale() {
        BufferedImage tempImage = this.image;
        for (int x = 0; x < tempImage.getWidth(); x++) {
            for (int y = 0; y < tempImage.getHeight(); y++) {
                int pixel1 = tempImage.getRGB(x, y);
                Color color1 = new Color(pixel1);
                int red = color1.getRed();
                int green = color1.getGreen();
                int blue = color1.getBlue();
                int average = (red + green + blue) / 3;
                Color color = new Color(average, average, average);
                tempImage.setRGB(x, y, color.getRGB());
            }
        } return tempImage;
    }

    public BufferedImage colorShiftRight() {
        BufferedImage tempImage = this.image;
        for (int x = 0; x < tempImage.getWidth(); x++) {
            for (int y = 0; y < tempImage.getHeight(); y++) {
                int pixel1 = tempImage.getRGB(x, y);
                Color color1 = new Color(pixel1);
                int red = color1.getRed();
                int green = color1.getGreen();
                int blue = color1.getBlue();
                int tempRed = red;
                red = green;
                green = blue;
                blue = tempRed;
                Color color = new Color(red, green, blue);
                tempImage.setRGB(x, y, color.getRGB());
            }
        } return tempImage;
    }

    public BufferedImage colorShiftLeft() {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel1 = image.getRGB(x, y);
                Color color1 = new Color(pixel1);
                int red = color1.getRed();
                int green = color1.getGreen();
                int blue = color1.getBlue();
                int tempRed = red;
                red = blue;
                blue = green;
                green = tempRed;
                Color color = new Color(red, green, blue);
                image.setRGB(x, y, color.getRGB());
            }
        } return image;
    }


}
