package Compulsory;
import Compulsory.Resident;

import java.util.*;

public class ResidentComparator implements Comparator<Resident> {
    //Used for resident sorting, I sort them by name as requested in the statement
    public int compare(Resident firstResident, Resident secondResident){
        if(firstResident.getName().compareTo(secondResident.getName()) > 0) return 1;
        else if(firstResident.getName().compareTo(secondResident.getName()) == 0)return 0;
        return -1;
    }
}
