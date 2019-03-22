import java.util.*;

/**
 * CommonSub
 */
public class CommonSub {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String longest = "";
            // Iterate through both strings L to R
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    int k = 0;
                    String current = "";
                    // Iterate through the strings and append all equal chars to the current common substring
                    while (s1.charAt(i + k) == s2.charAt(j + k)) {
                        current += s1.charAt(i + k);
                        k++;
                        // Index out of range, break
                        if (i + k >= s1.length() || j + k >= s2.length()) {
                            break;
                        }
                    }
                    // If the current substring is longer, longest = current.
                    if (current.length() > longest.length()) {
                        longest = current;
                    }
                }
            }

            System.out.println(longest);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}