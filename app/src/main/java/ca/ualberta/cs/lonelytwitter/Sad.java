package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Malcolm on 2017-01-20.
 */

public class Sad extends Mood {
    public Sad(String mood) {
        super(mood);
    }

    public Sad(Date date, String mood) {
        super(date, mood);
    }
    public String formatMood(){
        return ":-( The tweet is "+this.getMood();
    }
}
