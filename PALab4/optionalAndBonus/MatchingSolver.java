package optionalAndBonus;

import Compulsory.Hospital;
import Compulsory.Main;
import Compulsory.Resident;

public class MatchingSolver {
    //Bonus: mathing solver implements Gale-Shapley algorithm as requested
    //The algorithm is described here : https://en.wikipedia.org/wiki/Gale%E2%80%93Shapley_algorithm

    private final int maxDimensionInstance = 100;
    private Main inputHandler;
    private MatchingRound singleRoundMaker;
    //Each resident might/might not be assigned to a hospital so far
    private boolean[] assigned = new boolean[maxDimensionInstance];
    private Integer numberAssigned;
    private Integer currentRound;
    private Integer tradingSuccesful;

    public MatchingSolver(){
        //Initialization : no residents are assigned to any hospitals
        int index;
        for(index=0; index<maxDimensionInstance; index++)
            assigned[index] = false;
        numberAssigned = 0;
        currentRound = 0;
        inputHandler = new Main();
        singleRoundMaker = new MatchingRound();
    }

    public void solveMatching(){
        //The algorithm tries matching in multiple rounds
        //In each round, each (unmatched so far) resident will try to match with the most preferate hospital in his list
        //If the already tried a hospital and failed, he tries the second most preferate hospital and so on..
        while (numberAssigned < inputHandler.allResidents.getNumberOfResidents() && currentRound < inputHandler.allResidents.getNumberOfResidents()){
            singleRoundMaker.makeARound(assigned, currentRound, numberAssigned);
            currentRound = currentRound + 1;
        }
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
