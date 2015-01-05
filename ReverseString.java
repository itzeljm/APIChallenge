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
		System.out.println("Running the First Stage of the Challenge : ReverseString.");		
		System.out.println("========================================================= \n");
		
		try {
			String id = challenge.BeginChallenge.identifier(); 

			System.out.println("Retrieving Challenge Data from Server : ");	
 			JSONObject retobj = challenge.BeginChallenge.post("http://challenge.code2040.org/api/getstring", id);
			
			String reverseString = retobj.getString("result");
			System.out.println("String Received : " + reverseString);
 			reverseString = new StringBuilder(reverseString).reverse().toString();
 			System.out.println("String Reversed : " + reverseString + "\n");



 			JSONObject message = new JSONObject();
 			message.put("token", challenge.BeginChallenge.token());
 			message.put("string", reverseString);
 			String mssg = message.toString();

 			System.out.println("Posting Challenge Results to Server : ");
 			JSONObject result = challenge.BeginChallenge.post("http://challenge.code2040.org/api/validatestring", mssg);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
