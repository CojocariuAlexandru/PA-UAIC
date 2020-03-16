package optionalAndBonus;

import Compulsory.Hospital;
import Compulsory.Main;
import Compulsory.Resident;

public class MatchingRound {
    private Main inputHandler;
    private ResidentHospitalState stateHandler = new ResidentHospitalState();
    private int successfulTrading;


    public void makeARound(boolean[] assigned, Integer currentRound, Integer numberAssigned){
        int index;
        Hospital preferateHospital;

        for(index=0; index<inputHandler.allResidents.getNumberOfResidents(); index++){
            //for all unmatched so far residents
            if(assigned[index] == false){
                //get the resident's preferate hospital( a hospital he didn't try yet )
                preferateHospital = getThePreferateHospital(index, currentRound);
                //if that hospital's capacity is not fulfilled
                if(preferateHospital.getCapacity() > preferateHospital.getOccupied()) {
                    //add that resident to that hospital
                    preferateHospital.addResident(inputHandler.allResidents.getResidentAgenda().get(index));
                    preferateHospital.increaseOccupied();
                    //increase the number of assigned residents and mark the current resident
                    numberAssigned = numberAssigned + 1;
                    assigned[index] = true;
                }
                //else if the hospital is full
                else if(preferateHospital.getCapacity() == preferateHospital.getOccupied()){
                    //try to see if this resident is better prefered by the hospital
                    //in comparison to a resident already in that hospital
                    successfulTrading = tryTradingResidents(inputHandler.allResidents.getResidentAgenda().get(index), preferateHospital, assigned);
                    if(successfulTrading == 1)
                        assigned[index] = true;
                }
            }
        }
    }

    private Hospital getThePreferateHospital(Integer indexResident, Integer currentRound) {
        int index = 0;
        Hospital auxHospital = new Hospital("", 10);
        for (Hospital chosenHospital:
                inputHandler.preferences.getResidentPreferences()
                        .get(inputHandler.allResidents.getResidentAgenda().get(indexResident))) {
            if (index == currentRound)
                return chosenHospital;
            else if(index > currentRound)
                return null;
            index = index + 1;
        }
        return auxHospital;
    }

    private int tryTradingResidents(Resident candidateResident, Hospital preferateHospital, boolean[] assigned){
        int index;
        // if the candidate resident is better prefered
        if(stateHandler.getResidentPriority(preferateHospital.getResidentsInThisHospital().get(preferateHospital.getResidentsInThisHospital().size()-1), preferateHospital)
                >
                stateHandler.getResidentPriority((candidateResident), preferateHospital)) {
            //switch places and adjust the list of residents in that hospital
            stateHandler.markUnassigned(preferateHospital.getResidentsInThisHospital().get(preferateHospital.getResidentsInThisHospital().size()-1), assigned);
            preferateHospital.getResidentsInThisHospital().remove(preferateHospital.getResidentsInThisHospital().size()-1);
            preferateHospital.addResident(candidateResident);
            return 1;
        }
        return 0;
    }
}
