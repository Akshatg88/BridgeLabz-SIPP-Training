import java.util.ArrayList;
import java.util.List;

public class SocialMedia {

    static class User {
        int id; String name; int age;
        List<Integer> friends = new ArrayList<>();
        User next;
        User(int id,String name,int age){this.id=id;this.name=name;this.age=age;}
    }

    static class UserList {
        private User head;
        void addUser(User u){ u.next=head; head=u; }

        User find(int id){ for(User t=head;t!=null;t=t.next) if(t.id==id)return t; return null;}
        void addFriend(int a,int b){
            User u=find(a),v=find(b);
            if(u!=null && v!=null && !u.friends.contains(b)){ u.friends.add(b); v.friends.add(a);}
        }
        void removeFriend(int a,int b){
            User u=find(a),v=find(b);
            if(u!=null && v!=null){ u.friends.remove(Integer.valueOf(b)); v.friends.remove(Integer.valueOf(a)); }
        }
        List<Integer> mutual(int a,int b){
            List<Integer> m=new ArrayList<>();
            User u=find(a),v=find(b);
            if(u==null||v==null)return m;
            for(int id:u.friends) if(v.friends.contains(id)) m.add(id);
            return m;
        }
        void displayFriends(int id){
            User u=find(id);
            if(u!=null) System.out.println("Friends of "+u.name+" "+u.friends);
        }
    }

    public static void main(String[] a){
        UserList ul=new UserList();
        ul.addUser(new User(1,"Alice",20));
        ul.addUser(new User(2,"Bob",22));
        ul.addUser(new User(3,"Cara",21));
        ul.addFriend(1,2); ul.addFriend(1,3);
        ul.displayFriends(1);
        System.out.println("Mutual of 2 & 3 : "+ul.mutual(2,3));
    }
}
