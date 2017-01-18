package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ejtang on 1/17/17.
 */

public class Tweet {
    private Date date;
    private String message;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date;
        this.setMessage(message);
    }
    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date(); //current time and date
    }

    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 144) {
            //todo throw new error here
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }
}
