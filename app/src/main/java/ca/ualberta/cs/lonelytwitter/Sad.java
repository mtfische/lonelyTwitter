package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Malcolm on 2017-01-20.
 */

public class Sad extends Mood {
    /**
     *instantiates a new Sad mood
     * @param mood A message relating to users mood
     */
    public Sad(String mood) {
        super(mood);
    }
    /**
     * Instantiates a new Sad mood
     * @param date The date the mood was created
     * @param mood A message relating to users mood
     */
    public Sad(Date date, String mood) {
        super(date, mood);
    }
    /**
     * Formats the mood message for Sad moods
     * @return A message specific to Sad moods
     */
    public String formatMood(){
        return ":-( The tweet is "+this.getMood();
    }
}
