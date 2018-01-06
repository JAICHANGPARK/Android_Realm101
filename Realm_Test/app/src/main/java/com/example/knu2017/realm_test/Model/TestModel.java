package com.example.knu2017.realm_test.Model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by KNU2017 on 2018-01-06.
 */

public class TestModel extends RealmObject {
    private String userUUID;
    private String name;
    private int age;

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    @Ignore
    private int sessionid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSessionid() {
        return sessionid;
    }

    public void setSessionid(int sessionid) {
        this.sessionid = sessionid;
    }
}
