package com.company;
import java.util.*;

public class Hospital  implements Comparable<Hospital>{
    // Each hospital has: name, capacity, the number of occupied places at this moment and the residents preferences
    private Main inputHandler;
    private String name;
    private int capacity;
    private int occupied;
    private List<Resident> residentsInThisHospital = new ArrayList<Resident>();
    public Hospital(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.occupied = 0;
        inputHandler = new Main();
        inputHandler.allHospitals.addHospitalToAgenda(this);
    }

    // Setters, getters
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
    public void setCapacity(int newCapacity){capacity = newCapacity;}
    public int getCapacity(){
        return capacity;
    }
    public int getOccupied(){
        return occupied;
    }
    public void increaseOccupied(){
        this.occupied = this.occupied + 1;
    }
    public void addResident(Resident newResident){
        residentsInThisHospital.add(newResident);
    }

    public void displayResidents(){
        int index;
        for(index=0; index<residentsInThisHospital.size(); index++)
            System.out.println("[" + this.name + ", " + residentsInThisHospital.get(index).getName());
    }


    //Used for sorting, implements method from Comparable
    public int compareTo(Hospital anotherHospital){
        if(this.getName().compareTo(anotherHospital.getName()) > 0) return 1;
        else if(this.getName().compareTo(anotherHospital.getName()) == 0) return 0;
        return -1;
    }

    public void addResidentPreferences(Resident... preferateResident){
        List<Resident> residentPreferences = new ArrayList<Resident>();
        for(Resident newPreferateResident : preferateResident)
            residentPreferences.add(newPreferateResident);
        inputHandler.preferences.addHospitalPreference(this, residentPreferences);
    }
}
