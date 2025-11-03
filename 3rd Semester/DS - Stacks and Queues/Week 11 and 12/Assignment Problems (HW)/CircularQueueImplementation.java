import java.util.Scanner;

class CircularQueue{
    private int[] queue;
    private int front, rear, size, count;

    public CircularQueue(int size){
        this.size=size;
        queue=new int[size];
        front=0;
        rear=-1;
        count=0;
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue Overflow! Cannot insert "+value);
            return;
        }
        rear=(rear+1)%size;
        queue[rear]=value;
        count++;
        System.out.println(value+" inserted into the queue");
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow! Cannot delete");
            return;
        }
        System.out.println(queue[front]+" deleted from the queue");
        front=(front+1)%size;
        count--;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for(int i=0; i<count; i++){
            System.out.print(queue[(front+i)%size]+" ");
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return count==0;
    }

    public boolean isFull(){
        return count==size;
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to peek");
        }
        else{
            System.out.println("Front element: "+queue[front]);
        }
    }
}

public class CircularQueueImplementation{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter capacity of Circular Queue: ");
        int n=input.nextInt();

        CircularQueue cq=new CircularQueue(n);
        int choice, value;

        while(true){
            System.out.println("\n------ Circular Queue Menu ------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check if Empty");
            System.out.println("6. Check if Full");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice=input.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter value to insert: ");
                    value=input.nextInt();
                    cq.enqueue(value);
                    break;

                case 2:
                    cq.dequeue();
                    break;

                case 3:
                    cq.peek();
                    break;

                case 4:
                    cq.display();
                    break;

                case 5:
                    System.out.println(cq.isEmpty() ? "Queue is empty." : "Queue is not empty");
                    break;

                case 6:
                    System.out.println(cq.isFull() ? "Queue is full." : "Queue is not full");
                    break;

                case 7:
                    System.out.println("Exiting......");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again");
            }
        }
    }
}
