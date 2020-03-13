package com.company;
import java.util.*;

public class Main {
    public static AvailableItems itemAgenda = new AvailableItems();

    /*
        Cojocariu Alexandru IIA2
        Advanced programming - Laboratory 3 homework
        Done: Compulsory, Optional
        Not done: Bonus
     */
    public static void main(String[] args) {
        KnapsackSolver solver = new KnapsackSolver();
        //Items
        Item item1 = new Book("carte", 800, 10);
        Item item2 = new Food("sandwich", 800, 10);
        Item item3 = new Weapon("pistol", 1500, 15);

        //Add them to the agenda
        itemAgenda.addItem(item1);
        itemAgenda.addItem(item2);
        itemAgenda.addItem(item3);

        //Sort by both criterias
        itemAgenda.sortTheItems("name");
        itemAgenda.displayAllItems();
        itemAgenda.sortTheItems("profitFactor");
        itemAgenda.displayAllItems();

        solver.setCapacity(20);
        //Solve the problem with greedy approach
        solver.solveGreedy();
        //Solve the problem with DP approch
        solver.solveDP();

    }
}
