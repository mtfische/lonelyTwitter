package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Malcolm on 2017-01-20.
 */

public class Happy extends Mood {
    public Happy(String mood) {
        super(mood);
    }

    public Happy(Date date, String mood) {
        super(date, mood);
    }

    public String formatMood(){
        return ":-) Tweet is "+this.getMood();
    }
}
