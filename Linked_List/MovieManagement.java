package Linked_List;
import java.util.Scanner;

public class MovieManagement {

    static class Movie {
        String title, director;
        int year;
        double rating;
        Movie prev, next;
        Movie(String t, String d, int y, double r) {
            title = t; director = d; year = y; rating = r;
        }
    }

    static class MovieDLL {
        private Movie head, tail;

        void addFirst(Movie m) {              // similar addLast / addAt
            if (head == null) { head = tail = m; return; }
            m.next = head; head.prev = m; head = m;
        }
        void addLast(Movie m) {
            if (tail == null) { head = tail = m; return; }
            tail.next = m; m.prev = tail; tail = m;
        }
        void addAt(int pos, Movie m) {
            if (pos <= 0 || head == null) { addFirst(m); return; }
            Movie t = head; for (int i=0;i<pos-1 && t!=null;i++) t = t.next;
            if (t == null || t.next == null) { addLast(m); return; }
            m.next = t.next; m.prev = t; t.next.prev = m; t.next = m;
        }

        void removeByTitle(String title) {
            for (Movie t=head; t!=null; t=t.next)
                if (t.title.equalsIgnoreCase(title)) {
                    if (t==head) head = t.next; else t.prev.next = t.next;
                    if (t==tail) tail = t.prev; else t.next.prev = t.prev;
                    return;
                }
        }
        void updateRating(String title,double r){
            for(Movie t=head;t!=null;t=t.next)
                if(t.title.equalsIgnoreCase(title)){t.rating=r;return;}
        }
        void searchByDirector(String dir){
            for(Movie t=head;t!=null;t=t.next)
                if(t.director.equalsIgnoreCase(dir))
                    System.out.println(t.title+" ("+t.year+") Rating:"+t.rating);
        }
        void searchByRating(double min){
            for(Movie t=head;t!=null;t=t.next)
                if(t.rating>=min)
                    System.out.println(t.title+" Dir:"+t.director+" Rating:"+t.rating);
        }
        void displayForward(){
            for(Movie t=head;t!=null;t=t.next)
                System.out.println(t.title+" "+t.year+" "+t.rating);
        }
        void displayReverse(){
            for(Movie t=tail;t!=null;t=t.prev)
                System.out.println(t.title+" "+t.year+" "+t.rating);
        }
    }

    public static void main(String[] a){
        MovieDLL dll=new MovieDLL();
        Scanner sc=new Scanner(System.in);
        dll.addLast(new Movie("Inception","Nolan",2010,8.8));
        dll.addLast(new Movie("Interstellar","Nolan",2014,8.6));

        // very small demo menu
        dll.displayForward();
        dll.updateRating("Inception",9.0);
        dll.searchByDirector("Nolan");
        sc.close();
    }
}
