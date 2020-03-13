package com.company;

public class Book implements Item {
    private String name;
    private int value;
    private int weight;
    private int numberOfPages;
    public static String sortCriteria;

    public Book(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.sortCriteria = "Unknown";

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        numberOfPages = value * 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        this.weight = this.numberOfPages / 100;
    }

    public double getProfitFactor() {
        return (double) this.value / this.weight;
    }

    public void setCriteria(String newCriteria) {
        sortCriteria = newCriteria;
    }

    //The sorting criteria: if sortCriteria="name" we sort by name, otherwise by profit factor
    public int compareTo(Item a) {
        String nameCheck = new String("name");
        if (sortCriteria.equals(nameCheck) == true)
            return this.getName().compareTo(a.getName());
        else{
            if(this.getProfitFactor() > a.getProfitFactor())
                return -1;
                else if(this.getProfitFactor() == a.getProfitFactor())
                    return 0;
                    else
                    return 1;
            }
    }

}
