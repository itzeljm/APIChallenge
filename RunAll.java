package challenge;

/** File to run all the stages of the challenge.
 *
 * @author Itzel Martinez
 *
 */

public class RunAll {

    /** Main method that runs the program taking in arguments ARGS. */
    public static void main(String[] args) throws Exception {
	challenge.BeginChallenge.main(args);
	challenge.ReverseString.main(args);
	challenge.Haystack.main(args);
	challenge.Prefix.main(args);
	challenge.DatingGame.main(args);

    }
}
