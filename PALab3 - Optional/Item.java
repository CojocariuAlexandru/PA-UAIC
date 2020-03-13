package com.company;

public interface Item extends Comparable<Item> {
    String getName();

    void setName(String name);

    int getWeight();

    void setWeight(int weight);

    int getValue();

    void setValue(int value);

    double getProfitFactor();

    void setCriteria(String newCriteria);
}
