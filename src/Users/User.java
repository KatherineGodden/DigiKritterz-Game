//this class creates a user and stores user info in a file to be accessed later

package Users;
import petStore.Inventory;
import java.io.*;
public class User{

//fields
  private String username, password;
  private Pet usersPet;
  private Inventory usersStuff;
  private static final String TXT=".txt";

  //needs inventory!
  //private Inventory usersStuff;

  ////////////////////GETTERS/SETTERS///////////////

  //get username
  public String getUsername(){
    return(username);
  }

  //set username
  public void setUsername(String user){
    if( user==null || user.trim().isEmpty()){
      throw new IllegalArgumentException ("Username cannot be empty");
    }
    else{
      this.username=user;
    }
  }

  //get password
  public String getPassword(){
    return(password);
  }

  //set password
  public void setPassword(String p){
    if(validatePassword(p)){
      this.password=p;
    }
    else{
      throw new IllegalArgumentException("Insufficient characters");
    }
  }

  //get pet
  public Pet getPet(){
    return(usersPet);
  }

  //set pet
  public void setPet(Pet p){
    usersPet = p;
  }

  //get users inventory
  public Inventory getUsersStuff(){
    return usersStuff;
  }

  //////////////////CONSTRUCTOR/////////////////////

  //default constructor
  public User(){
    do{
      username = "user" + randomNum();
    }while(lookForAccount());

    password = "password";
    usersPet=new Pet();
    usersStuff=new Inventory();
  }


  //overloader constructor for new user
  public User(String u, String pass, Pet p){
    username = u;
    usersPet = p;
    usersStuff=new Inventory();
    if(validatePassword(pass)){
      password = pass;
    }
    else{
      password = "password";
    }
  }

  //overloader constructor for old user
  public User(String u, String pass){
    username=u;
    usersPet = new Pet();
    usersStuff=new Inventory();
    if(validatePassword(pass)){
      password = pass;
    }
    else{
      password = "password";
    }
  }

  //////////////////INSTANCE METHODS/////////////////

  //create file for user
  public void createFile(){

    //open new file for user
    try{
      FileWriter fw = new FileWriter(username+TXT);
      PrintWriter pw = new PrintWriter(fw);
      pw.println(password);//print password to file
      pw.println(usersPet.getName());//print pet name to file
      pw.println(usersPet.getSpecies());//print species to file
pw.println(usersPet.getHunger()+"\n"+usersPet.getHappiness()+"\n"+usersPet.getBladder() +"\n" + usersPet.getThirst() + "\n" + usersPet.getEnergy() + "\n" + usersPet.getHygiene());//print needs to file
      pw.println(usersStuff.getBalance());//get balance from file
      //print inventory
      for (int i=0; i<usersStuff.getPurchasedItem().size(); i++){
        pw.println(usersStuff.getPurchasedItem().get(i));
      }
      pw.close();
    }
    catch(IOException e){
      System.out.println("Error printing to file");
    }

  }

  //validate password length is at least 6 characters
  public boolean validatePassword(String p){
    if (p.length()<6 && p!=null){
      return false;
    }
    else{
      return true;
    }
  }

  //check if account exists
  public boolean lookForAccount(){
    File f = new File (username+TXT);
    if(!f.exists()){//code is sourced from the internet (in agile cycle)
      return false;
    }
    else{
      return true;
    }
  }

  //read file
  public Pet accessUser(){
    String pass;
    String line;
    try{
      FileReader fr = new FileReader(username+TXT);
      BufferedReader br = new BufferedReader(fr);
      pass = br.readLine(); //password

      //check password
        if(!pass.equals(password)){
          throw new IllegalArgumentException ("wrong password");
        }
        else{
          usersPet.setName(br.readLine()); //pet name
          usersPet.setSpecies(br.readLine()); //pet species
          usersPet.setHunger(Integer.parseInt(br.readLine())); //set hunger
          usersPet.setHappiness(Integer.parseInt(br.readLine())); //set happiness
          usersPet.setBladder(Integer.parseInt(br.readLine())); //set bladder
          usersPet.setThirst(Integer.parseInt(br.readLine())); //set thirst
          usersPet.setEnergy(Integer.parseInt(br.readLine())); //energy
          usersPet.setHygiene(Integer.parseInt(br.readLine())); //set hygiene
          usersStuff.setBalance(Double.parseDouble(br.readLine()));//set balance

          line=br.readLine();
          //set inventory
          while(line!=null){
            usersStuff.addItemFile(line);
            line=br.readLine();
          }
          br.close();
        }


    }
    catch(IOException e){
      System.out.println("Could not read file");
    }
    catch(NumberFormatException e){
      System.out.println("Could not parse integer");
    }
    return (usersPet);
  }

  //////////////////STATIC METHODS/////////////////
  private static int randomNum(){
    return((int)(Math.random()*1000)+1);
  }

}