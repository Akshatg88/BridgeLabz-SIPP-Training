import java.util.*;

abstract class LibraryItem {
    private final String itemId;
    private final String title;
    private final String author;
    protected LibraryItem(String id,String t,String a){itemId=id;title=t;author=a;}
    public abstract int getLoanDuration();   // days
    public String getItemDetails(){
        return String.format("%s – %s by %s", itemId,title,author);
    }
}

interface Reservable{
    boolean reserveItem(String userId);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable{
    private boolean available=true;
    public Book(String id,String t,String a){super(id,t,a);}
    @Override public int getLoanDuration(){ return 21; }
    @Override public boolean reserveItem(String u){ if(available){available=false;return true;}return false;}
    @Override public boolean checkAvailability(){ return available; }
}

class Magazine extends LibraryItem implements Reservable{
    private boolean available=true;
    public Magazine(String id,String t,String a){super(id,t,a);}
    @Override public int getLoanDuration(){ return 7; }
    @Override public boolean reserveItem(String u){ if(available){available=false;return true;}return false;}
    @Override public boolean checkAvailability(){ return available; }
}

class DVD extends LibraryItem implements Reservable{
    private boolean available=true;
    public DVD(String id,String t,String a){super(id,t,a);}
    @Override public int getLoanDuration(){ return 3; }
    @Override public boolean reserveItem(String u){ if(available){available=false;return true;}return false;}
    @Override public boolean checkAvailability(){ return available; }
}

public class LibraryDemo{
    public static void main(String[]args){
        List<LibraryItem> items=List.of(new Book("B01","1984","Orwell"),
                                        new Magazine("M01","Nature","Group"),
                                        new DVD("D01","Inception","Nolan"));
        items.forEach(i->System.out.printf("%s – Loan: %d days%n",
                         i.getItemDetails(), i.getLoanDuration()));
    }
}
