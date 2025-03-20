package NotSoSimple;

public class user {
    private String name;
    private boolean online;
    private String password;
    public user(String name, String password) {
        this.name = name;
        this.password = password;
        online = false;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
