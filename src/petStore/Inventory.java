//this class stores users purchases recieved from pet store

//import package and need tools for class
package petStore;

import java.util.ArrayList;
import java.text.*;

public class Inventory{

  //create decimal format
  DecimalFormat df = new DecimalFormat();

  //fields - arraylists and variables
  private ArrayList<String> purchasedItems;
  private ArrayList<Double> prices;
  private double balance;


  ///CONSTRUCTOR - override
  public Inventory(){
    purchasedItems = new ArrayList <> ();
    prices = new ArrayList <> ();
    balance = 20.00;
  }


 //method for adding to array lists
 public void addPrice( double price){
   //purchasedItems.add(item);
   if(price>=0){
     prices.add(price);
   }
   else{
     System.out.println("price cannot be negative");
  }
}

  public void additem(String item){
    if (item != null && !item.isEmpty()) {
      //isEmpty() reference - https://www.geeksforgeeks.org/list-isempty-method-in-java-with-examples/
      purchasedItems.add(item);
    } else {
      System.out.println("Item cannot be empty");
    }
  }

  //method for adding item to array list afrer users purchase
  public void addItem(String item, double price){
    double totalCost =0;
    //isEmpty() reference - https://www.geeksforgeeks.org/list-isempty-method-in-java-with-examples/
    if(item !=null && !item.isEmpty()){
      purchasedItems.add(item);
      prices.add(price);
      ///////////////////totalCost += price;
    }
    else{
      System.out.println("Item cannot be empty and price cannot be negative.");
    }
  }//end method


  //add item overloader for user file access
  public void addItemFile(String item){
    //refence for isEmpty function - https://www.geeksforgeeks.org/list-isempty-method-in-java-with-examples/
      purchasedItems.add(item);
  }//end method

  ////ACCESSORS + MUTATOR

  public ArrayList<String> getPurchasedItem(){
    return purchasedItems;
  }

  //method for getting balance -accessor
  public double getBalance(){
    return balance;
  }

  //method for setting balance
  public void setBalance(Double b){
    if(balance >=0){
      this.balance=b;
    }
    else{
      System.out.println("Balance cannot be negative.");
    }
  }

  //method for deducting money
  public boolean deductBalance(double amount){
    if(amount <= balance){
      balance -= amount;
        return true;
    }
    else{
      System.out.println("Insufficient balance or invalid amount, purchase not completed.");
      return false;
    }//end ifs
  }//end methods for deduction

  //method for setting balance
  public void addToBalance(Double b){
    if(b>=0){
      balance+=b;
    }
    else{
      System.out.println("Amount to add cannot be negative.");
    }
  }


////////////INSTANCE METHODSSS

  //removes item from inventory upon being used
  public void giveItemToPet (int index){
    try{
       String item = purchasedItems.remove(index);
    }
    catch (IndexOutOfBoundsException e){
      System.out.println("That is not a valid option");
    }
  }
  public String getRecipt(){
    if(purchasedItems.isEmpty()){
      //isEmpty() reference - https://www.geeksforgeeks.org/list-isempty-method-in-java-with-examples/
      return "No items purchased.";
    }

    double totalCost =0;
    String receipt = "\nRecipt: \n";
    for(int i=0;i<purchasedItems.size();i++){
      String item = purchasedItems.get(i);
      double price = prices.get(i);
      receipt += item + " - $" + price + "\n";
      totalCost += price;
    }

    receipt += "\nTotal Cost: $" + totalCost + "\n" + "\nRemaining Balance: $" + balance + "\n";
    return receipt;
  }//END RECEIPT METHOD

  //to string method
  public String toString(){

    String inventoryList = "\nPurchased Items:\n";
    double totalCost =0, price=0;
    for(int i=0;i< purchasedItems.size();i++){
      //String item = purchasedItems.get(i);
      //totalCost=0;

      if (i<prices.size()){
        price = prices.get(i);
      }
      //inventoryList += "[" +(i+1) + "] " + item + " - $" + price + "\n";
      inventoryList += "[" +(i+1) + "] " + purchasedItems.get(i) +"\n";
      totalCost +=price;
    }
    System.out.println("\n\nBalance: $" + getBalance());
    return inventoryList;
  }//end method toString

}//end inventory class