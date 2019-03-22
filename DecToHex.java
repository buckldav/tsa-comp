import java.util.Scanner;

/**
 * DecToHex
 */
public class DecToHex {

    public static void main(String[] args) {
        // Input
        Scanner in = new Scanner(System.in);
        try {            
            String hex = in.nextLine();
            hex = hex.split("0x")[1];
            int dec = 0;
            int pow16 = 0;
            // Convert
            for (int i = hex.length() - 1; i >= 0; i--) {
                String c = ("" + hex.charAt(i)).toLowerCase();
                int j = 0; 
                try {
                    j = Integer.parseInt(c);
                } catch (Exception e) {
                    j = (int)hex.charAt(i) - 55;
                    if (j < 10 || j > 15) {
                        throw new NumberFormatException("Invalid hex, received char " + hex.charAt(i));
                    }
                }
                dec += j * Math.pow(16, pow16);
                pow16++;
            }

            // Print
            System.out.println(dec);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}