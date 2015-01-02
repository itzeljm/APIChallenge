package challenge;
import challenge.*;

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
			JSONObject ident = new JSONObject();
			ident.put("token", challenge.BeginChallenge.token());
			String identifier = ident.toString();
 			
 			JSONObject retobj = challenge.BeginChallenge.post("http://challenge.code2040.org/api/getstring", identifier);
			
			String reverseString = retobj.getString("result");
 			reverseString = new StringBuilder(reverseString).reverse().toString();

 			JSONObject message = new JSONObject();
 			message.put("token", challenge.BeginChallenge.token());
 			message.put("string", reverseString);
 			String mssg = message.toString();

 			JSONObject res = challenge.BeginChallenge.post("http://challenge.code2040.org/api/validatestring", mssg);
			//String result = res.getString("result");
			//System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
