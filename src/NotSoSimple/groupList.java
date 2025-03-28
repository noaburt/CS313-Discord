package NotSoSimple;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class groupList {
    private ArrayList<group> groups;
    AtomicBoolean listLock = new AtomicBoolean(false);
    public groupList(){
        groups = new ArrayList<>();
    }
    public void addGroup(group g){
        groups.add(g);
    }
    public void removeGroup(group g){
        groups.remove(g);
    }
    public group getGroup(String code){
        for(group g : groups){
            if(g.getGroupCode().equals(code)){
                return g;
            }
        }
        return null;
    }

    public String bensWonderfulFunction(){
        String code = "";
        String[] characters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
                ,"0","1","2","3","4","5","6","7","8","9"};
        for(int counter = 0; counter < 6; counter++) {

            int randomNum = (int) (Math.random() * 36);
            code += characters[randomNum];
        }
        return code;
    }

    public group createGroup(String randomCode){
        group G = new group(randomCode);
        addGroup(G);
        //System.out.println(G.getGroupCode() + " created");
        return G;
    }

    public ArrayList<group> getGroups() {
        return groups;
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
}
