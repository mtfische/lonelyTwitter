package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ejtang on 1/17/17.
 */

public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;
    private ArrayList<Mood> moodList;
    //private String hiddenString

    /**
     * getter function for date
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter function for Date
     *
     * @param date the date provided
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter function for tweet message
     *
     * @return The tweet text
     */
    public String getMessage() {
        return message;
    }

    /**
     * Instantiates a new tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date;
        this.setMessage(message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date(); //current time and date
    }

    /**
     * Abstract method to determine importance
     * @return none
     */
    public abstract Boolean isImportant();

    /**
     * Setter function for the tweet text
     *
     * @param message tweet plain text
     * @throws TweetTooLongException if the tweet is too long
     */
    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 144) {
            //todo throw new error here
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }

    /**
     * Getter function to get list of moods
     *
     * @return The mood list
     */
    public ArrayList<Mood> getMoodList() {
        return moodList;
    }

    /**
     * Setter function to set the mood list
     * @param moodList the moodlist to set
     */
    public void setMoodList(ArrayList<Mood> moodList) {
        this.moodList = moodList;
    }

    @Override
    public String toString(){
        return date.toString()+" | "+message;
    }
}


