import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiggestNumber {

    // Time complexity: O(n*log(n))
    // Space complexity: O(n)
    public static String biggestNumber(int arr[]) {
        String res = new String();
        int n = arr.length;

        List<String> lst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lst.add(Integer.toString(arr[i]));
        }

        Collections.sort(lst, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x.concat(y);
                String yx = y.concat(x);

                int comp = xy.compareTo(yx);
                return comp == 0 ? 0 : (comp > 0 ? -1 : 1);
            }
        });

        for (int i = 0; i < n; i++) {
            res = res.concat(lst.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 54, 546, 548, 60 };
        System.out.println("Result: " + biggestNumber(arr));
        int arr2[] = { 1, 34, 3, 98, 9, 76, 45, 4 };
        System.out.println("Result: " + biggestNumber(arr2));
    }
}
