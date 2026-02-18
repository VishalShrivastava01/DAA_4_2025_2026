import java.util.*;

public class PaintersPartition {

    public static boolean canPaint(int[] arr, int k, long maxTime) {
        int painters = 1;
        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];

            if (total > maxTime) {
                painters++;
                total = arr[i];
            }

            if (painters > k) return false;
        }
        return true;
    }

    public static long minTime(int[] arr, int k) {

        long low = 0;
        long high = 0;

        for (int num : arr) {
            low = Math.max(low, num);   
            high += num;               
        }

        long ans = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (canPaint(arr, k, mid)) {
                ans = mid;
                high = mid - 1;   
            } else {
                low = mid + 1;    
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 15};
        int k = 3;

        System.out.println(minTime(arr, k));
    }

 
    
}
