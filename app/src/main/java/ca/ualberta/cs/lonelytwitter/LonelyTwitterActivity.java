package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is the main view class of the project. <br> in this class, user interaction
 * and file manipulation is performed.
 * All files are in the form "json" files that are stored in emulator's access
 * <pre>
 *     	pre-formatted text: <br>
 *     	    	File explorer -> data -> data -> ca.ualberta.cs.lone;ytwitter -> files -> file.sac
 * <pre/>
 * <code> begin <br>
 *     some suedo code <br>
 *     Ends. <code/>
 * The file name is indicated in the &nbsp &nbsp &nbsp FILENAME construct
 * <ul>
 *     	<li>item 1<li/>
 *     	<li>item 2<li/>
 *     	<li>item 3<li/>
 * </ul>
 * <ol>
 *     <li>item 1<li/>
 *     <li>item 2<li/>
 *     <li>item 3<li/>
 * <ol/>
 *
 * @author mtfische
 * @version 1.0
 * @see Tweet
 * @since 0.5
 */
public class LonelyTwitterActivity extends Activity {
    /**
     * The file that all the tweets are saved there. The format of the file is JSON
     * @see #loadFromFile()
     * @see #saveInFile()
    */
	private static final String FILENAME = "file.sav";
    private enum TweetListOrdering {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING, TEXT_DESCENDING};
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
    private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        /*Saves the tweet list to disk.*/
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                text = trimExtraSpaces(text);
				Tweet tweet = new NormalTweet(text);
                tweetList.add(tweet);

                adapter.notifyDataSetChanged();

                saveInFile();

			}
		});
		/* Clears the tweet List.*/
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
					
				deleteFile(FILENAME);
               	tweetList.clear();

				adapter.notifyDataSetChanged();

			}
		});
		
	}

    /**
     * Begins on the start of the app
     * Loads stored tweets from file and displayes to screen interface
     */
    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}
    /**
     * Load tweets from specified file
     *
     * @throws  TweetTooLongException if the text is too long
     * @exception FileNotFoundException if the file is not created first
     */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            //Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2017-01-24 18:19
            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
            tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
            tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

    /**
     * Trims extra spaces using regular expression.
     * @param inputString string that needs to be cleared of extra spaces
     * @return resulting string
     */
    private String trimExtraSpaces(String inputString){
        inputString = inputString.replaceAll("\\s+"," ");
        return inputString;
    }

    /**
     * This method sorts the tweet list.
     * @param ordering ordering to be used
     */
    private void sortTweetListItems(TweetListOrdering ordering){

    }
    /**
     * Saves tweets to a specified file in the JSON format.
     * @throws FileNotFoundException if the folder doesnt exist
     * @exception RuntimeException if
     */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
            // TODO: Handle the Exception properly later
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
