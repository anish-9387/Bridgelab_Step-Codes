import java.util.*;

class Transaction{
    int id;
    int amount;
    String merchant;
    String account;
    long time;

    public Transaction(int id, int amount, String merchant, String account, long time){
        this.id=id;
        this.amount=amount;
        this.merchant=merchant;
        this.account=account;
        this.time=time;
    }
}

public class TransactionAnalyzer{
    private List<Transaction> transactions;

    public TransactionAnalyzer(List<Transaction> transactions){
        this.transactions=transactions;
    }

    public List<int[]> findTwoSum(int target){
        Map<Integer, Transaction> map=new HashMap<>();
        List<int[]> result=new ArrayList<>();

        for(Transaction t : transactions){
            int complement=target-t.amount;

            if(map.containsKey(complement)){
                result.add(new int[]{map.get(complement).id, t.id});
            }

            map.put(t.amount,t);
        }

        return result;
    }

    public List<int[]> findTwoSumWithTimeWindow(int target, long windowMillis){
        Map<Integer, Transaction> map=new HashMap<>();
        List<int[]> result=new ArrayList<>();

        for(Transaction t : transactions){
            int complement=target-t.amount;

            if(map.containsKey(complement)){
                Transaction prev=map.get(complement);

                if(Math.abs(t.time-prev.time)<=windowMillis){
                    result.add(new int[]{prev.id,t.id});
                }
            }
            map.put(t.amount, t);
        }
        return result;
    }

    public List<String> detectDuplicates(){
        Map<String, Set<String>> map=new HashMap<>();
        List<String> duplicates=new ArrayList<>();

        for(Transaction t : transactions){
            String key=t.amount+"_"+t.merchant;

            map.putIfAbsent(key,new HashSet<>());
            map.get(key).add(t.account);

            if(map.get(key).size()>1){
                duplicates.add("Duplicate: amount="+t.amount+", merchant="+t.merchant+", accounts="+map.get(key));
            }
        }
        return duplicates;
    }

    public List<List<Integer>> findKSum(int k, int target){
        List<List<Integer>> result=new ArrayList<>();
        kSumHelper(0,k,target,new ArrayList<>(),result);
        return result;
    }

    private void kSumHelper(int start, int k, int target, List<Integer> current, List<List<Integer>> result){
        if(k==0 && target==0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(k==0 || target<0) return;

        for(int i=start; i<transactions.size(); i++){
            Transaction t=transactions.get(i);

            current.add(t.id);

            kSumHelper(i+1, k-1, target-t.amount, current, result);

            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args){
        List<Transaction> transactions=new ArrayList<>();

        transactions.add(new Transaction(1, 500, "StoreA", "acc1", 1000));
        transactions.add(new Transaction(2, 300, "StoreB", "acc2", 2000));
        transactions.add(new Transaction(3, 200, "StoreC", "acc3", 2500));
        transactions.add(new Transaction(4, 500, "StoreA", "acc4", 3000));

        TransactionAnalyzer analyzer=new TransactionAnalyzer(transactions);

        System.out.println("Two-Sum target 500:");
        for(int[] pair : analyzer.findTwoSum(500)){
            System.out.println(Arrays.toString(pair));
        }

        System.out.println("\nTwo-Sum within 1 hour:");
        for(int[] pair : analyzer.findTwoSumWithTimeWindow(500,3600000)){
            System.out.println(Arrays.toString(pair));
        }

        System.out.println("\nDuplicate Transactions:");
        for(String d : analyzer.detectDuplicates()){
            System.out.println(d);
        }

        System.out.println("\nK-Sum (k=3, target=1000):");
        for(List<Integer> list : analyzer.findKSum(3, 1000)){
            System.out.println(list);
        }
    }
}