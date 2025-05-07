import java.util.HashMap;

/**
 * Database class that holds all the data, holds spaceobject and user hashmaps
 * @author Diego
 * @version 1.0
 */
public class Database {

    HashMap<Integer, SpaceObject> spaceobj;
    HashMap<String, User> users;
    HashMap<String, Scientist> scientists = new HashMap<>();
    HashMap<String, Administrator> administrators = new HashMap<>();
    HashMap<String, SpaceAgencyRep> spaceAgencyReps = new HashMap<>();

    /**
     * Database constructor, makes all the hashmaps
     * @param spaceobj spaceobject hashmap
     * @param users users hashmap
     */
    public Database(HashMap<Integer, SpaceObject> spaceobj, HashMap<String,User> users) {
        this.spaceobj = spaceobj;
        this.users = users;


        for(User user : users.values()){
            addUser(user);
        }

        if (!this.administrators.containsKey("global")) {
            Administrator a = new Administrator("global", "global");
            this.administrators.put("global", a);
            this.users.put("global",a);
        }
    }

    /**
     * @return space object hashmap
     */
    HashMap<Integer, SpaceObject> getSpaceRepo(){
        return this.spaceobj;
    }

    /**
     *
     * @return user object hashmap
     */
    HashMap<String,User> getUserRepo(){
        return this.users;
    }

    /**
     * gets a user from repo
     * @param name desired user
     * @return returns user object
     */
    User getUser(String name){
        if(users.containsKey(name)){
            return users.get(name);
        }
        return null;
    }

    /**
     * gets user and validates password
     * @param name name of user object
     * @param password password of user object
     * @return returns user object
     */
    User getUser(String name, String password){
        if(users.containsKey(name)){
            if(users.get(name).validatePassword(password)){
                return users.get(name);
            }
        }
        return null;
    }

    /**
     * adds user to both user hashmap and specific subclass hashmap
     * @param user user object to add
     */
    void addUser(User user){
        if (user != null) {
            if (user instanceof Scientist) {
                this.scientists.put(user.getUsername(), (Scientist) user);
                this.users.put(user.getUsername(), user);
            } else if (user instanceof Administrator) {
                this.administrators.put(user.getUsername(), (Administrator) user);
                this.users.put(user.getUsername(),user);
            } else if (user instanceof SpaceAgencyRep) {
                this.spaceAgencyReps.put(user.getUsername(), (SpaceAgencyRep) user);
                this.users.put(user.getUsername(),user);
            }
        }
    }


    /**
     * removes a user from user repo
     * @param name name of user to remove
     */
    void removeUser(String name){
        users.remove(name);
    }



}
