import java.util.ArrayList;
import java.util.Scanner;

class StackUsingList{
    private ArrayList<Integer> stack;

    public StackUsingList(){
        stack=new ArrayList<>();
    }

    public void push(int value){
        stack.add(value);
        System.out.println(value+" pushed to stack");
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        int removed=stack.remove(stack.size()-1);
        System.out.println(removed+" popped from stack");
        return removed;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty. Nothing to peek");
            return -1;
        }
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack elements: "+stack);
        }
    }
}

public class ImplementStackUsingList{
    public static void main(String[] args){
        StackUsingList stack=new StackUsingList();
        Scanner input=new Scanner(System.in);
        int choice, value;

        while(true){
            System.out.println("\n------ Stack Menu ------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Display Stack");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice=input.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter value to push: ");
                    value=input.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    System.out.println("Top element: "+stack.peek());
                    break;

                case 4:
                    System.out.println(stack.isEmpty() ? "Stack is empty" : "Stack is not empty");
                    break;

                case 5:
                    stack.display();
                    break;

                case 6:
                    System.out.println("Exiting......");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again");
            }
        }
    }
}
