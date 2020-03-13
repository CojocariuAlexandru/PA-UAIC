package com.company;

import java.util.*;

public class MatchingSolver {
    //Bonus: mathing solver implements Gale-Shapley algorithm as requested
    //The algorithm is described here : https://en.wikipedia.org/wiki/Gale%E2%80%93Shapley_algorithm

    private final int maxDimensionInstance = 100;
    private Main inputHandler;
    //Each resident might/might not be assigned to a hospital so far
    private boolean[] assigned = new boolean[maxDimensionInstance];
    private int numberAssigned;
    private int currentRound;
    private int tradingSuccesful;

    public MatchingSolver(){
        //Initialization : no residents are assigned to any hospitals
        int index;
        for(index=0; index<maxDimensionInstance; index++)
            assigned[index] = false;
        numberAssigned = 0;
        currentRound = 0;
        inputHandler = new Main();
    }

    public void solveMatching(){
        //The algorithm tries matching in multiple rounds
        //In each round, each (unmatched so far) resident will try to match with the most preferate hospital in his list
        //If the already tried a hospital and failed, he tries the second most preferate hospital and so on..
        while (numberAssigned < inputHandler.allResidents.getNumberOfResidents()){
            makeARound();
            currentRound = currentRound + 1;
        }
    }

    public void makeARound(){
        int index;
        Hospital preferateHospital;
        //for all residents
        for(index=0; index<inputHandler.allResidents.getNumberOfResidents(); index++){
            //for all unmatched so far residents
            if(assigned[index] == false){
                //get the resident's preferate hospital( a hospital he didn't try yet )
                preferateHospital = getThePreferateHospital(index);
                //if that hospital's capacity is not fulfilled
                if(preferateHospital.getCapacity() > preferateHospital.getOccupied()) {
                    //add that resident to that hospital
                    preferateHospital.addResident(inputHandler.allResidents.getResidentAgenda().get(index));
                    preferateHospital.increaseOccupied();
                    //increase the number of assigned residents and mark the current resident
                    numberAssigned = numberAssigned+1;
                    assigned[index] = true;
                    }
                    //else if the hospital is full
                    else if(preferateHospital.getCapacity() == preferateHospital.getOccupied()){
                        //try to see if this resident is better prefered by the hospital
                        //in comparison to a resident already in that hospital
                        tradingSuccesful = tryTradingResidents(inputHandler.allResidents.getResidentAgenda().get(index), preferateHospital);
                        if(tradingSuccesful == 1)
                            assigned[index] = true;
                    }
            }
        }
    }

    private int tryTradingResidents(Resident candidateResident, Hospital preferateHospital){
        int index;
        // if the candidate resident is better prefered
        if(getResidentPriority(preferateHospital.getResidentsInThisHospital().get(preferateHospital.getResidentsInThisHospital().size()-1), preferateHospital)
            >
               getResidentPriority((candidateResident), preferateHospital)) {
            //switch places and adjust the list of residents in that hospital
            markUnassigned(preferateHospital.getResidentsInThisHospital().get(preferateHospital.getResidentsInThisHospital().size()-1));
            preferateHospital.getResidentsInThisHospital().remove(preferateHospital.getResidentsInThisHospital().size()-1);
            preferateHospital.addResident(candidateResident);
            return 1;
            }
        return 0;
    }

    private void markUnassigned(Resident leavingResident){
        int index=0;
        for(Resident resident : inputHandler.allResidents.getResidentAgenda()){
            if(leavingResident.equals(resident))
                assigned[index] = false;
            index = index+1;
        }
    }

    private int getResidentPriority(Resident canditate, Hospital preferateHospital){
        int index, preferenceIndex=1000;
        for(Resident resident : inputHandler.preferences.getHospitalPreferences().get(preferateHospital)){
            if(resident.equals(canditate))
                return preferenceIndex;
            preferenceIndex = preferenceIndex - 1;
        }
        return -1;
    }

    private Hospital getThePreferateHospital(int indexResident) {
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

    public void printSolution(){
        for(Hospital hospital : inputHandler.allHospitals.getHospitalAgenda()) {
            System.out.print("[ " + hospital.getName() + " ");
            for(Resident resident : hospital.getResidentsInThisHospital())
                System.out.print(resident.getName() + " ");
            System.out.println("]");
        }
    }
}
