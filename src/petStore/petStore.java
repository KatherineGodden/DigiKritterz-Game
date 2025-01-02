//this class allows user to purchase items for pet according to specific pet, further allowing easy access to users personal bankings

//import package and needed classes/formatting tools
package petStore;
import java.text.*;
import Users.*;

public class petStore{

  //create decimal format
  DecimalFormat df = new DecimalFormat();

  //fields - constants
  private static final double KIBBLE = 3.25;
  private static final double CARROT = 2.99;
  private static final double FISH = 3.75;
  private static final double TENNIS_BALL = 2.99;
  private static final double CHEW_STICK = 3.49;
  private static final double TOY_MOUSE = 2.30;

  //fields - colours
  private static final String RESET = "\u001B[0m";
  private static final String BLUE = "\u001B[34m";
  private static final String GREEN = "\u001B[32m";
  private static final String YELLOW = "\u001b[38;5;220m";
  private static final String RED = "\u001B[31m";
  private static final String PINK = "\u001b[38;5;162m";
   private static final String VIOLET = "\u001B[35m";

  //fields - variables, objects, etc
  private Inventory inventory;
  private String selectedItem;
  private double selectedPrice;


  ////////CONSTRUCTOR
  //create new inventory object to use throughout class
  public petStore(){
    inventory = new Inventory();
  }

  /////////ACCESSORS/MUTATORS
  public String getSelectedItem(){
    return selectedItem;
  }

  public double getSelectedPrice(){
    return selectedPrice;
  }

  public boolean confirmPurchase(String confirmation){
    if(confirmation.equalsIgnoreCase("yes")){
      return true;
    }
    else{
      this.selectedItem=null;
      return false;
    }
  }

  //////////DISPLAYING METHOD

  //method for displaying food options 
  public static void displayOptions(){
    System.out.println("\n\nFood Options: ");
    System.out.println("\t[1]. Kibble - $" + KIBBLE);
    System.out.println("\t[2]. Carrot - $" + CARROT);
    System.out.println("\t[3]. Fish - $" + FISH);
    System.out.println("\nToy Options: ");
    System.out.println("\t[4]. Tennis Ball - $" + TENNIS_BALL);
    System.out.println("\t[5]. Carrot Chew Stick - $" + CHEW_STICK);
    System.out.println("\t[6]. Toy Mouse - $" + TOY_MOUSE);
  }


   ////////////////////INSTANCE METHODS

  //method for setting the users selected item
  public void setSelectedItem(int itemNumber){
    switch (itemNumber){
      case 1: 
        selectedItem = "Kibble";
        selectedPrice = KIBBLE;
        break;
      case 2: 
        selectedItem = "Carrot";
        selectedPrice = CARROT;
        break;
      case 3: 
        selectedItem = "Fish";
        selectedPrice = FISH;
        break;
      case 4: 
        selectedItem = "Tennis Ball";
        selectedPrice = TENNIS_BALL;
        break;
      case 5: 
        selectedItem = "Carrot Chew Stick";
        selectedPrice = CHEW_STICK;
        break;
      case 6: 
        selectedItem = "Toy Mouse";
        selectedPrice = TOY_MOUSE;
        break;
      default:
        selectedItem = null;
        selectedPrice =0;
        System.out.println("Invalid Item Number, please try again");

    }//END SWITCH CASE
  }

  //purchasing method - user selecting, sending to inventory
  public void buyItem(int storePurchase, String confirmation, User user){

    boolean check= false;
    //check is user selected anything
    if(selectedItem ==null){
      System.out.println("No item has been selected.");
      return;
    }

    //output what user has chosen
    System.out.println("\n\nYou have selected: " + getColour(selectedItem) + selectedItem + RESET + " for $" + selectedPrice);

    if(confirmation.equalsIgnoreCase("yes")){

      if(user.getUsersStuff().deductBalance(selectedPrice)){
        user.getUsersStuff().addItem(selectedItem, selectedPrice);
        //inventory.addPrice(selectedPrice);

        System.out.println("\nPurchase confirmed. You bought: " + getColour(selectedItem) + selectedItem + RESET);
        check = true;

      }//end if statement inner
    }//end outer if statement
    else{
      //user has cancelled their purchase
      System.out.println("Purchase cancelled");
    }//end else

    //printing appropriate receipts 
    if(check ==true){
       System.out.println("\nRecipt:\n" + selectedItem + " - $" + selectedPrice  + "\n");
    }
    else{
       System.out.println("\nRecipt:\nPurchase not completed."  + "\n");
    }
  }//END CONFIRM PURCHASE METHOD


  //method for viewing the inventory - get from inventory class
  public void viewInventory(User user){
    System.out.println("\n\n--CURRENT INVENTORY--");
    //System.out.println(inventory.addItem());
    System.out.println(inventory);
    System.out.println("Remaining Balance: $" +df.format(user.getUsersStuff().getBalance()));
  }//END VIEW INVENTORY METHOD


  //recipt method - get from inventory class
  public void printRecipt(){
    System.out.println("\n\n--RECEIPT--\n\n"+inventory.getRecipt());
  }//end method


  //colouring method - private because only colouring the varibles in this speciifc class
  private String getColour(String item){
    if(item==null){
      return RESET;
    }
    switch (item){
      case "Kibble":
        return BLUE;
      case "Carrot":
        return GREEN;
      case "Fish":
        return YELLOW;
      case "Tennis Ball":
        return RED;
      case "Carrot Chew Stick":
        return PINK;
      case "Toy Mouse":
        return VIOLET;
      default:
        return RESET;
    }//end the swtich case
  }//end colouring mehthod

}//end pet store CLASS