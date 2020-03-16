package optionalAndBonus;

import Compulsory.Main;
import Compulsory.Hospital;
import Compulsory.Resident;

public class ResidentHospitalState {
    private Main inputHandler;
    public int getResidentPriority(Resident canditate, Hospital preferateHospital){
        int index, preferenceIndex=1000;
        for(Resident resident : inputHandler.preferences.getHospitalPreferences().get(preferateHospital)){
            if(resident.equals(canditate))
                return preferenceIndex;
            preferenceIndex = preferenceIndex - 1;
        }
        return -1;
    }

    public void markUnassigned(Resident leavingResident, boolean[] assigned){
        int index=0;
        for(Resident resident : inputHandler.allResidents.getResidentAgenda()){
            if(leavingResident.equals(resident))
                assigned[index] = false;
            index = index+1;
        }
    }
}
