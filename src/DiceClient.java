
import java.util.Random;
import java.lang.Math;
import java.util.HashMap;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Md Aiman Sharif
 */
public class DiceClient {
   
   /**
    *
    * @param dieArray an array of numbers with which the standard deviation is calculated.
    * @param number total number of elements in the array
    * @return sqrtVariance stores the calculated standard deviation value of the array
    */
   public static double stdDev(int dieArray[], int number) {
      if (number == 0) {
         return 0.0;
      }
      double sumNum = 0.0;
      double sqrtSum = 0;
      for (int i = 0; i < number; i++) {
         sumNum = sumNum + dieArray[i];
         sqrtSum = sqrtSum + Math.pow(dieArray[i], 2);
      }

      double mean = sumNum / number;
      double variance = sqrtSum / number - Math.pow(mean, 2);
      double sqrtVariance = Math.sqrt(variance);

      return sqrtVariance;
   }

   //Main function
   public static void main(String[] args) {
      Dice dice = new Dice(4000); //Creates a dice object of type Dice with 4000 elements 
      Random rand = new Random(); //Creates a random object rand of type Random
      double averageRoll; //Stores the value of average number of rolls calculated
      double standardDeviation; //Variable that stores the standard deviation

      //Calculates the average roll of the die values
      averageRoll = dice.roll() / (double) dice.getDieValues().length;

      //Calculates the standard deviation of the roll values.
      standardDeviation = stdDev(dice.getDieValues(), 4000);

      System.out.println("The average roll was: " + averageRoll);
      System.out.println("The standard deviation of the rolls was: " + standardDeviation);

      //Creates a hashmap of die values as keys and the number of occurences of that die value as keys
      HashMap<Integer, Integer> hashNums = new HashMap<Integer, Integer>();

      int dieValue = dice.getDieValues().length; //stores the length of the die array

      //for loop to get the die values from the hashmap.
      //increments the value by 1 if a match is found 
      //if a match not found, then the first occurence value is stored in the hashmap.
      for (int i = 0; i < dieValue; i++) {
         if (hashNums.containsKey(dice.getDieValues()[i])) {
            int value = hashNums.get(dice.getDieValues()[i]);
            value = value + 1; //increments the value by 1 if a match is found
            hashNums.put(dice.getDieValues()[i], value);
         } else {
            hashNums.put(dice.getDieValues()[i], 1); //puts the first occurence of the die value in the hashmap. 
         }
      }

      //gets the key and the value from the hashmap to print out the die value and the number of occurences.
      for (HashMap.Entry<Integer, Integer> entry : hashNums.entrySet()) {
         Integer key = entry.getKey(); //gets the key in the hashmap
         Integer value = entry.getValue(); //gets the value in the hashmap

         System.out.print(key + "(" + value + ") :");

         int numStar = value / 10; //calculates the number of stars to be printed to the screen
         for (int i = 0; i < numStar; i++) {
            System.out.print("*");
         }
         System.out.print("\n");
      }
   }
}