public class DoublyLinkedList{
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

    public void deleteAll(int value){
        Node temp=head;
        boolean deleted=false;

        while(temp!=null){
            if(temp.data==value){
                deleted=true;

                if(temp==head){
                    head=temp.next;
                    if(head!=null)
                        head.prev=null;
                }
                else if(temp.next==null){
                    temp.prev.next=null;
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
            }
            temp=temp.next;
        }

        if(deleted)
            System.out.println("All occurrences of "+value+" deleted successfully");
        else
            System.out.println("Value "+value+" not found in the list");
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
        DoublyLinkedList list=new DoublyLinkedList();

        list.append(10);
        list.append(20);
        list.append(30);
        list.append(20);
        list.append(40);

        System.out.print("Initial List: ");
        list.display();

        int valueToDelete=20;
        System.out.println("\nDeleting all occurrences of "+valueToDelete+"......");
        list.deleteAll(valueToDelete);

        System.out.print("\nUpdated List: ");
        list.display();
    }
}
