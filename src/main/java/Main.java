//Katherine Godden and Zainab Faisal
//May 7, 2024 
//Purpose: Create a user-friendly virtual pet program which allows user to execute a number of tasks to take care of their pet!!

import Users.*;
import petStore.*;
import Game.Hangman;
import java.util.*;
public class Main {
  public static void main(String[] args) {

    Scanner in = new Scanner (System.in);
    //variables
    int menuOption, logIn=0, petMenuOption=0, storePurchase=0, itemIndex;
    String petSelection="", name, username="", pass="", confirmation="", morePurchases="";
    Pet userPet=new Pet();
    User user=new User();
    Hangman game = new Hangman();
    petStore petStore = new petStore();
    boolean valid=false;


////////////////////////USER LOGIN SCREEN/////////////////////////////////n


    Pet.printLogo();

    //ask user to log in or create a new account
      System.out.println("\n\n---OPENING-MENU---\n");
      System.out.println("[1]Log in \n[2]Create new account ");

    //select option
      do{
        try{
          System.out.print("Selection: ");
          logIn = in.nextInt();

          if(logIn!=1 && logIn!=2){
            System.out.println("\nPlease enter 1 or 2\n");
          }
        }
        catch(InputMismatchException e){
          System.out.println("\nPlease enter a number\n");
          in.next();
        }
      }while(logIn!=1 && logIn!=2);

     Pet.clearScreen(); 

      //log into old account//////////////////////
      if (logIn==1){
        System.out.println("\n----LOG-IN----\n");
        //validate username
        do{
          System.out.print("Username: ");
          username=in.next();
          user.setUsername(username);

          if(!user.lookForAccount()){
            System.out.println("This account name does not exist");
          }
        }while(!user.lookForAccount());

        //validate password and get pet
          do{
            try{
              System.out.print("Password: ");
              pass=in.next();
              user.setPassword(pass);
              userPet = user.accessUser();
              valid=true;
            }
            catch(IllegalArgumentException e){
              System.out.println("Incorrect Password");
            }
          }while(!valid);
        }//end log in




    //create new account///////////////////////////
    if (logIn==2){
      System.out.println("\n--CREATE-NEW-ACCOUNT--\n");
      do{
        //username
        System.out.print("Create a username: ");
        username=in.next();
        user.setUsername(username);
        //make sure username isnt taken
        if(user.lookForAccount()){
          System.out.println("This username is already taken");
        }
      }while(user.lookForAccount());

      //create and validate password 
      do{
        try{
          System.out.print("Create a password: ");
          pass=in.next();
          user.setPassword(pass);
          valid=true;
        }
        catch(IllegalArgumentException e){
          System.out.println("Make sure your password is at least 6 characters");
        }
      }while(!valid);
      valid=false; //reset valid boolean

      //create new pet
        System.out.println("\nPlease select the pet you would like to adopt!");
        System.out.println("🐶Dog\n🐱Cat\n🐰Bunny");

      do{
        try{
          //select species
          System.out.print("\nEnter here: ");
          petSelection = in.next();
          userPet.setSpecies(petSelection);
          valid=true;
        }
        catch(IllegalArgumentException e){
          System.out.println("Please select a pet from the menu above");
        }
      }while(!valid);


      //user names pet
      System.out.print("\nGreat! Give your " + petSelection.toLowerCase() + " a name: ");
      name = in.next();
      userPet.setName(name);

      //create user file
      user.setPet(userPet);
      user.createFile();

    }//end create account

     Pet.clearScreen();


    //start program///////////////////////////////////////
    do{

      System.out.println(userPet);

      //menu display
      System.out.println("\n\n-------MAIN MENU------");
      System.out.println("[1] Play with your pet\n[2] Feed your pet\n[3] Give water to your pet\n[4] Take your pet to the groomers (Costs $10)\n[5] Give your pet a toy\n[6] Take your pet to the bathroom\n[7] Send your pet to sleep\n[8] Pet Store\n[9] Quit");

      //user selects an option
      do{
        menuOption=-1;//reset option
        try{
          System.out.print("\nChoose an option: ");
          menuOption = in.nextInt();

          if (!(menuOption>=1 && menuOption<=9)){
            System.out.println("Please enter a valid number from the menu options");
          }
        }
        catch(InputMismatchException e){
          System.out.println("Please enter a valid number from the menu options");
          in.next();
        }
      }while(!(menuOption>=1 && menuOption<=9));


      //user selects play
      if(menuOption==1){
        Pet.clearScreen();
        game.resetGame();
        game.playGame();//play hangman
        userPet.play();//increment needs
        //check if user won to add money to balance
        if (game.win==true){
          user.getUsersStuff().addToBalance(10.0);
        }
        Pet.clearScreen();
      }

      //user selects feed
      else if(menuOption==2){

        //open inventory and select food item
        System.out.println(user.getUsersStuff());

        try{
          System.out.println("Select a food item (Enter any letter to go back): ");
          itemIndex = in.nextInt() -1;
          //give item
  userPet.feed(user.getUsersStuff().getPurchasedItem().get(itemIndex));
          user.getUsersStuff().giveItemToPet(itemIndex);
        }
        catch(InputMismatchException e){
          Pet.clearScreen();
        }
        catch(IndexOutOfBoundsException e){
          Pet.clearScreen();
          System.out.println("That is not a valid option");
        }



      }

      //user selects water
      else if(menuOption==3){
        userPet.water();
      }

      //user selects groom
      else if(menuOption==4){
        if(user.getUsersStuff().deductBalance(10)){
          userPet.groom();
        }
        else{
          Pet.clearScreen();
          System.out.println("You need $10 to get your pet groomed. Your current balance is $" + user.getUsersStuff().getBalance());
        }

      }

      //user selects give toy
      else if(menuOption==5){

        //open inventory and select food item

        System.out.println(user.getUsersStuff());

        try{
          System.out.println("Select a Toy (Enter any letter to go back): ");
          itemIndex = in.nextInt() -1;
          userPet.giveToy(user.getUsersStuff().getPurchasedItem().get(itemIndex));
          user.getUsersStuff().giveItemToPet(itemIndex);
        }
        catch(InputMismatchException e){
          Pet.clearScreen();
        }
        catch(IndexOutOfBoundsException e){
          Pet.clearScreen();
          System.out.println("That is not a valid option");
        }

      }

      //user selects go to bathroom
      else if(menuOption==6){
        userPet.potty();
      }

      //user selects sleep
      else if (menuOption==7){
        userPet.sleep();
      }

      //user selects pet class
      else if (menuOption==8){
        Pet.clearScreen();
        do{
          System.out.println("\n\n-------PET MENU------");
          System.out.println("[1] Pet Store\n[2] See your inventory\n[3] Quit");
          //allow uer to enter choice - try catch to make sure user input is valid
          System.out.print("\nChoice: ");
          try{
            petMenuOption = in.nextInt();

            //OPTION 1 - PET STORE
            if(petMenuOption ==1){
              Pet.clearScreen();//clear screen
              System.out.println("\t\t\t\t˚୨୧⋆｡˚ ⋆ ˚୨୧⋆｡˚ ⋆   PET STORE ˚୨୧⋆｡˚ ⋆ ˚୨୧⋆｡˚ ⋆");

              //display pet store options for food and toys
              petStore.displayOptions();

              //do while loop to ask user for # of purchases
              do{
                System.out.println("\n\nPlease enter the number of the item you would like to purchase");
                try{
                  storePurchase = in.nextInt();

                  if(storePurchase<1 || storePurchase>6){
                    System.out.println("invalid item number, please try again.");
                    continue;
                    //reference for continue function - goes to next loop iteration
                    //https://ioflood.com/blog/java-continue/#:~:text=If%20you%20want%20to%20skip,may%20not%20behave%20as%20expected.&text=In%20this%20example%2C%20'continue%20outerloop,whenever%20'j'%20equals%202.
                  }

                  //set the purchased item to users choice
                  petStore.setSelectedItem(storePurchase);
                  System.out.println("\nSelected item: " + petStore.getSelectedItem());

                  //ask user for confirmation
                  System.out.print("\nPlease confirm the purchase of the item. Please enter yes or no: ");
                  confirmation = in.next();

                  //check confirmation for "yes", if yes then send users item and he price to array list for storing
                  if(petStore.confirmPurchase(confirmation)){

                    System.out.println("\nPurchase confirmed. You bought: " + petStore.getSelectedItem());
                  }//end if
                  else{
                    System.out.println("Purchase cancelled");
                  }//end else if
                }//end try
                catch(InputMismatchException e){
                  System.out.println("Invalid input. Please enter a valid item number.");
                  in.next();//clear invalid input
                }//end catch

                //send the confirmation to the pet class
                 petStore.buyItem(storePurchase, confirmation, user);

                //more purchases?
                System.out.print("Would like to purchases another item: please enter yes or no: ");
                morePurchases = in.next();
              }while(morePurchases.equalsIgnoreCase("yes"));//end do-while loop
              //Pet.clearScreen();
            }//END OPTION 1 - PET STORE
            //OPTION 2 - USER INVENTORY
            else if(petMenuOption ==2){
              Pet.clearScreen();//clear screen
              System.out.println("\t\t\t\t˚୨୧⋆｡˚ ⋆ ˚୨୧⋆｡˚ ⋆   INVENTORY ˚୨୧⋆｡˚ ⋆ ˚୨୧⋆｡˚ ⋆");
              System.out.println(user.getUsersStuff());//prints users current inventory
              //System.out.println(petStore.viewInventory());
              //Pet.clearScreen();//clear screen
            }//END OPTION 2 - USER INVENTORY
            else{
              Pet.clearScreen();//clear screen
              System.out.println("Exiting pet store...");//exit pet store
              Pet.clearScreen();//clear screen
            }
          }//end try
          catch(InputMismatchException e){
            System.out.println("Invalid Option. Please enter again");
            in.next();//this clears the invalid input
          }//end catch
        }while(petMenuOption!=3);

      }//end menu option 8
      //save user progress upon choosing to quit
      else if(menuOption==9){
        user.createFile();
      }//end menu option 9
    }while(menuOption!=9);//end program

    in.close();

  }//end main method
}//end class