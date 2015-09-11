package com.team1.hackathon;

/**
 * Created by songmho on 15. 9. 2.
 */
public class Team_item {
    String name;
    String objId;
    boolean isMade;
    public String getName() {
        return name;
    }

    public String getObjId() {
        return objId;
    }

    public boolean isMade() {
        return isMade;
    }

    public Team_item(String name, String objectId, boolean ismade){
        this.name=name;
        this.objId=objectId;
        this.isMade=ismade;
    }
}
