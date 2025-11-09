public class DoublyLinkedList2{
    class Node{
        int data;
        Node prev, next;

        Node(int data){
            this.data=data;
            this.prev=null;
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
        newNode.prev=temp;
    }

    public void bubbleSort(){
        if(head==null){
            System.out.println("List is empty!");
            return;
        }

        boolean swapped;
        Node current;
        Node last=null;

        do{
            swapped=false;
            current=head;

            while(current.next!=last){
                if(current.data>current.next.data){
                    int temp=current.data;
                    current.data=current.next.data;
                    current.next.data=temp;
                    swapped=true;
                }
                current=current.next;
            }
            last=current;
        } while(swapped);
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
                System.out.print(" <==> ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        DoublyLinkedList2 list=new DoublyLinkedList2();

        list.append(40);
        list.append(10);
        list.append(30);
        list.append(20);

        System.out.print("Before Sorting: ");
        list.display();

        list.bubbleSort();

        System.out.print("After Sorting:  ");
        list.display();
    }
}
