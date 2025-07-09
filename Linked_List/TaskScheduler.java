import java.time.*;

public class TaskScheduler {

    static class Task {
        int id, priority; String name; LocalDate due;
        Task next;
        Task(int id,String name,int priority,LocalDate due){
            this.id=id;this.name=name;this.priority=priority;this.due=due;
        }
    }

    static class CircularTaskList {
        private Task head = null;

        void addLast(Task t){
            if(head==null){head=t;t.next=t;return;}
            Task tail=head;while(tail.next!=head)tail=tail.next;
            tail.next=t;t.next=head;
        }
        void addFirst(Task t){
            addLast(t);head=t;
        }
        void remove(int id){
            if(head==null)return;
            Task cur=head,prev=null;
            do{
                if(cur.id==id){
                    if(prev!=null)prev.next=cur.next;
                    else { // removing head
                        Task tail=head;while(tail.next!=head)tail=tail.next;
                        if(tail==head){head=null;return;}
                        tail.next=head.next;head=head.next;
                    }
                    return;
                }
                prev=cur;cur=cur.next;
            }while(cur!=head);
        }
        void display(){
            if(head==null)return;
            Task t=head;
            do{
                System.out.println(t.id+" "+t.name+" P:"+t.priority+" Due:"+t.due);
                t=t.next;
            }while(t!=head);
        }
        Task searchByPriority(int p){
            if(head==null)return null;
            Task t=head; do{if(t.priority==p)return t; t=t.next;}while(t!=head);
            return null;
        }
    }

    public static void main(String[] args){
        CircularTaskList list=new CircularTaskList();
        list.addLast(new Task(1,"Design",1,LocalDate.now().plusDays(1)));
        list.addLast(new Task(2,"Code",2,LocalDate.now().plusDays(2)));
        list.display();
        list.remove(1);
        list.display();
        System.out.println("Find P2: "+list.searchByPriority(2).name);
    }
}
