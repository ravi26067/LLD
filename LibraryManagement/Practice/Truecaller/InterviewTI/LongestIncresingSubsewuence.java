public class LongestIncresingSubsewuence {

    // Space complexity : O(n)
    // Time complexity : O(n^2)
    public static int longestIncresingSubsewuence(int[] arr) {
        int n = arr.length;
        int lis[] = new int[n];

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        if (n == 0 || n == 1) {
            return n;
        } else {
            int res = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {

                    if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (res < lis[i]) {
                    res = lis[i];
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 10, 2, 1, 20 };
        System.out.println("Result: " + longestIncresingSubsewuence(arr));
        int arr2[] = { 3, 2 };
        System.out.println("Result: " + longestIncresingSubsewuence(arr2));
    }
}
