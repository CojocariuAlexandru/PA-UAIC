package com.company;

import java.util.*;

public class Resident {
    private String name;
    private Main inputHandler;

    public Resident(String name){
        this.name = name;
        inputHandler = new Main();
        inputHandler.allResidents.addResidentToAgenda(this);
    }

    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }

    //The associative map is between a Resident and a list of hospitals
    //Therefore, we give as parameter any number of hospitals, and construct the list
    //The Arraylist keeps the order of insertion - the order of preferences
    //Also, ArrayList instead of LinkedArrayList because we are only looking to get the preferate hospitals ( O(1) < O(n) )
    public void addHospitalPreferences(Hospital... preferateHospital){
        List<Hospital> hospitalPreferences = new ArrayList<Hospital>();
        for(Hospital newPreferateHospital : preferateHospital)
            hospitalPreferences.add(newPreferateHospital);
        inputHandler.preferences.addResidentPreference(this, hospitalPreferences);
    }
    public boolean hasAcceptableHospital(Hospital hasHospital){
        for(Hospital hospital : inputHandler.preferences.getResidentPreferences().get(this))
            if(hospital.equals(hasHospital))
                return true;
        return false;
    }
}
