package challenge;

import java.io.*;
import java.net.*;
import org.json.*;

/** File to register to the code2040 API Challenge.
* This file also contains some methods that were used often throughout the different stages of the challenge.
* @author Itzel Martinez 
*
*/
public class BeginChallenge {
	
	/** Token that identifies my code and I. */
	public static final String IDENTIFIER = "dtqLuA8IIc";

	/** Main method that runs the file taking in arguments ARGS. */
	public static void main(String[] args) throws Exception {
		
		try {

			JSONObject dictionary = new JSONObject();
			dictionary.put("email", "j_itzel_m@berkeley.edu");
			dictionary.put("github", "https://github.com/itzeljm/APIChallenge.git");

			String SENDING = dictionary.toString();
			String REQUEST = "http://challenge.code2040.org/api/register";

			String token = post(REQUEST, SENDING).getString("result");


		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/** Method that returns a string token that identifies my code. */
	public static String token() throws Exception {
		try {
			return IDENTIFIER;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/** Method that posts the given URLPARAMETERS to the desired LOCATION which is a url, and returns 
	* a string message.
	*/
	public static JSONObject post(String location, String urlParameters) throws Exception {
		
		HttpURLConnection connection = null;
		System.out.println("Posting " + urlParameters + " to : " + location);

		try {

			URL absoluteUrl  = new URL(location);
			connection = (HttpURLConnection) absoluteUrl.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);

			DataOutputStream data = new DataOutputStream(connection.getOutputStream());
			data.writeBytes(urlParameters);
			data.flush();
			data.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			JSONObject retmssg = new JSONObject(in.readLine());
			in.close();
			
			String received = retmssg.toString();

			System.out.println("Received : " + received);	
			System.out.println(" ");

			return retmssg;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}


	/** Method that checks grades on the API Challenge, it doesn't take any parameters. */
	public static void checkStatus() {
		try {
			JSONObject checkstatus = new JSONObject();
			checkstatus.put("token", token());
			String tosend = checkstatus.toString();
			JSONObject grades = post("http://challenge.code2040.org/api/status", tosend);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}