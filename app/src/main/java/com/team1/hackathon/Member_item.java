package com.team1.hackathon;

/**
 * Created by songmho on 15. 9. 2.
 */
public class Member_item {
    String name;
    String job;

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }
    public Member_item(String name,String job){
        this.name=name;
        this.job=job;
    }
}
