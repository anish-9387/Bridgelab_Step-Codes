import java.util.*;

public class TradeVolumeAnalysis {
    static class Trade {
        String id;
        int volume;
        Trade(String id, int v) {
            this.id = id;
            this.volume = v;
        }
        public String toString() {
            return id + ":" + volume;
        }
    }

    static void mergeSort(Trade[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(Trade[] arr, int l, int m, int r) {
        Trade[] L = Arrays.copyOfRange(arr, l, m + 1);
        Trade[] R = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length)
            arr[k++] = (L[i].volume <= R[j].volume) ? L[i++] : R[j++];
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    static void quickSort(Trade[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    static int partition(Trade[] arr, int l, int r) {
        int pivot = arr[r].volume;
        int i = l - 1;
        for (int j = l; j < r; j++)
            if (arr[j].volume >= pivot) {
                i++;
                Trade t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        Trade t = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        Trade[] arr = {
                new Trade("t3", 500),
                new Trade("t1", 100),
                new Trade("t2", 300)
        };

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int sum = 0;
        for (Trade t : arr) sum += t.volume;
        System.out.println(sum);
    }
}