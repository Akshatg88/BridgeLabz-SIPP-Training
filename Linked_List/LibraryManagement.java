package Linked_List;
public class LibraryManagement {

    static class Book {
        String title, author, genre;
        int id;
        boolean available;
        Book prev,next;
        Book(String t,String a,String g,int id,boolean av){
            title=t;author=a;genre=g;this.id=id;available=av;
        }
    }
    static class Library {
        private Book head,tail;
        void addLast(Book b){ if(tail==null){head=tail=b;} else{tail.next=b;b.prev=tail;tail=b;} }
        void addFirst(Book b){ if(head==null){head=tail=b;} else{b.next=head;head.prev=b;head=b;} }
        void remove(int id){
            for(Book t=head;t!=null;t=t.next) if(t.id==id){
                if(t==head)head=t.next; else t.prev.next=t.next;
                if(t==tail)tail=t.prev; else t.next.prev=t.prev;
                return;
            }
        }
        void searchByTitle(String s){ for(Book t=head;t!=null;t=t.next)
            if(t.title.equalsIgnoreCase(s)) System.out.println(t.title+" "+t.author); }
        void searchByAuthor(String s){ for(Book t=head;t!=null;t=t.next)
            if(t.author.equalsIgnoreCase(s)) System.out.println(t.title); }
        void updateAvailability(int id,boolean av){ for(Book t=head;t!=null;t=t.next)
            if(t.id==id){t.available=av;return;} }
        int count(){ int c=0; for(Book t=head;t!=null;t=t.next)c++; return c; }
        void displayForward(){ for(Book t=head;t!=null;t=t.next)
            System.out.println(t.id+" "+t.title+" Av:"+t.available); }
        void displayReverse(){ for(Book t=tail;t!=null;t=t.prev)
            System.out.println(t.id+" "+t.title+" Av:"+t.available); }
    }
    public static void main(String[] a){
        Library lib=new Library();
        lib.addFirst(new Book("1984","Orwell","Dystopia",1,true));
        lib.addLast(new Book("Dune","Herbert","Sci‑Fi",2,true));
        lib.displayForward();
        System.out.println("Total books = "+lib.count());
    }
}
