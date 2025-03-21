package NotSoSimple;

import java.util.ArrayList;

public class userList {
    ArrayList<user> users;
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
    }
    public user getUser(String name) {
        for (user u : users) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }
}
