package challenge;

import java.io.*;
import java.net.*;
import org.json.*;
import org.joda.time.*;

/** Class that takes in a dictionary. 
* The value for datestamp is a string, formatted as an ISO 8601 datestamp. 
* Example { Datestamp : 2000-11-19T05:10:00.000Z }.
* The value for interval is a number of seconds.
* This class adds the interval to the date, then return the resulting date to the API. 
*
* @author Itzel Martinez
*/


public class DatingGame {
	
	/** Main method that runs the file taking in arguments ARGS. */
	public static void main(String[] args) throws Exception {
		
		try {

			JSONObject ident = new JSONObject();
			ident.put("token", challenge.BeginChallenge.token());
			JSONObject retobj = challenge.BeginChallenge.post("http://challenge.code2040.org/api/time ", ident.toString());

			JSONObject pot = retobj.getJSONObject("result");

			DateTime data = DateTime.parse(pot.getString("datestamp"));
			int seconds = pot.getInt("interval");
			data = data.plusSeconds(seconds);

			JSONObject tosend = new JSONObject();
			tosend.put("token", challenge.BeginChallenge.token());
			tosend.put("datestamp", data.toString());

			JSONObject res = challenge.BeginChallenge.post("http://challenge.code2040.org/api/validatetime", tosend.toString());
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}