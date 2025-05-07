import java.util.HashMap;

public class Database {

    HashMap<Integer, SpaceObject> spaceobj;
    HashMap<String,User> users;
    HashMap<String, Scientist> scientists = new HashMap<>();
    HashMap<String, Administrator> administrators = new HashMap<>();
    HashMap<String, SpaceAgencyRep> spaceAgencyReps = new HashMap<>();

    public Database(HashMap<Integer, SpaceObject> spaceobj, HashMap<String,User> users) {
        this.spaceobj = spaceobj;
        this.users = users;


        for(User user : users.values()){
            if (user instanceof Scientist){
                this.scientists.put(user.getUsername(), (Scientist) user);
            }
            else if (user instanceof Administrator){
                this.administrators.put(user.getUsername(), (Administrator) user);
            }else if (user instanceof SpaceAgencyRep){
                this.spaceAgencyReps.put(user.getUsername(), (SpaceAgencyRep) user);
            }
        }

        if (!this.administrators.containsKey("global")) {
            this.administrators.put("global", new Administrator("global", "global"));
        }
    }

    HashMap<Integer, SpaceObject> getSpaceRepo(){
        return this.spaceobj;
    }
    HashMap<String,User> getUserRepo(){
        return this.users;
    }

    void addSpaceObject(SpaceObject so) {
        this.spaceobj.put(Integer.parseInt(so.recordId),so);
    }


    SpaceObject getSpaceObject(int id) {
        return spaceobj.get(id);
    }

    Scientist getScientist(String name, String password){
        if (scientists.containsKey(name)){
            if (scientists.get(name).validatePassword(password)){
                return scientists.get(name);
            }else{
                return null;
            }
        }
        return null;
    }

    Administrator getAdministrator(String name, String password){
        if (administrators.containsKey(name)){
            if (administrators.get(name).validatePassword(password)){
                return administrators.get(name);
            }else{
                return null;
            }
        }
        return null;
    }

    SpaceAgencyRep getSpaceAgencyRep(String name, String password){
        if (spaceAgencyReps.containsKey(name)){
            if (spaceAgencyReps.get(name).validatePassword(password)){
                return spaceAgencyReps.get(name);
            }else{
                return null;
            }
        }
        return null;
    }

    void removeUser(String name){
        users.remove(name);
    }

    void removeSpaceObject(int id) {
        spaceobj.remove(id);
    }


}
