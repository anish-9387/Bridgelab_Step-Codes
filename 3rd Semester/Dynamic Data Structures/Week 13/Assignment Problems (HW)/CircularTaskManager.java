public class CircularTaskManager{
    class TaskNode{
        String taskName;
        int time;
        TaskNode next;

        TaskNode(String taskName, int time){
            this.taskName=taskName;
            this.time=time;
            this.next=null;
        }
    }

    private TaskNode tail;

    public void addTask(String taskName, int time){
        TaskNode newNode=new TaskNode(taskName,time);

        if(tail==null){
            tail=newNode;
            tail.next=tail;
            return;
        }

        newNode.next=tail.next;
        tail.next=newNode;
        tail=newNode;
    }

    public void executeTasks(){
        if(tail==null){
            System.out.println("No tasks to execute!");
            return;
        }

        System.out.print("Execution order --> ");
        TaskNode current=tail.next;

        while(tail!=null){
            System.out.print(current.taskName);

            current.time-=1;

            if(current.time==0){
                System.out.print(" (Completed)");

                if(current==tail && current.next==tail){
                    tail=null;
                    System.out.println("\nAll tasks completed!");
                    return;
                }

                removeTask(current);
                current=tail.next;
            }
            else{
                current=current.next;
            }

            if(tail!=null)
                System.out.print(" --> ");
        }
    }

    private void removeTask(TaskNode target){
        if(tail==null || target==null)  return;

        TaskNode prev=tail;
        TaskNode curr=tail.next;

        do{
            if(curr==target){
                if(curr==tail){
                    if(tail.next==tail){
                        tail = null;
                    }
                    else{
                        prev.next=curr.next;
                        tail=prev;
                    }
                }
                else{
                    prev.next=curr.next;
                }
                return;
            }
            prev=curr;
            curr=curr.next;
        } while(curr!=tail.next);
    }

    public void displayTasks(){
        if(tail==null){
            System.out.println("No tasks in the list");
            return;
        }

        TaskNode temp=tail.next;
        System.out.print("Tasks = [");
        do{
            System.out.print(temp.taskName+"("+temp.time+"s)");
            temp=temp.next;
            if(temp!=tail.next)
                System.out.print(" <==> ");
        } while(temp!=tail.next);
        System.out.println("]");
    }

    public static void main(String[] args){
        CircularTaskManager manager=new CircularTaskManager();

        manager.addTask("T1",3);
        manager.addTask("T2",2);
        manager.addTask("T3",4);

        System.out.println("Initial Task List:");
        manager.displayTasks();

        System.out.println("\nExecuting tasks in round-robin order......");
        manager.executeTasks();
    }
}
