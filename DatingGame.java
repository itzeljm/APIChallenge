package challenge;

import java.io.*;
import java.net.*;
import org.json.*;
import org.joda.time.*;

/** Class that takes in a dictionary.
 * The value for datestamp is a string, formatted as an ISO 8601 datestamp.
 * Example { Datestamp : 2000-11-19T05:10:00.000Z }.
 * The value for interval is a number of seconds.
 * This class adds the interval to the date, then returns the resulting date to the API.
 * It also checks the grades for the API Challenge.
 *
 * @author Itzel Martinez
 */


public class DatingGame {

    /** Main method that runs the file taking in arguments ARGS. */
    public static void main(String[] args) throws Exception {
	System.out.println("Running the Last Stage of the Challenge : DatingGame.");
	System.out.println("================================================================ \n");

	try {
	    String id = challenge.BeginChallenge.identifier();

	    System.out.println("Retrieving Challenge Data from Server : ");
	    JSONObject retobj = challenge.BeginChallenge.post("http://challenge.code2040.org/api/time ", id);
	    JSONObject pot = retobj.getJSONObject("result");

	    String datestamp = pot.getString("datestamp");
	    DateTime data = DateTime.parse(datestamp);
	    int seconds = pot.getInt("interval");

	    System.out.println("Datestamp Received : " + datestamp);
	    System.out.println("Interval Received : " + seconds + "\n");


	    data = data.plusSeconds(seconds);

	    JSONObject tosend = new JSONObject();
	    tosend.put("token", challenge.BeginChallenge.token());
	    tosend.put("datestamp", data.toString());

	    System.out.println("Resulting Date: " + data.toString() + "\n");
	    System.out.println("Posting Challenge Results to Server : ");
	    JSONObject res = challenge.BeginChallenge.post("http://challenge.code2040.org/api/validatetime", tosend.toString());

	    challenge.BeginChallenge.checkStatus();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
