import java.util.HashMap;
import java.util.Map;

// Time complexxity: O(n)
// Space complexxity: O(k)
public class FirstNonRepeated {

    public static Character FirstNonRepeated(String s) {

        Character res = null;

        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (freq.get(c) == 1) {
                res = c;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "abacddce";
        System.out.println("Input : " + str + "\nResult: " + FirstNonRepeated(str));
        str = "acacddcb";
        System.out.println("Input : " + str + "\nResult: " + FirstNonRepeated(str));
        str = "abbbb";
        System.out.println("Input : " + str + "\nResult: " + FirstNonRepeated(str));
        str = "abcdef";
        System.out.println("Input : " + str + "\nResult: " + FirstNonRepeated(str));
        str = "abab";
        System.out.println("Input : " + str + "\nResult: " + FirstNonRepeated(str));
        str = "dcba";
        System.out.println("Input : " + str + "\nResult: " + FirstNonRepeated(str));

    }
}