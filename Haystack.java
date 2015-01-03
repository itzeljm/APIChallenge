package challenge;

import java.io.*;
import java.net.*;
import org.json.*;


/** Class that takes in a dictionary with two values and keys. 
* The first value, needle, is a string. 
* The second value, haystack, is an array of strings. 
* This class tells the API where the needle is in the array of strings.
*
* @author Itzel Martinez
*
*/

public class Haystack {

	/** Method that runs the file taking in arguments ARGS. */
	public static void main(String[] args) throws Exception {
		try {		
			String URL = "http://challenge.code2040.org/api/haystack";
			String id = challenge.BeginChallenge.identifier();

			JSONObject obtained = challenge.BeginChallenge.post(URL, id);
			JSONObject barn = obtained.getJSONObject("result");
			
			JSONArray haystack = barn.getJSONArray("haystack");
			String needle = barn.getString("needle");

			int jackpot = 0;

			for (int location = 0; location < haystack.length(); location++) {
				if (haystack.getString(location).equals(needle)) {
					jackpot = location;
					break; 
				}
			}

			JSONObject tosend = new JSONObject();
			tosend.put("token", challenge.BeginChallenge.token());
			tosend.put("needle", jackpot);

			JSONObject result  = challenge.BeginChallenge.post("http://challenge.code2040.org/api/validateneedle", tosend.toString());			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
