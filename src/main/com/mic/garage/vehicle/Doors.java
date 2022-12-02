package com.mic.garage.vehicle;

import java.util.List;

public class Doors {

   private int doors;
   private static List<Integer> rangeDoors = List.of(3,4,5);

   //value object principle: self-validation
   //but validation in constructor break patter: separation of concern
   //solution: factory method?
  private Doors(int doors) {
      this.doors = doors;
   }

   //factory method
   public static Doors createDoors(int doors) {
     if(rangeDoors.contains(doors)){
        return new Doors(doors);
     }  else {
         throw new RuntimeException("The value of doors must be between 3 and 5, extremes included.");
     }
   }

   public String toString(){
      return String.valueOf(this.doors);
   }
}
