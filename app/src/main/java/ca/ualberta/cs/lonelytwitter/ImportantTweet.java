package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ejtang on 1/17/17.
 */

public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public ImportantTweet(Date date, String message) throws TweetTooLongException{
        super(date, message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /**
     * Flag for whether the tweet is important
     *
     * @return Whether the tweet is important
     */
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "!!!!";
    }
}
