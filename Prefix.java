package challenge;

import java.io.*;
import java.net.*;
import org.json.*;


/** Class takes in a dictionary. 
* The first value, prefix, is a string. 
* The second value, array, is an array of strings. 
* It returns an array containing only the strings that do not start with that prefix.
*
* @author Itzel Martinez
*
*/

public class Prefix {

	/** Main method that runs the program taking in arguments ARGS. */
	public static void main(String[] args) throws Exception {

		try {
			
			String id = challenge.BeginChallenge.identifier();

			JSONObject results = challenge.BeginChallenge.post(" http://challenge.code2040.org/api/prefix", id);
			JSONObject strings = results.getJSONObject("result");

			JSONArray returnArray = new JSONArray();
			JSONArray stringArray = strings.getJSONArray("array");
			String pref = strings.getString("prefix");


			for (int n = 0; n < stringArray.length(); n++) {
				if (!stringArray.getString(n).startsWith(pref)) {
					returnArray.put(stringArray.getString(n));
				}
			}


			JSONObject tosend = new JSONObject();
			tosend.put("token", challenge.BeginChallenge.token()); // redundant code
			tosend.put("array" , returnArray);
			
			JSONObject result = challenge.BeginChallenge.post(" http://challenge.code2040.org/api/validateprefix", tosend.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}