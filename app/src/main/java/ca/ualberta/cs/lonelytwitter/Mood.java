package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Malcolm on 2017-01-20.
 */
import java.util.Date;

public abstract class Mood {
    private Date date;
    private String mood;

    /**
     * Instantiates a new mood
     * @param mood A message relating to users mood
     */
    public Mood(String mood){
        this.date = new Date();
        this.mood = mood;
    }
    /**
     * Instantiates a new mood
     * @param date The date the mood was created
     * @param mood A message relating to users mood
     */
    public Mood(Date date, String mood) {
        this.date = date;
        this.mood = mood;
    }

    /**
     * Gets the date
     *
     * @return the date of the tweet
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the mood message
     *
     * @return the mood message of the tweet
     */
    public String getMood() {
        return mood;
    }

    /**
     * Sets the date
     */
    public void setMood(String mood) {
        this.mood = mood;
    }

    /**
     * Abstract method to format mood messages
     * @return none
     */
    public abstract String formatMood();
}
