import java.util.Scanner;

public class UndoRedoEditor {

    static class State {
        String text;
        State prev,next;
        State(String t){text=t;}
    }
    static class History {
        private State current;
        private int size =0;
        void add(String txt){
            State s=new State(txt);
            if(current!=null){ current.next=s; s.prev=current; /* cut redo chain */ }
            current=s; size++;
            // limit 10
            int cnt=1; State t=current;
            while(t.prev!=null){ cnt++; t=t.prev; if(cnt>10){ t.prev=null; size--; break; } }
        }
        void undo(){ if(current!=null && current.prev!=null) current=current.prev; }
        void redo(){ if(current!=null && current.next!=null) current=current.next; }
        String get(){ return current==null?"":current.text; }
    }

    public static void main(String[] a){
        History h=new History();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("1 Type  2 Undo  3 Redo  4 Show  0 Exit : ");
            switch(sc.nextInt()){
                case 1 -> { System.out.print("text: "); h.add(sc.next()); }
                case 2 -> h.undo();
                case 3 -> h.redo();
                case 4 -> System.out.println("Current: "+h.get());
                case 0 -> { sc.close(); return; }
            }
        }
    }
}
