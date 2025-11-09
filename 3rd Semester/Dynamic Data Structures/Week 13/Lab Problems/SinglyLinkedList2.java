public class SinglyLinkedList2{
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    private Node head;

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

    public void createLoop(int position){
        if(head==null)  return;

        Node loopNode=null;
        Node temp=head;
        int count=1;

        while(temp.next!=null){
            if(count==position)
                loopNode=temp;
            temp=temp.next;
            count++;
        }

        if(loopNode!=null)
            temp.next=loopNode;
    }

    public boolean detectAndRemoveLoop(){
        Node slow=head, fast=head;

        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                removeLoop(slow);
                return true;
            }
        }
        return false;
    }

    private void removeLoop(Node loopNode){
        Node ptr1=head;
        Node ptr2=loopNode;

        while(ptr1!=ptr2){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }

        Node temp=ptr2;
        while(temp.next!=ptr1)
            temp=temp.next;

        temp.next=null;
        System.out.println("Loop detected and removed!");
    }

    public void display(){
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
        SinglyLinkedList2 list=new SinglyLinkedList2();

        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        list.createLoop(3);

        System.out.println("Detecting loop......");
        boolean loopFound=list.detectAndRemoveLoop();

        if(loopFound){
            System.out.println("List after loop removal:");
            list.display();
        }
        else{
            System.out.println("No loop found in the list");
        }
    }
}
