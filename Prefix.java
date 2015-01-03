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
			JSONArray returnArray = new JSONArray();
			
			JSONObject ident = new JSONObject();
			ident.put("token", challenge.BeginChallenge.token()); //repetitive code make a final one

			JSONObject results = challenge.BeginChallenge.post(" http://challenge.code2040.org/api/prefix", ident.toString());
			JSONObject strings = results.getJSONObject("result");

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
			
			JSONObject b = challenge.BeginChallenge.post(" http://challenge.code2040.org/api/validateprefix", tosend.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}