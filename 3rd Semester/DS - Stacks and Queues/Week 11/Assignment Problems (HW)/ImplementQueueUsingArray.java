import java.util.Scanner;

class QueueUsingArray{
    private int[] queue;
    private int front, rear, size, capacity;

    public QueueUsingArray(int capacity){
        this.capacity=capacity;
        queue=new int[capacity];
        front=0;
        rear=-1;
        size=0;
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue Overflow! Cannot enqueue "+value);
            return;
        }
        rear++;
        queue[rear]=value;
        size++;
        System.out.println(value+" enqueued to the queue");
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow! Cannot dequeue");
            return;
        }
        System.out.println(queue[front]+" dequeued from the queue");
        front++;
        size--;
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to peek");
        }
        else{
            System.out.println("Front element: "+queue[front]);
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return rear==capacity-1;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for(int i=front; i<=rear; i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }
}

public class ImplementQueueUsingArray{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter capacity of the queue: ");
        int capacity=input.nextInt();

        QueueUsingArray queue=new QueueUsingArray(capacity);
        int choice, value;

        while(true){
            System.out.println("\n------ Queue Menu ------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Display Queue");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice=input.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    value=input.nextInt();
                    queue.enqueue(value);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.peek();
                    break;

                case 4:
                    System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is not empty");
                    break;

                case 5:
                    System.out.println(queue.isFull() ? "Queue is full" : "Queue is not full");
                    break;

                case 6:
                    queue.display();
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
