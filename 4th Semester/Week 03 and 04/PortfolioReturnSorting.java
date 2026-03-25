import java.util.*;

public class PortfolioReturnSorting {
    static class Asset {
        String name;
        int ret;
        int vol;
        Asset(String n, int r, int v) {
            name = n;
            ret = r;
            vol = v;
        }
        public String toString() {
            return name + ":" + ret;
        }
    }

    static void mergeSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(Asset[] arr, int l, int m, int r) {
        Asset[] L = Arrays.copyOfRange(arr, l, m + 1);
        Asset[] R = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length)
            arr[k++] = (L[i].ret <= R[j].ret) ? L[i++] : R[j++];
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    static void quickSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    static int partition(Asset[] arr, int l, int r) {
        Asset pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++)
            if (arr[j].ret > pivot.ret ||
                    (arr[j].ret == pivot.ret && arr[j].vol < pivot.vol)) {
                i++;
                Asset t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        Asset t = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        Asset[] arr = {
                new Asset("AAPL", 12, 5),
                new Asset("TSLA", 8, 7),
                new Asset("GOOG", 15, 4)
        };

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}