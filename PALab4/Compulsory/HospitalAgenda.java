package Compulsory;
import Compulsory.Hospital;

import java.util.*;

public class HospitalAgenda{
    //Hospitals stored as TreeSet as requested in the statement
    Set<Hospital> hospitalAgenda = new TreeSet<>();
    public void addHospitalToAgenda(Hospital newHospital){
        hospitalAgenda.add(newHospital);
    }
    public Set<Hospital> getHospitalAgenda(){
        return hospitalAgenda;
    }


}
