package com.company;
import java.util.*;

public class ResidentAgenda {

    private static List<Resident> residentAgenda = new ArrayList<Resident>();
    public List<Resident> getResidentAgenda(){
        return residentAgenda;
    }
    public int getNumberOfResidents(){
        return residentAgenda.size();
    }

    public void addResidentToAgenda(Resident newResident){
        residentAgenda.add(newResident);
    }

    public void sortResidentAgenda(){
        ResidentComparator sortByName = new ResidentComparator();
        Collections.sort(residentAgenda, sortByName);
    }
}
