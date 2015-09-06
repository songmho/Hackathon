package com.team1.hackathon;

/**
 * Created by songmho on 15. 9. 2.
 */
public class Member_item {
    String name;
    String job;
    String phone;

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public String getPhone() {
        return phone;
    }

    public Member_item(String name,String job,String phone){
        this.name=name;
        this.job=job;
        this.phone=phone;
    }
}
