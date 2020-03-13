package com.company;

import java.util.List;

public class DPSolver {
    private final int maxDimension = 100;
    private int currentCapacity;
    private int currentValue;
    private int dpState[][] = new int[maxDimension][maxDimension];

    /*
        DP approach: O( nrItems * knapsackSize)

        Let's consider we have the list of items with their values and weights:
        v1, v2, v3, ..., vn
        w1, w2, w3, ..., wn
        and the total capacity of the knapsack K

        Let's define dp[i][j] = the maximum profit we can get by using the first i items from the list
                                and considering(hypotethically) the knapsack capacity as being j
        Now, it's easy to see that the answer will be dp[n][K]
        dp[i][j] = MAX ( dp[i-1][j] - we don't use the ith item, dp[i-1][j - wi] + vi - we use it )
     */

    public DPSolver() {
        currentCapacity = 0;
        currentValue = 0;
    }

    public void solve(List<Item> availableItems, int maxCapacity) {
        int indexRow, indexColumn;
        //Initialize dp[i][j] = 0
        initialize();
        for (indexRow = 0; indexRow < availableItems.size(); indexRow++){
            for (indexColumn = 0; indexColumn <= maxCapacity; indexColumn++){
                //Recursive case:
                if (indexColumn >= availableItems.get(indexRow).getWeight() && indexRow >= 1) {
                    //The formula is explained above
                    dpState[indexRow][indexColumn] = maxOfTwo(
                            dpState[indexRow - 1][indexColumn],
                            dpState[indexRow - 1][indexColumn - availableItems.get(indexRow).getWeight()] +
                                    availableItems.get(indexRow).getValue()
                            );
                    }
                //Base case:
                //We only have the first item and we put it in the knapsack if we can
                    else if (indexColumn >= availableItems.get(indexRow).getWeight() && indexRow == 0) {
                        if (indexColumn >= availableItems.get(indexRow).getWeight())
                            dpState[indexRow][indexColumn] = availableItems.get(indexRow).getValue();
                    }
                System.out.print(dpState[indexRow][indexColumn] + " ");
                if(dpState[indexRow][indexColumn] > currentValue)
                    currentValue = dpState[indexRow][indexColumn];
                }
            System.out.println("");
            }

        System.out.println("DP a obtinut profitul total: " + currentValue);
        currentCapacity = currentValue = 0;
    }

    private void initialize() {
        int indexRow, indexColumn;
        for (indexRow = 0; indexRow < 100; indexRow++)
            for (indexColumn = 0; indexColumn < 100; indexColumn++)
                dpState[indexRow][indexColumn] = 0;
    }

    private int maxOfTwo(int firstNumber, int secondNumber) {
        if (firstNumber >= secondNumber)
            return firstNumber;
        return secondNumber;
    }
}
