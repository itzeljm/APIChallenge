package challenge;

import java.io.*;
import java.net.*;
import org.json.*;


/** Class that returns a string in reverse. 
* @author Itzel Martinez
*
*/

public class ReverseString {

	/** Method that returns a reverse string. */
	public static void main(String[] args) throws Exception {
		try {
			
			String id = challenge.BeginChallenge.identifier(); 			
 			JSONObject retobj = challenge.BeginChallenge.post("http://challenge.code2040.org/api/getstring", id);
			
			String reverseString = retobj.getString("result");
 			reverseString = new StringBuilder(reverseString).reverse().toString();

 			JSONObject message = new JSONObject();
 			message.put("token", challenge.BeginChallenge.token());
 			message.put("string", reverseString);
 			String mssg = message.toString();

 			JSONObject result = challenge.BeginChallenge.post("http://challenge.code2040.org/api/validatestring", mssg);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
