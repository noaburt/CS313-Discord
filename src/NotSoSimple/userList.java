package NotSoSimple;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class userList {
    ArrayList<user> users;
    AtomicBoolean listLock = new AtomicBoolean(false);
    public userList() {
        users = new ArrayList<>();
    }
    public void add(user u) {
        users.add(u);
    }
    public void remove(user u) {
        users.remove(u);
    }
    public void createUser(String name, String password) {
        users.add(new user(name, password));
        System.out.println(name + " created");
    }
    public user getUser(String name) {
        for (user u : users) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }
    public AtomicBoolean getListLock() {
        return listLock;
    }
    public boolean setListLock(AtomicBoolean ll) {

        if(listLock.get() == ll.get()){
            return false;
        }
        this.listLock.set(ll.get());
        return true;
    }

    public ArrayList<user> getUsers() {
        return users;
    }
}
