package NotSoSimple;

import java.util.ArrayList;

public class groupList {
    private ArrayList<group> groups;
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
        for(int counter = 0; counter < 6; counter++) {

            int randomNum = (int) (Math.random() * 10);
            int randomLet = (int) (Math.random() * 26);
            int letOrNum = (int) (Math.random() * 2);
            if (letOrNum == 0) {
                char c = (char) (randomNum + 48);
                code = code + c;
            }else{
                char c = (char)(randomNum + 65);
                code = code + c;
            }
        }
        return code;
    }

    public group createGroup(){
        boolean isUnique = false;
        String randomCode = bensWonderfulFunction();
        while(!isUnique){

            randomCode = bensWonderfulFunction();
            boolean unique = true;

            for(group g : groups){
                if(g.getGroupCode().equals(randomCode)){
                    unique = false;
                }
            }

            if(unique){
                isUnique = true;
            }
        }
        group G = new group(randomCode);
        addGroup(G);
        return G;
    }
}
