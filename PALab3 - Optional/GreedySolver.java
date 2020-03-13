package com.company;
import java.util.*;

public class GreedySolver {
    private int currentCapacity;
    private int currentValue;
    public GreedySolver(){
        currentCapacity = 0;
        currentValue = 0;
    }
    public void solve(List<Item> availableItems, int maxCapacity){
        System.out.println("Rezolvarea greedy a ales: ");
        //Go though the items by their profit factor
        for(Item auxItem : availableItems){
            //If we have enough space put it
            if(maxCapacity >= currentCapacity + auxItem.getWeight()){
                currentCapacity = currentCapacity = auxItem.getWeight();
                currentValue = currentValue + auxItem.getValue();
                System.out.println(auxItem.getName());
                }
            }
        System.out.println("Greedy a obtinut profitul total: " + currentValue);
        currentCapacity = currentValue = 0;
        }
}
