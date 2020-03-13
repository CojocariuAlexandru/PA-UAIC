package com.company;
import java.util.*;

public class AvailableItems {
      private List<Item> allItems = new ArrayList<>();
      private Item itemBookHandler = new Book("carte1", 10, 100);
      private Item itemFoodHandler = new Food("carte1", 10, 100);
      private Item itemWeaponHandler = new Weapon("carte1", 10, 100);


      public void sortTheItems(String newCriteria){
            setCriteria(newCriteria);
            Collections.sort(allItems);
            }

      public void addItem(Item newItem){
            allItems.add(newItem);
      }

      public void displayAllItems(){
            for(Item aux : allItems)
                  System.out.println(aux.getName() + ' ' + aux.getProfitFactor());
            }

      private void setCriteria(String newCriteria){
            itemBookHandler.setCriteria(newCriteria);
            itemFoodHandler.setCriteria(newCriteria);
            itemWeaponHandler.setCriteria(newCriteria);
        }

      public List<Item> getAllItems(){
            return allItems;
            }
}
