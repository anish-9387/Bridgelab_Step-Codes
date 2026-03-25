import java.util.*;

public class TransactionFeeSorting{
    static class Transaction {
        String id;
        double fee;
        String ts;
        Transaction(String id, double fee, String ts) {
            this.id = id;
            this.fee = fee;
            this.ts = ts;
        }
        public String toString() {
            return id + ":" + fee;
        }
    }

    static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction t = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, t);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (list.get(j).fee > key.fee ||
                    (list.get(j).fee == key.fee && list.get(j).ts.compareTo(key.ts) > 0))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSort(list);
        System.out.println(list);

        insertionSort(list);
        System.out.println(list);

        for (Transaction t : list)
            if (t.fee > 50) System.out.println("Outlier: " + t.id);
    }
}