/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Date;

/**
 * A class representing an array of die and creating a random variable.
 * @author Md Aiman Sharif
 */

public class Dice {
   private int[] die; //Creates an array to store the randomly generated die numbers
   private Random random; //Creates a variable of type class Random. 
   
   /**
    * The default constructor initializing the random object and constructs the default pair of die
    * Initializes die to an array of size 2 with randomly generated numbers. 
    *
    */
   public Dice(){   
      this(2);
   } 
   
   /**
    * The one argument constructor allows the construction of any number of dice.
    * Overloaded constructor constructing any number of die passed in the parameter numDice. 
    * passed as an argument for any number of dice. 
    * Initializes instance variables.
    * 
    * @param numDice the number of die that is passed in as an argument. 
    */
   
   public Dice(int numDice){
      if(numDice < 1)
         throw new IllegalArgumentException ("Invalid number of dice entered: " + numDice);
         this.random = new Random(new Date().hashCode());
         this.die = new int[numDice];
         for(int i = 0; i < die.length; i++){
            die[i] = rollDie();
         }
     }
   
   /**
    * Creates a copy constructor of Dice.
    * @param c object of type Dice
    */
   Dice(Dice c){
       this.die = new int[c.die.length];
       random = new Random(new Date().hashCode());
   }
   
   /**
    * Rolls all of the die at once and returns their total value in a variable totalVal.
    * The rollDie() method is called which ensures that the rolled value is between 1 and 6 inclusive. 
    * @return totalVal an int returning the total value of the dice roll.
    */
   
   public int roll(){
      int totalVal = 0; //initializes the totalVal to 0;
      for(int i = 0; i < this.die.length; i++){
          this.die[i] = rollDie();
          totalVal += this.die[i];
      }
      return totalVal;
    }
   
   /**
    * This method rolls the die and the rollValue gets assigned any number between 1 and 6.
    * @return rollValue stores the randomly generated number from 1 to 6.
    */
   private int rollDie(){
      int rollValue = random.nextInt(6) + 1; //Rolls a single die ensuring the rolled value is between 1 and 6 inclusive. 
      
      return rollValue;
   }
   
   /**
    * Checks to see whether the two die values in the die array are the same or not. 
    * If the die values are the same, returns true, else returns false. 
    * @return true if both values are same or returns false if values are different in the array of die. 
    */
   public boolean hasDoubles(){
      if(this.die[0] == this.die[1]){
         return true;
      }
      return false;
   }
  
   /**
    * Converts the numbers in the die array to string and stores the numbers in a string.
    * @return spacedNum concatenates the numbers in the array as strings with spaces in between. 
    */
   public String toString(){ 
      String spacedNum = "";
      for(int i = 0; i < this.die.length; i++){
         spacedNum += this.die[i] + " ";
      }
      return spacedNum; 
   }
 
   /**
    * Returns a defensive copy of the die array as newArray. 
    * @return newArray an array holding the copy of the die array.
    */
   public int[] getDieValues(){
      int newArray[] = new int[this.die.length];
      for(int i = 0; i < newArray.length; i++){
         newArray[i] = this.die[i];
      }
      return newArray;
   }
}
