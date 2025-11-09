import java.util.Scanner;

public class SinglyLinkedList{
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    private Node head;

    public void insertAtPosition(int data, int position){
        Node newNode=new Node(data);

        if(position<=0){
            System.out.println("Invalid position! Position should be >= 1");
            return;
        }

        if(position==1){
            newNode.next=head;
            head=newNode;
            return;
        }

        Node temp=head;
        int count=1;

        while(temp!=null && count<position-1){
            temp=temp.next;
            count++;
        }

        if(temp==null){
            System.out.println("Position out of range! Node added at end");
            append(data);
            return;
        }

        newNode.next=temp.next;
        temp.next=newNode;
    }

    public void append(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=newNode;
    }

    public void display(){
        if(head==null){
            System.out.println("List is empty!");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null)
                System.out.print(" --> ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        SinglyLinkedList list=new SinglyLinkedList();
        Scanner input=new Scanner(System.in);

        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        System.out.print("Initial List: ");
        list.display();

        System.out.print("\nEnter element to insert: ");
        int data=input.nextInt();
        System.out.print("Enter position: ");
        int pos=input.nextInt();

        list.insertAtPosition(data,pos);

        System.out.print("\nUpdated List: ");
        list.display();
        input.close();
    }
}
