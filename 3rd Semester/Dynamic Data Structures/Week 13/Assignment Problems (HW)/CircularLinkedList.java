public class CircularLinkedList{
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    private Node tail;

    public void insertAtBeginning(int data){
        Node newNode=new Node(data);

        if(tail==null){
            tail=newNode;
            tail.next=tail;
            return;
        }

        newNode.next=tail.next;
        tail.next=newNode;
    }

    public void insertAtEnd(int data){
        Node newNode=new Node(data);

        if(tail==null){
            tail=newNode;
            tail.next=tail;
            return;
        }

        newNode.next=tail.next;
        tail.next=newNode;
        tail=newNode;
    }

    public void deleteAtBeginning(){
        if(tail==null){
            System.out.println("List is empty!");
            return;
        }

        Node head=tail.next;

        if(head==tail){
            tail=null;
            return;
        }

        tail.next=head.next;
    }

    public void deleteAtEnd(){
        if(tail==null){
            System.out.println("List is empty!");
            return;
        }

        Node head=tail.next;

        if(head==tail){
            tail=null;
            return;
        }

        Node temp=head;
        while(temp.next!=tail)
            temp=temp.next;

        temp.next=tail.next;
        tail=temp;
    }

    public void display(){
        if(tail==null){
            System.out.println("List is empty!");
            return;
        }

        Node head=tail.next;
        Node temp=head;

        System.out.print("Circular List = [");
        do{
            System.out.print(temp.data);
            temp=temp.next;
            if(temp!=head)
                System.out.print(" --> ");
        } while(temp!=head);

        System.out.println(" --> back to "+head.data+"]");
    }

    public static void main(String[] args){
        CircularLinkedList list=new CircularLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("After inserting 10, 20, 30:");
        list.display();

        System.out.println("\nAfter deleting first element:");
        list.deleteAtBeginning();
        list.display();

        System.out.println("\nAfter inserting 40 at end:");
        list.insertAtEnd(40);
        list.display();
    }
}
