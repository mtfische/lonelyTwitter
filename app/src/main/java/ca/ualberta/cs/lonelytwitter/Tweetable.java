package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ejtang on 1/17/17.
 */

/**
 * Interface for the Tweet class
 *
 * @see Tweet
 */
public interface Tweetable {
    public String getMessage();
    public Date getDate();
}
