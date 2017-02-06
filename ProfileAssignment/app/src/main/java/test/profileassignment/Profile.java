package test.profileassignment;

/**
 * Created by David on 2017-02-06.
 */

public class Profile {

    private String name;
    private String age;
    private String id;

    public Profile(String n, String a, String i){
        name = n;
        age = a;
        id = i;
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
