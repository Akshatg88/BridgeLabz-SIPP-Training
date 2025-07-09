import java.util.LinkedList;
import java.util.Queue;

public class RoundRobinScheduler {

    static class Process {
        int id, burst, remaining, waiting = 0, turnaround = 0;
        Process next;
        Process(int id,int bt){this.id=id;burst=remaining=bt;}
    }

    static class RR {
        private Process head;
        void add(Process p){ if(head==null){head=p;p.next=p;return;}
            Process tail=head;while(tail.next!=head)tail=tail.next;
            tail.next=p;p.next=head;
        }
        void run(int quantum){
            Queue<Process> finished=new LinkedList<>();
            Process cur=head,prev=null;
            int time=0;
            while(head!=null){
                cur.remaining-=quantum;
                time+=quantum;
                if(cur.remaining<=0){
                    cur.turnaround=time;
                    finished.add(cur);
                    // remove
                    if(cur==head){
                        // find tail
                        Process tail=head;while(tail.next!=head)tail=tail.next;
                        if(tail==head){head=null;}
                        else { tail.next=head.next; head=head.next; }
                        cur=tail.next;
                    } else { prev.next=cur.next; cur=prev.next; }
                    continue;
                }
                // increase waiting for others
                for(Process t=head;t!=null; t=(t.next==head)?null:t.next)
                    if(t!=cur) t.waiting+=quantum;
                prev=cur;cur=cur.next;
            }
            double wt=0,tt=0; int n=finished.size();
            for(Process p:finished){ wt+=p.waiting; tt+=p.turnaround; }
            System.out.printf("Avg Waiting: %.2f  Avg Turnaround: %.2f%n",wt/n,tt/n);
        }
    }
    public static void main(String[] args){
        RR rr=new RR();
        rr.add(new Process(1,10));
        rr.add(new Process(2,5));
        rr.add(new Process(3,7));
        rr.run(2);
    }
}
