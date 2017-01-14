package com.example.agupta1409.gangup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by a.gupta1409 on 29-06-2016.
 */
public class GroupDetails {

    private static HashMap<String,String> groups = new HashMap<>();

    public static String getKey(String groupId){
        groups = getGroups();
        return groups.get(groupId);
    }

    public static void addGroup(String groupID,String groupKey){
        groups.put(groupID,groupKey);
    }
    private static HashMap<String,String> getGroups(){
        groups.put("F.R.I.E.N.D.S.","friends");
        groups.put("HIMYM","himym");
        return groups;
    }
}
