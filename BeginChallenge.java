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

			System.out.println("Connecting to the Registration Endpoint.");
			System.out.println("======================================== \n");
			JSONObject dictionary = new JSONObject();
			dictionary.put("email", "j_itzel_m@berkeley.edu");
			dictionary.put("github", "https://github.com/itzeljm/APIChallenge.git");

			String SENDING = dictionary.toString();
			String REQUEST = "http://challenge.code2040.org/api/register";

			System.out.println("Retrieving Registration Data from Server : ");	
			String token = post(REQUEST, SENDING).getString("result");
			System.out.println("Token Received :" + token + "\n");

			checkStatus();


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

	/** Method that returns the string contents of a JSON Object that contains my token. */
	public static String identifier() throws Exception {
		try {
			JSONObject identifier = new JSONObject(); 
			identifier.put("token", token());
			String content = identifier.toString();
			return content;
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
		System.out.println("\nPOST : " + urlParameters); 
		System.out.println("to : " + location);

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

			System.out.println("Response : " + received + "\n");	

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
			System.out.println("Retrieving Grades from Server : ");	
			String tosend = identifier();
			JSONObject grades = post("http://challenge.code2040.org/api/status", tosend);

			System.out.println("Grades Received : " + grades.get("result"));	

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}