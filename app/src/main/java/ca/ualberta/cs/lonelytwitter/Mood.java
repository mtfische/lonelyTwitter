package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Malcolm on 2017-01-20.
 */
import java.util.Date;

public abstract class Mood {
    private Date date;
    private String mood;

    public Mood(String mood){
        this.date = new Date();
        this.mood = mood;
    }

    public Mood(Date date, String mood) {
        this.date = date;
        this.mood = mood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public abstract String formatMood();
}
