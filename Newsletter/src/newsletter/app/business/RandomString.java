package newsletter.app.business;

import java.util.*;

public class RandomString extends Random {

	public RandomString( long seed ) { super( seed ); }

	public String nextString( int maxlen ) {
		char c[] = new char[maxlen];
		for ( int i = 0; i < maxlen; i++ )
			c[i] = (char) ( 32 + nextInt( 128 - 32 ));
		return new String( c );
	}	
}
