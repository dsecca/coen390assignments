package test.profileassignment;

/**
 * Created by David on 2017-02-06.
 */

public class Profile {

    protected String name;
    protected String age;
    protected String id;

    public Profile(){
        name = null;
        age = null;
        id = null;
    }

    public void saveName(String name){
        this.name = name;
    }

    public void saveAge(String age){
        this.age = age;
    }

    public void saveID(String id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public String getAge(){
        return this.age;
    }

    public String getID(){
        return this.id;
    }
    
}
