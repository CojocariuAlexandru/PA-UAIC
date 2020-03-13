package com.company;

public class KnapsackSolver {
    private GreedySolver greedySolver = new GreedySolver();
    private DPSolver dpSolver = new DPSolver();
    private int capacity;

    public void solveGreedy(){
        greedySolver.solve(Main.itemAgenda.getAllItems(), capacity);
        }

    public void solveDP(){
        dpSolver.solve(Main.itemAgenda.getAllItems(), capacity);
    }

    public void setCapacity(int newCapacity){
        capacity = newCapacity;
        }

    public int getCapacity(){
        return capacity;
    }
}
