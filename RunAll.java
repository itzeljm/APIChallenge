package challenge;

/** File to run all the stages of the challenge.
*
* @author Itzel Martinez 
*
*/

public class RunAll {
	
	/** Main method that runs the program taking in arguments ARGS. */
	public static void main(String[] args) throws Exception {
		System.out.println("Connecting to the Registration Endpoint.");
		System.out.println("========================================");
		challenge.BeginChallenge.main(args);
		System.out.println("Running the first stage of the Challenge : ReverseString.");		
		System.out.println("=========================================================");
		challenge.ReverseString.main(args);
		System.out.println("Running the second stage of the Challenge : Haystack.");
		System.out.println("=====================================================");
		challenge.Haystack.main(args);
		System.out.println("Running the third stage of the Challenge : Prefix.");	
		System.out.println("==================================================");
		challenge.Prefix.main(args);
		System.out.println("Running the fourth and last stage of the Challenge : DatingGame.");		
		System.out.println("================================================================");
		challenge.DatingGame.main(args);

		}
}

