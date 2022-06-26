import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Filters {
    private BufferedImage image;
    private File out;

    public Filters(BufferedImage image) {
        this.image = image;
        this.out = new File("C:\\filterPics\\Basic.png");
        try {
            ImageIO.write(image , "png" , out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BufferedImage grayScale() {
        BufferedImage tempImg = null;
        try {
            tempImg = ImageIO.read(this.out);
            for (int x = 0; x < tempImg.getWidth(); x++) {
                for (int y = 0; y < tempImg.getHeight(); y++) {
                    int pixel1 = tempImg.getRGB(x, y);
                    Color color1 = new Color(pixel1);
                    int red = color1.getRed();
                    int green = color1.getGreen();
                    int blue = color1.getBlue();
                    int average = (red + green + blue) / 3;
                    Color color = new Color(average, average, average);
                    tempImg.setRGB(x, y, color.getRGB());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempImg;
    }

    public BufferedImage colorShiftRight() {
        BufferedImage tempImg = null;
        try {
            tempImg = ImageIO.read(this.out);
            for (int x = 0; x < tempImg.getWidth(); x++) {
                for (int y = 0; y < tempImg.getHeight(); y++) {
                    int pixel1 = tempImg.getRGB(x, y);
                    Color color1 = new Color(pixel1);
                    int red = color1.getRed();
                    int green = color1.getGreen();
                    int blue = color1.getBlue();
                    int tempRed = red;
                    red = green;
                    green = blue;
                    blue = tempRed;
                    Color color = new Color(red, green, blue);
                    tempImg.setRGB(x, y, color.getRGB());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempImg;
    }

    public BufferedImage colorShiftLeft() {
        BufferedImage tempImg = null;
        try {
            tempImg = ImageIO.read(this.out);
            for (int x = 0; x < tempImg.getWidth(); x++) {
                for (int y = 0; y < tempImg.getHeight(); y++) {
                    int pixel1 = tempImg.getRGB(x, y);
                    Color color1 = new Color(pixel1);
                    int red = color1.getRed();
                    int green = color1.getGreen();
                    int blue = color1.getBlue();
                    int tempRed = red;
                    red = blue;
                    blue = green;
                    green = tempRed;
                    Color color = new Color(red, green, blue);
                    tempImg.setRGB(x, y, color.getRGB());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempImg;
    }


}
