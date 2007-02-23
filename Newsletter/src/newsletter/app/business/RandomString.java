package newsletter.app.business;

import java.util.*;

/**
 * generates a new ranodom string. This is used for generating an activationCode
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
@SuppressWarnings("serial")
public class RandomString extends Random {

	/**
	 * Constructor
	 * @param seed
	 */
	public RandomString( long seed ) { 
		super( seed );
	}

	
	/**
	 * generates a random string with length maxlen
	 * @param maxlen
	 * @return
	 */
	public String nextString( int maxlen ) {
		char c[] = new char[maxlen];
		for ( int i = 0; i < maxlen; i++ )
			c[i] = (char) ( 32 + nextInt( 128 - 32 ));
		return new String( c );
	}	
}
