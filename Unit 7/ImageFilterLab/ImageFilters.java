import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class ImageFilters {
    public static void main(String[] args) {
        try {
            // Load an image file
            BufferedImage image = loadFile("images/landscape.jpg");

            // apply a filter
            flipX(image);

            // Save the edited file to desired location
            saveFile("images/edited-landscape.jpg", image);

            // to-do: create 9 more filters using the invertColors as a starting point
            // note you might need to run the filters separately to avoid altering the image
            // multiple times

            // to-do: save all changes as individual files using saveFile()

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // helper methods
    // This method searches the folder path to the target image and returns a
    // BufferedImage object
    // using the data from the file
    public static BufferedImage loadFile(String pathToImage) throws IOException {
        // Load an image file
        File inputFile = new File(pathToImage);
        BufferedImage image = ImageIO.read(inputFile);
        return image;

    }

    // This method creates a new JPG file at the target save location, and copies
    // the data from the
    // BufferedImage object to the file.
    public static void saveFile(String saveLocation, BufferedImage image) throws IOException {
        // Save the edited image
        File outputFile = new File(saveLocation);
        outputFile.createNewFile();
        ImageIO.write(image, "jpg", outputFile);
        System.out.println("Image color changed and saved successfully!");
    }

    // filter methods

    // invert colors
    public static void invertColors(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);

                // modify the RGB values of the color
                // the code below inverts colors
                color = new Color(255 - color.getRed(), 255 - color.getGreen(),
                        255 - color.getBlue());

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    public static void blackAndWhiteFilter(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);
                int avg = (color.getRed() + color.getBlue() + color.getGreen()) / 3;
                color = new Color(avg, avg, avg);
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    public static void blackAndWhiteFilterRed(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);
                int newC = color.getRed();
                color = new Color(newC, newC, newC);
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    public static void sepiaFilter(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);
                double luminance = ((color.getRed() * .3) + (color.getBlue() * .59) + (color.getGreen() * .11));
                if (luminance <= 62) {
                    if (luminance * 1.1 > 255) {
                        color = new Color(255, (int) luminance, (int) (luminance * .9));
                    } else {
                        color = new Color((int) (luminance * 1.1), (int) luminance, (int) (luminance * .9));
                    }
                } else if (luminance <= 192) {
                    if (luminance * 1.15 > 255) {
                        color = new Color(255, (int) luminance, (int) (luminance * .85));
                    } else {
                        color = new Color((int) (luminance * 1.15), (int) luminance, (int) (luminance * .85));
                    }

                } else {
                    if (luminance * 1.07 > 255) {
                        color = new Color(255, (int) luminance, (int) (luminance * .93));
                    } else {
                        color = new Color((int) (luminance * 1.07), (int) luminance, (int) (luminance * .93));
                    }

                }
                image.setRGB(x, y, color.getRGB());
            }
        }
    }

    public static void valenciaFilter(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                double weightr = 0;
                double weightg = 0;
                double weightb = 0;
                if (r <= 62) {
                    weightr = 1.1;
                } else if (r <= 192) {
                    weightr = 1;
                } else {
                    weightr = .9;
                }
                if (g <= 62) {
                    weightg = 1.1;
                } else if (g <= 192) {
                    weightg = 1;
                } else {
                    weightg = .9;
                }
                if (b <= 62) {
                    weightb = 1.1;
                } else if (b <= 192) {
                    weightb = 1;
                } else {
                    weightb = .9;
                }
                r = (int) ((r + 15) * weightr);
                g = (int) ((g + 15) * weightg);
                b = (int) ((b + 15) * weightb);
                if (r > 255) {
                    r = 255;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b > 255) {
                    b = 255;
                }
                color = new Color(r, g, b);
                image.setRGB(x, y, color.getRGB());
            }
        }
    }

    public static void valenciaFilter30(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                double weightr = 0;
                double weightg = 0;
                double weightb = 0;
                if (r <= 62) {
                    weightr = 1.1;
                } else if (r <= 192) {
                    weightr = 1;
                } else {
                    weightr = .9;
                }
                if (g <= 62) {
                    weightg = 1.1;
                } else if (g <= 192) {
                    weightg = 1;
                } else {
                    weightg = .9;
                }
                if (b <= 62) {
                    weightb = 1.1;
                } else if (b <= 192) {
                    weightb = 1;
                } else {
                    weightb = .9;
                }
                r = (int) ((r + 30) * weightr);
                g = (int) ((g + 30) * weightg);
                b = (int) ((b + 30) * weightb);
                if (r > 255) {
                    r = 255;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b > 255) {
                    b = 255;
                }
                color = new Color(r, g, b);
                image.setRGB(x, y, color.getRGB());
            }
        }
    }

    public static void leftMirror(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width / 2; x++) {
                int leftP = image.getRGB(x, y);
                int mirroredX = (width - 1) - x;
                image.setRGB(mirroredX, y, leftP);
            }
        }
    }

    public static void rightMirror(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = width / 2; x < width; x++) {
                int rightP = image.getRGB(x, y);
                int mirroredX = (width - 1) - x;
                image.setRGB(mirroredX, y, rightP);
            }
        }
    }

    public static void flipY(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = width / 2; x < width; x++) {
                int leftP = image.getRGB(x, y);
                int rightX = (width - 1) - x;
                int rightP = image.getRGB(rightX, y);
                image.setRGB(x, y, rightP);
                image.setRGB(rightX, y, leftP);
            }
        }
    }

    public static void flipX(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = height / 2; y < height; y++) {
                int topP = image.getRGB(x, y);
                int bottomY = (height - 1) - y;
                int bottomP = image.getRGB(x, bottomY);
                image.setRGB(x, y, bottomP);
                image.setRGB(x, bottomY, topP);
            }
        }
    }

}
