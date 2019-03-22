import java.util.*;

/**
 * Possible
 */
public class Possible {

    // Stole from the interwebs (I cheated)
    // http://www.edwardbeckett.com/converting-numbers-different-bases-java/
    static String convertBase( int number, int radix ) {

		List<Integer> remainder = new ArrayList<>();

		int count = 0;
		String result = "";
		while( number != 0 ) {
			remainder.add( count, number % radix != 0 ? number % radix : 0 );
			number /= radix;
			try {
				result += remainder.get( count );
			} catch( NumberFormatException e ) {
				e.printStackTrace();
			}
		}
		return new String( new StringBuffer( result ).reverse().toString() );

	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Set: ");
            String set = in.nextLine();
            System.out.print("K: ");
            int k = Integer.parseInt(in.nextLine());

            // Iterate for (set.length ^ k) times (e.g. for set = "ab", k = 3; 2^3)
            for (int i = 0; i < Math.pow(set.length(), k); i++) {
                // Make the base K number for the current i (e.g. if k = 2, it's binary)
                // Used to figure out which char from the set is to be used 
                String baseK = convertBase(i, set.length());
                int baseKlength = baseK.length();

                // Append zeros to the front of the string if needed                
                for (int j = k; j > baseKlength; j--) {
                    baseK = "0" + baseK;
                }   
                
                // Make a string of length k that contains the chars from the set
                // indicated by the base K number
                String out = "";
                for (int j = 0; j < k; j++) {
                    out += set.charAt(Integer.parseInt("" + baseK.charAt(j)));
                }
                System.out.println(out);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}