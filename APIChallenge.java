/** File for the API Challenge.
	* @author Itzel Martinez */

package code2040;
//package org.json;

import java.net.*;
import java.io.*;

//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStreamReader;

//import java.net.HttpURLConnection;
//import java.net.URL;

import org.json.*;

public class APIChallenge {

		/** Method that returns a token from the webrequest when registering. */
		public static void Main(String[] args) throws IOException {

				JSONObject dictionary = new JSONObject();
				dictionary.put("Email", "j_itzel_m@berkeley.edu");
				dictionary.put("Github", "https://github.com/itzeljm/APIChallenge.git");

				String request = "http://challenge.code2040.org/api/register";
			
			

				HttpClient httpclient = new HttpClient();
				HttpPost httpost = new HttpPost(path);

				httpost.post(dictionary);
				ResponseHandler handler = new BasicResponseHandler();

				/**URL absoluteUrl  = new URL(request);
				URLConnection connection = absoluteUrl.openConnection();
			
				connection.getDoOutput(true);


				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write("string = ", "stringToReverse");
				out.close();
				//BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));


			} catch (MalformedURLException e) {
				System.print.outln("Null or unknown protocol was passed in.");
			} catch (IOException e) {
				System.print.outln("openConnection failed.")
			}
*/


		}




	/** URLConnection object stored to use for more general communications.  */
	//public static final HttpURLConnection;
	

		


	}



	
	
