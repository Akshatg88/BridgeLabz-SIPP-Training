package Linked_List;
public class InventoryManagement {

    static class Item {
        String name; int id, qty; double price; Item next;
        Item(String n,int id,int q,double p){name=n;this.id=id;qty=q;price=p;}
    }
    static class Inventory {
        private Item head;

        void addLast(Item i){
            if(head==null){head=i;return;}
            Item t=head;while(t.next!=null)t=t.next;t.next=i;
        }
        void delete(int id){
            if(head==null)return;
            if(head.id==id){head=head.next;return;}
            Item t=head;while(t.next!=null && t.next.id!=id)t=t.next;
            if(t.next!=null)t.next=t.next.next;
        }
        Item find(int id){
            for(Item t=head;t!=null;t=t.next) if(t.id==id) return t;
            return null;
        }
        void updateQty(int id,int q){ Item it=find(id); if(it!=null) it.qty=q; }
        double totalValue(){
            double sum=0; for(Item t=head;t!=null;t=t.next) sum+=t.qty*t.price; return sum;
        }

        /* merge sort on SLL by price */
        Item mergeSort(Item h, boolean asc){
            if(h==null||h.next==null)return h;
            Item mid=getMid(h), next=mid.next; mid.next=null;
            Item left=mergeSort(h,asc), right=mergeSort(next,asc);
            return merge(left,right,asc);
        }
        Item merge(Item a,Item b,boolean asc){
            if(a==null)return b;if(b==null)return a;
            boolean cmp=asc ? a.price<=b.price : a.price>=b.price;
            if(cmp){a.next=merge(a.next,b,asc);return a;}
            b.next=merge(a,b.next,asc);return b;
        }
        Item getMid(Item h){
            Item s=h,f=h.next;while(f!=null && f.next!=null){s=s.next;f=f.next.next;}return s;
        }
        void sortByPrice(boolean asc){ head=mergeSort(head,asc); }
        void display(){ for(Item t=head;t!=null;t=t.next)
            System.out.printf("ID:%d %s Qty:%d Price:%.2f%n",t.id,t.name,t.qty,t.price); }
    }
    public static void main(String[] args){
        Inventory inv=new Inventory();
        inv.addLast(new Item("Mouse",101,5,500));
        inv.addLast(new Item("Keyboard",102,4,800));
        inv.sortByPrice(true); inv.display();
        System.out.println("Total = "+inv.totalValue());
    }
}
