import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 02/09/13
 * Time: 14:54
 */

public class TestImagen {

    public static void main(String[] args) {
        BufferedImage org = getImage("homer.gif");
        BufferedImage negative = getNegativeImage(org);
        File outputfile = new File("negativo.gif");
        try {
            ImageIO.write(negative, "GIF", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getImage(String imageName) {
        try {
            File input = new File(imageName);
            BufferedImage image = ImageIO.read(input);
            return image;
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
        return null;
    }

    public static BufferedImage getNegativeImage(BufferedImage img) {
        int w1 = img.getWidth();
        int h1 = img.getHeight();

        BufferedImage gray = new BufferedImage(w1, h1, 1);
        int value, alpha, r, g, b;
        for (int i = 0; i < w1; i++) {
            for (int j = 0; j < h1; j++) {
                value = img.getRGB(i, j); // store value
                alpha = getAlpha(value);
                r = 255 - getRed(value);
                g = 255 - getGreen(value);
                b = 255 - getBlue(value);

                value = createRGB(alpha, r, g, b);
                gray.setRGB(i, j, value);
            }
        }
        return gray;
    }

    public static int createRGB(int alpha, int r, int g, int b) {
        int rgb = (alpha << 24) + (r << 16) + (g << 8) + b;
        return rgb;
    }

    public static int getAlpha(int rgb) {
        return (rgb >> 24) & 0xFF;
    }

    public static int getRed(int rgb) {
        return (rgb >> 16) & 0xFF;
    }

    public static int getGreen(int rgb) {
        return (rgb >> 8) & 0xFF;
    }

    public static int getBlue(int rgb) {
        return rgb & 0xFF;
    }
}