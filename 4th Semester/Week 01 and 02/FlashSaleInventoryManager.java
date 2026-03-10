import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FlashSaleInventoryManager{
    private Map<String, Integer> inventory;

    private Map<String, Queue<Integer>> waitingList;

    public FlashSaleInventoryManager(){
        inventory=new ConcurrentHashMap<>();
        waitingList=new ConcurrentHashMap<>();
    }

    public void addProduct(String productId, int stock){
        inventory.put(productId,stock);
        waitingList.put(productId, new LinkedList<>());
    }

    public int checkStock(String productId){
        return inventory.getOrDefault(productId,0);
    }

    public synchronized String purchaseItem(String productId, int userId){
        int stock=inventory.getOrDefault(productId, 0);

        if(stock>0){
            stock--;
            inventory.put(productId,stock);

            return "Success: User "+userId+" purchased "+productId+". Remaining stock: "+stock;
        }

        Queue<Integer> queue=waitingList.get(productId);
        queue.add(userId);

        return "Stock unavailable. User "+userId+" added to waiting list. Position #"+queue.size();
    }

    public Queue<Integer> getWaitingList(String productId){
        return waitingList.get(productId);
    }

    public synchronized void restock(String productId, int quantity){
        int stock=inventory.getOrDefault(productId, 0);
        stock+=quantity;

        Queue<Integer> queue=waitingList.get(productId);

        while(stock>0 && !queue.isEmpty()){
            int user=queue.poll();
            stock--;
            System.out.println("Waiting user "+user+" successfully purchased "+productId);
        }

        inventory.put(productId, stock);
    }

    public static void main(String[] args){
        FlashSaleInventoryManager manager=new FlashSaleInventoryManager();

        manager.addProduct("IPHONE15_256GB",3);

        System.out.println("Stock: " +manager.checkStock("IPHONE15_256GB"));

        System.out.println(manager.purchaseItem("IPHONE15_256GB", 12345));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 67890));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 22222));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 99999));

        System.out.println("Waiting List: "+manager.getWaitingList("IPHONE15_256GB"));

        System.out.println("\nRestocking 2 units......\n");

        manager.restock("IPHONE15_256GB", 2);

        System.out.println("Remaining Stock: " +manager.checkStock("IPHONE15_256GB"));
    }
}