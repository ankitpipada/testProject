package com.eps.smart_epds.Model;

/**
 * Created by Admin on 12/5/2017.
 */

public class UserDetail {
    String Name;
    String Relation;
    String Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRelation() {
        return Relation;
    }

    public void setRelation(String relation) {
        Relation = relation;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public boolean is_Check() {
        return Is_Check;
    }

    public void setIs_Check(boolean is_Check) {
        Is_Check = is_Check;
    }

    public boolean Is_Check=false;
    String Gender;
}
