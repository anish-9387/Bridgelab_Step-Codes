import java.util.*;

public class RiskThresholdBinaryLookup {

    static int linear(int[] arr, int t) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == t) return i;
        return -1;
    }

    static int floor(int[] arr, int t) {
        int res = -1;
        for (int x : arr) if (x <= t) res = x;
        return res;
    }

    static int ceil(int[] arr, int t) {
        for (int x : arr) if (x >= t) return x;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};

        System.out.println(linear(arr, 30));
        System.out.println(floor(arr, 30));
        System.out.println(ceil(arr, 30));
    }
}