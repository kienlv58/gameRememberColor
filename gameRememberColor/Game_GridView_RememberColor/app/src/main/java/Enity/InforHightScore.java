package Enity;

import java.io.Serializable;

/**
 * Created by Kiên on 1/1/2016.
 */
public class InforHightScore implements Serializable {
    private String name;
    private int score;

    public InforHightScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public InforHightScore() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name+"\t \t \t \t"+this.score;

    }
}
