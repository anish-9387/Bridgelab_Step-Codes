import java.util.*;

public class LookupTransactionLogs {

    static int linearFirst(String[] arr, String t) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(t)) return i;
        return -1;
    }

    static int linearLast(String[] arr, String t) {
        for (int i = arr.length - 1; i >= 0; i--)
            if (arr[i].equals(t)) return i;
        return -1;
    }

    static int binarySearch(String[] arr, String t) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m].equals(t)) return m;
            if (arr[m].compareTo(t) < 0) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    static int count(String[] arr, String t) {
        int c = 0;
        for (String s : arr) if (s.equals(t)) c++;
        return c;
    }

    public static void main(String[] args) {
        String[] arr = {"accB", "accA", "accB", "accC"};
        Arrays.sort(arr);

        System.out.println(linearFirst(arr, "accB"));
        System.out.println(linearLast(arr, "accB"));
        System.out.println(binarySearch(arr, "accB"));
        System.out.println(count(arr, "accB"));
    }
}