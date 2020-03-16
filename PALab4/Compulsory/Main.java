package Compulsory;
import optionalAndBonus.MatchingSolver;

public class Main {
    /*
        Cojocariu Alexandru, IIA2
        Advanced programming - Laboratory 4 homework

        Done: Compulsory, Optional, Bonus
        Not done: Generating fake names with third party library
    */

    // Agendas and preferences available to everyone to work with
    public static ResidentAgenda allResidents = new ResidentAgenda();
    public static HospitalAgenda allHospitals = new HospitalAgenda();
    public static ResidentHospitalPreferences preferences = new ResidentHospitalPreferences();
    private static MatchingSolver solveMatching = new MatchingSolver();

    public static void main(String[] args) {
        //Setting up the example given on the laboratory page

        //Residents
        Resident residentAlex = new Resident("Alex");
        Resident residentAndrei = new Resident("Andrei");
        Resident residentMatei = new Resident("Matei");
        Resident residentMarius = new Resident("Marius");

        //Hospitals
        Hospital spital1 = new Hospital("spital1", 1);
        Hospital spital2 = new Hospital("spital2", 2);
        Hospital spital3 = new Hospital("spital3", 2);

        //Residents hospital preferences
        residentAlex.addHospitalPreferences(spital1, spital2, spital3);
        residentAndrei.addHospitalPreferences(spital1, spital2, spital3);
        residentMatei.addHospitalPreferences(spital1, spital2);
        residentMarius.addHospitalPreferences(spital1, spital3);

        //Hospital residents preferences
        spital1.addResidentPreferences(residentMarius, residentAlex, residentAndrei, residentMatei);
        spital2.addResidentPreferences(residentAlex, residentMatei, residentAndrei);
        spital3.addResidentPreferences(residentAlex, residentAndrei, residentMarius);


        solveMatching.solveMatching();
        solveMatching.printSolution();

        //From compulsory - the streams problem
        allResidents.getResidentAgenda().stream().filter(n -> {if(n.hasAcceptableHospital(spital1) == true
                                                                 && n.hasAcceptableHospital(spital3) == true)
                                                                return true;
                                                                else
                                                                return false;})
                                        .forEach(n -> System.out.println(n.getName()));

        /*allHospitals.getHospitalAgenda().stream().filter(n -> {if(n.isItTopPreference(residentAlex) == true)return true; else return false;})
                .forEach(n -> System.out.println(n.getName()));*/
     }
}
