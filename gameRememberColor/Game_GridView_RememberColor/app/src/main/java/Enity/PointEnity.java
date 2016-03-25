package Enity;

/**
 * Created by Kiên on 12/31/2015.
 */
public class PointEnity {
    private int id;
    private ColorEnity color_first;
    private ColorEnity color_last;
    private boolean isRight;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PointEnity(int id, ColorEnity color_first, ColorEnity color_last, boolean isRight,String text) {
        this.id = id;
        this.color_first = color_first;
        this.color_last = color_last;
        this.isRight = isRight;
        this.text = text;

    }

    public PointEnity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ColorEnity getColor_first() {
        return color_first;
    }

    public void setColor_first(ColorEnity color_first) {
        this.color_first = color_first;
    }

    public ColorEnity getColor_last() {
        return color_last;
    }

    public void setColor_last(ColorEnity color_last) {
        this.color_last = color_last;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }
}
