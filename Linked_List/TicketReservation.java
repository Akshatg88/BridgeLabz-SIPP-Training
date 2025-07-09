import java.time.LocalTime;

public class TicketReservation {

    static class Ticket {
        int id; String customer, movie, seat; LocalTime time;
        Ticket next;
        Ticket(int id,String c,String m,String s){this.id=id;customer=c;movie=m;seat=s;time=LocalTime.now();}
    }

    static class ReservationList {
        private Ticket head;
        void add(Ticket t){
            if(head==null){head=t;t.next=t;return;}
            Ticket tail=head;while(tail.next!=head)tail=tail.next;
            tail.next=t;t.next=head;
        }
        void remove(int id){
            if(head==null)return;
            Ticket cur=head,prev=null;
            do{
                if(cur.id==id){
                    if(prev!=null)prev.next=cur.next;
                    else { // deleting head
                        Ticket tail=head;while(tail.next!=head)tail=tail.next;
                        if(tail==head){head=null;return;}
                        tail.next=head.next;head=head.next;
                    } return;
                }
                prev=cur;cur=cur.next;
            }while(cur!=head);
        }
        void display(){
            if(head==null)return;
            Ticket t=head;
            do{
                System.out.println(t.id+" "+t.customer+" "+t.movie+" Seat:"+t.seat+" "+t.time);
                t=t.next;
            }while(t!=head);
        }
        int count(){
            int c=0; if(head==null)return 0;
            Ticket t=head; do{c++; t=t.next;}while(t!=head); return c;
        }
        void searchByCustomer(String n){
            if(head==null)return;
            Ticket t=head; do{
                if(t.customer.equalsIgnoreCase(n))System.out.println("Found "+t.id+" "+t.movie);
                t=t.next;
            }while(t!=head);
        }
    }
    public static void main(String[] a){
        ReservationList rl=new ReservationList();
        rl.add(new Ticket(1,"Ravi","Dune","A1"));
        rl.add(new Ticket(2,"Rita","Dune","A2"));
        rl.display();
        System.out.println("Total: "+rl.count());
        rl.remove(1); rl.display();
    }
}
