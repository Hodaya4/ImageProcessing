import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.net.URL;


public class MainContent extends JPanel {
    private JTextField input;
    private JButton search;
    private JLabel pic;


    public MainContent() {
        this.setBounds(0,0, Constants.WIDTH, Constants.HEIGHT);
        this.setDoubleBuffered(true);
        this.setLayout(null);

        this.input = new JTextField();
        this.input.setBounds(Constants.INPUT_X, Constants.INPUT_Y, Constants.INPUT_WIDTH, Constants.INPUT_HEIGHT);
        this.add(this.input);
        this.input.setVisible(true);

        this.search = new JButton("Search");
        this.search.setBounds(Constants.INPUT_X + Constants.INPUT_WIDTH + 1, Constants.INPUT_Y
                , Constants.INPUT_WIDTH, Constants.INPUT_HEIGHT);
        this.add(this.search);
        this.search.addActionListener((e) -> {
            String fInput = this.input.getText();
            System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ IDEA Community Edition 2021.2.3\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            String FACEBOOK_URL = "https://www.facebook.com/";
            driver.get(FACEBOOK_URL + fInput);
            WebElement outerPic = driver.findElement(By.tagName("image"));
            outerPic.click();
            WebElement innerPic = driver.findElement(By.tagName("img"));
            String picLink = innerPic.getAttribute("src");
            try {
                URL picUrl = new URL(picLink);
                BufferedImage bufferedImage = ImageIO.read(picUrl);
                ImageIcon image = new ImageIcon(bufferedImage);
                this.pic = new JLabel();
                this.pic.setBounds(0, 100, Constants.WIDTH, Constants.HEIGHT);
                this.pic.setIcon(image);
                this.add(this.pic);
                this.repaint();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //new Thread(() -> {
                //    try {
                    //        System.setProperty("webdriver.chrome.driver", "D:\\IntelliJ IDEA Community Edition 2021.2.3\\chromedriver.exe");
                    //        ChromeDriver driver = new ChromeDriver();
                    //        String FACEBOOK_URL ="https://www.facebook.com/";
                    //        driver.get(FACEBOOK_URL + fInput);
                    //        Thread.sleep(50);
                    //        WebElement svg = driver.findElement(By.className("pzggbiyp"));
                    //        svg.click();
                    //        Thread.sleep(50);
                    //        WebElement img = driver.findElement(By.cssSelector("img[src=\"));
                            //        String src = img.getAttribute("src");
                    //        URL imgUrl = new URL(src);
                    //        BufferedImage saveImage = ImageIO.read(imgUrl);
                    //        ImageIO.write(saveImage, "png", new File("image.png"));
                    //    } catch (Exception ex) {
                    //        ex.printStackTrace();
                    //    }
                //}).start();



        });



    }


}
