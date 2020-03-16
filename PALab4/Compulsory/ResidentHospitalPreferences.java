package Compulsory;
import Compulsory.Hospital;
import Compulsory.Resident;

import java.util.*;

public class ResidentHospitalPreferences {
    //Two different implementations of Map as requested
    private Map<Resident, List<Hospital>> residentPreferences = new HashMap<>();
    private Map<Hospital, List<Resident>> hospitalPreferences = new LinkedHashMap<>();

    public void addResidentPreference(Resident newResident, List<Hospital> hospitalPreferences){
        residentPreferences.put(newResident, hospitalPreferences);
    }
    public void addHospitalPreference(Hospital newHospital, List<Resident> residentPreferences){
        hospitalPreferences.put(newHospital, residentPreferences);
    }
    public Map<Resident, List<Hospital>> getResidentPreferences(){
        return residentPreferences;
    }

    public Map<Hospital, List<Resident>> getHospitalPreferences(){
        return hospitalPreferences;
    }
}
