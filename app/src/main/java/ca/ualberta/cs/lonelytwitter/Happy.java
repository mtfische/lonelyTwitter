package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Malcolm on 2017-01-20.
 */

/**
 *
 * @see Mood
 */
public class Happy extends Mood {
    /**
     * Instantiates a new Happy mood
     * @param mood A message relating to users mood
     */
    public Happy(String mood) {
        super(mood);
    }

    /**
     * Instantiates a new Happy mood
     * @param date The date the mood was created
     * @param mood A message relating to users mood
     */
    public Happy(Date date, String mood) {
        super(date, mood);
    }

    /**
     * Formats the mood message for Happy moods
     * @return A message specific to happy
     */
    public String formatMood(){
        return ":-) Tweet is "+this.getMood();
    }
}
