package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ejtang on 1/17/17.
 */

/**
 * An exception thrown when the tween is too long
 */
public class TweetTooLongException  extends Exception{
    public TweetTooLongException() {

    }

    public TweetTooLongException(String detailMessage) {
        super(detailMessage);
    }
}
