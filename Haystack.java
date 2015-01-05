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
		System.out.println("Running the Second Stage of the Challenge : Haystack.");
		System.out.println("===================================================== \n");	
		
		try {		
			String URL = "http://challenge.code2040.org/api/haystack";
			String id = challenge.BeginChallenge.identifier();

			System.out.println("Retrieving Challenge Data from Server : ");	
			JSONObject obtained = challenge.BeginChallenge.post(URL, id);
			JSONObject barn = obtained.getJSONObject("result");
			
			JSONArray haystack = barn.getJSONArray("haystack");
			String needle = barn.getString("needle");

			System.out.println("Haystack Received : " + haystack.toString());
			System.out.println("Needle Received : " + needle + "\n");


			int position = 0;

			for (int index = 0; index < haystack.length(); index++) {
				if (haystack.getString(index).equals(needle)) {
					position = index;
					break; 
				}
			}

			JSONObject tosend = new JSONObject();
			tosend.put("token", challenge.BeginChallenge.token());
			tosend.put("needle", position);
						
			System.out.println("Index of Needle : " + position + "\n");
			System.out.println("Posting Challenge Results to Server : ");
			JSONObject result  = challenge.BeginChallenge.post("http://challenge.code2040.org/api/validateneedle", tosend.toString());			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
