import java.util.*;

/**
 * Dice
 */
public class Dice {
    
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

    static void printArray(ArrayList<Integer[]> list) {
        for (Integer[] array : list) {
            System.out.print("(");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) System.out.print(",");
            }
            System.out.println(")");
        }    
    }
    
    public static void main(String[] args) {
        ArrayList<Integer[]> allCombos = new ArrayList<Integer[]>();
        ArrayList<Integer[]> sumCombos = new ArrayList<Integer[]>();
        final int DICE_MAX = 6;

        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Number of Dice: ");
            int dice = in.nextInt();
            System.out.print("Sum: ");
            int sum = in.nextInt();

            // Generate all dice combonations
            for (int i = 0; i < Math.pow(dice, DICE_MAX); i++) {
                // Make the base K number for the current i (e.g. if k = 2, it's binary)
                // Used to figure out which char from the set is to be used 
                String baseK = convertBase(i, DICE_MAX + 1);

                // Can't roll a 0, must roll all dice
                Integer[] ints = new Integer[dice];
                if (!baseK.contains("0") && baseK.length() == dice) {
                    for (int j = 0; j < dice; j++) {
                        ints[j] = Integer.parseInt("" + baseK.charAt(j));
                    }

                    allCombos.add(ints);
                }
            } 

            // If the sum of the combo is the right amount, add to sumCombos
            for (Integer[] array : allCombos) {
                int currentSum = 0;
                for (int i = 0; i < array.length; i++) {
                    currentSum += array[i];
                }
                if (sum == currentSum) {
                    sumCombos.add(array);
                }
            }    

            // Print
            System.out.println("Number of combos: " + sumCombos.size());
            printArray(sumCombos);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}