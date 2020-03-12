package com.company;

import java.util.*;

public class MatchingSolver {
    //Bonus: mathing solver implements Gale-Shapley algorithm as requested
    //The algorithm is described here : https://en.wikipedia.org/wiki/Gale%E2%80%93Shapley_algorithm

    private final int maxDimensionInstance = 100;
    private Main inputHandler;
    //The solution is stored as a map between a resident and a hospital
    private Map<Resident, Hospital> solution = new HashMap<>();
    //Each resident might/might not be assigned to a hospital so far
    private boolean[] assigned = new boolean[maxDimensionInstance];
    private int numberAssigned;
    private int currentRound;

    public MatchingSolver(){
        int index;
        for(index=0; index<maxDimensionInstance; index++)
            assigned[index] = false;
        numberAssigned = 0;
        currentRound = 0;
        inputHandler = new Main();
    }

    public void solveMatching(){
        while (numberAssigned < inputHandler.allResidents.getNumberOfResidents()){
            makeARound();
            currentRound = currentRound + 1;
        }
    }

    public void makeARound(){
        int index;
        Hospital preferateHospital;
        for(index=0; index<inputHandler.allResidents.getNumberOfResidents(); index++){
            if(assigned[index] == false){
                preferateHospital = getThePreferateHospital(index);
                if(preferateHospital.getCapacity() > preferateHospital.getOccupied()) {

                    preferateHospital.addResident(inputHandler.allResidents.getResidentAgenda().get(index));
                    preferateHospital.increaseOccupied();
                    solution.put(inputHandler.allResidents.getResidentAgenda().get(index), preferateHospital);
                    numberAssigned = numberAssigned+1;
                    assigned[index] = true;
                    }
            }
        }
    }

    private Hospital getThePreferateHospital(int indexResident) {
        int index = 0;
        Hospital auxHospital = new Hospital("123", 10);
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
        solution.forEach( (k,v) -> System.out.println( k.getName() + " " + v.getName() ) );
    }
}
