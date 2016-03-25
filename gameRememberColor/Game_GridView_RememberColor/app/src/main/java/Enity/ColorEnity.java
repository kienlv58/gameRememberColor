package Enity;

/**
 * Created by Kiên on 12/31/2015.
 */
public class ColorEnity {
    private int anpha;
    private int red;
    private  int green;
    private int blue;

    public ColorEnity(int anpha, int red, int green, int blue) {
        this.anpha = anpha;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public ColorEnity() {
    }

    public int getAnpha() {
        return anpha;
    }

    public void setAnpha(int anpha) {
        this.anpha = anpha;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
