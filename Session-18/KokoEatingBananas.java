import java.util.*;

public class KokoEatingBananas {

    public static boolean canEat(int[] piles, int h, int speed) {
        long hours = 0;

        for (int i = 0; i < piles.length; i++) {
            hours += (piles[i] + speed - 1) / speed;  
            if (hours > h) return false;
        }

        return true;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEat(piles, h, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}
