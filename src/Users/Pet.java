//this class creates the pet and changes its needs status as user interacts with it

package Users;

import java.util.*;
public class Pet{
  private static final String [] PETS = {"DOG","CAT","BUNNY"};
  private static final String DOGPIC [] = {"   ___\n __/_  `.  .-\"\"\"-.\n \\_,` | \\-'  /   )`-')\n  \"\") `\"`    \\  ((\"`\"\n ___Y  ,    .'7 /|\n(_,___/...-` (_/_/ ", "   ___\n __/_  `.  .-\"\"\"-.\n \\_,` | \\-'  /   )`-')\n  \"\") `\"`    \\  ((\"``\n ___Y  ,    .'7 /|\n(_,___/...-` (_/_/\n   ( O )", "              _,)\n        _..._.-;-'\n     .-'     `(\n    /      ;   \\\n   ;.' ;`  ,;  ;\n  .'' ``. (  \\ ;\n / f_ _L \\ ;  )\\\n \\/|` '|\\/;; <;/\n((; \\_/  (()   \n    _____\n   /     \\\n  |  o o  |\n  | o o o |\n   \\_____/", "              _,)\n        _..._.-;-'\n     .-'     `(\n    /      ;   \\\n   ;.' ;`  ,;  ;\n  .'' ``. (  \\ ;\n / f_ _L \\ ;  )\\\n \\/|` '|\\/;; <;/\n((; \\_/  (()   \n    _____\n   /     \\\n  |  ~ ~  |\n  | ~ ~ ~ |\n   \\_____/", "        _\n            ,/A\\,\n          .//`_`\\\\,\n        ,//`____-`\\\\,\n      ,//`[_DOGGY_]`\\\\,\n    ,//`=  ==  __-  _`\\\\,\n   //|__=  __- == _  __|\\\\\n   ` |  __ .-----.  _  | `\n     | - _/       \\-   |\n     |__  | .-\"-. | __=| zZZZZ\n     |  _=|/)   (\\|    |\n     |-__ (/ a a \\) -__|\n     |___ /`\\_Y_/`\\____|\n          \\)8===8(/"};

  private static final String CATPIC[]={"                   _ |\\_\n                   \\` ..\\\n              __,.-\" =__Y=\n            .\"        )\n      _    /   ,    \\/\\_\n     ((____|    )_-\\ \\_-`\n     `-----'`-----` `--`", "_._     _,-'\"\"`-._      \n(,-.`._,'(       |\\`-/|   \n    `-.-' \\ )-`( , o o)  \n          `-    \\`_`\"'- \n               <[•.•]>", "_._     _,-'\"\"`-._      \n(,-.`._,'(       |\\`-/|   \n    `-.-' \\ )-`( , o o)  \n          `-    \\`_`\"'- \n               ><((((('>", "_._     _,-'\"\"`-._      \n(,-.`._,'(       |\\`-/|   \n    `-.-' \\ )-`( , o o)  \n          `-    \\`_`\"'- \n                (~ ~ ~)", "     |\\      _,,,---,,_\nZZzz  /,`.-'`'    -.  ;-;;,_\n     |,4-  ) )-,_. ,\\ (  `'-'\n    '---''(_/--'  `-'\\_)  "};

  private static final String BUNNYPIC[]={"             ,\\\n             \\\\\\,_\n              \\` ,\\\n         __,.-\" =__)\n       .\"        )\n    ,_/   ,    \\/\\_\n    \\_|    )_-\\ \\_-`\n       `-----` `--`", "             \\     /\n             \\\\   //\n              )\\-/(\n              /e e\\\n             ( =Y= )\n             /`-!-'\\\n        ____/ /___\\ \\\n   \\   /    ```    ```~~\"--.,_\n`-._\\ /                       `~~\"--.,_\n----->|                                `~~\"--.,_\n_.-'/ \\                                         ~~\"--.,_\n   /jgs\\_________________________,,,,....----\"\"\"\"~~~~```","             ,\\          _\\/_" + "\n             \\\\\\,_       \\  /" + "\n              \\` ,\\       \\/" + "\n         __,.-\" =__)   ♥ " + "\n       .\"        )     " + "\n    ,_/   ,    \\/\\\\_ " + "\n    \\_|    )_-\\ \\_-" + "\n       `-----` `--` ","             ,\\\n" + "             \\\\\\,_\n" + "              \\` ,\\\n" + "         __,.-\" =__)\n" + "       .\"        )\n" +"    ,_/   ,    \\/\\_\n" + "    \\_|    )_-\\ \\_-`  \\~~~~~/\n" + "       `-----` `--`    \\___/", "             ((`\\\n            ___ \\\\ '--._  zzZZZ\n         .'`   `'    o  )\n        /    \\   '. __.'\n       _|    /_  \\ \\_\\_\n      {_\\______\\-'\\__\\_\\"};


  private int hunger, happiness, bladder, thirst, energy, hygiene;
  private String name, species;
  private static final String BAR = "[+]", CAT_FOOD="fish", DOG_FOOD = "kibble", BUNNY_FOOD="carrot", CAT_TOY="toy mouse", DOG_TOY="tennis ball", BUNNY_TOY = "carrot chew stick";
  private static final int MAX=10, MIN=0;

  /////////////////////GETTERS/SETTERS////////////////////

  //name getter
    public String getName (){
      return(name);
    }

  //name setter
    public void setName(String name){
      if (name.trim()!=null){
        this.name = name.toUpperCase();
      }
      else{
        this.name="Buddy";
      }
    }


  //species getter
    public String getSpecies(){
      return(species);
    }

  //species setter
    public void setSpecies(String s){
      s=s.toUpperCase();
      if(s.equalsIgnoreCase(PETS[0]) || s.equalsIgnoreCase(PETS[1]) || s.equalsIgnoreCase(PETS[2]) ){
        species=s;
      }
      else{
        throw new IllegalArgumentException("Invalid Species");
      }

    }

  //get needs (for user file)
  public int getHunger(){
    return(hunger);
  }
  public int getHappiness(){
    return(happiness);
  }
  public int getBladder(){
    return(bladder);
  }
  public int getThirst(){
    return(thirst);
  }
  public int getEnergy(){
    return(energy);
  }
  public int getHygiene(){
    return(hygiene);
  }

  //set needs for user file
  public void setHunger(int h){
    hunger = h;
  }
  public void setHappiness(int h){
    happiness=h;
  }
  public void setBladder(int b){
    bladder=b;
  }
  public void setThirst(int t){
    thirst=t;
  }
  public void setEnergy(int e){
    energy=e;
  }
  public void setHygiene(int h){
    hygiene=h;
  }

   ///////////////////CONSTRUCTORS/////////////////////////

  //default constructor
  public Pet (){
    name = "Buddy";
    species = PETS[0];
    hunger = getRandom();
    happiness=getRandom();
    bladder=getRandom();
    thirst= getRandom();
    energy=getRandom();
    hygiene=getRandom();
  }

  //overloader constructor for new user
  public Pet (String n, String s){
    if (name.trim()!=null){
      this.name = name.toUpperCase();
    }
    else{
      this.name="Buddy";
    }

    hunger = getRandom();
    happiness=getRandom();
    bladder=getRandom();
    thirst= getRandom();
    energy=getRandom();
    hygiene=getRandom();

    s=s.toUpperCase();
    if(s.equalsIgnoreCase(PETS[0]) || s.equalsIgnoreCase(PETS[1]) || s.equalsIgnoreCase(PETS[2]) ){
      species=s;
    }
    else{
      species=PETS[0];
    }
  }



  /////////////////INSTANCE METHODS//////////////////////

  //check if status is maxed
  private boolean isMaxed(int need){
    if(need==MAX){
      return true;
    }
    else{
      return false;
    }
  }

  //check if status is 0
  private void isZero(){
    if(hunger==0){
      System.out.println(name + " is very hungry!");
      happiness=setTo(happiness, -3);
    }
    if(bladder==0){
      System.out.println("Oh No! " + name + " just peed on the floor");
      bladder=MAX;
      hygiene = setTo(hygiene, -3);
      happiness=setTo(happiness, -3);
    }
    if(thirst==0){
      System.out.println(name + " is very thirsty!");
      happiness=setTo(happiness, -3);
    }
    if(happiness==0){
      System.out.println(name + " is feeling sad. Make sure you're looking after their needs");
    }
    if(energy==0){
      clearScreen();
      System.out.println(name + " passed out from exhaustion");
      printImage(4);
      interactionBuffer(10000);
      printImage(0);
      energy=MAX;
      happiness=setTo(happiness, -3);
    }
    if(hygiene==0){
      System.out.println(name + " doesn't smell great. You should give them a bath");
      happiness=setTo(happiness, -3);
    }

  }

  //check where to set need bar
  private int setTo(int need, int incr){
    if((MAX-need)>incr && (need+incr)>=MIN){
      return(need+=incr);
    }
    else if ((need+incr)<MIN){
      return(MIN);
    }
    else{
      return(MAX);
    }
  }

  //create status bars
  public void statusBars(){
    //hunger
    System.out.print("\n|  HUNGER  |");
    for(int i=1; i<=hunger;i++){
      System.out.print(BAR);
    }
    //happiness
    System.out.print("\n| HAPPINESS|");
    for(int i=1; i<=happiness;i++){
      System.out.print(BAR);
    }
    //bladder
    System.out.print("\n|  BLADDER |");
    for(int i=1; i<=bladder;i++){
      System.out.print(BAR);
    }
    //thirst
    System.out.print("\n|  THIRST  |");
    for(int i=1; i<=thirst;i++){
      System.out.print(BAR);
    }
    //energy
    System.out.print("\n|  ENERGY  |");
    for(int i=1; i<=energy;i++){
      System.out.print(BAR);
    }
    //hygiene
    System.out.print("\n|  HYGIENE |");
    for(int i=1; i<=hygiene;i++){
      System.out.print(BAR);
    }
  }

  //play
  public void play(){
    clearScreen();
    happiness= setTo(happiness, 3);
    hunger=setTo(hunger, -1);
    energy= setTo(energy,-2);
    thirst = setTo(thirst, -1);
    bladder= setTo(bladder, -1);
    hygiene = setTo(hygiene, -1);
  }

  //feed
  public void feed(String food){
    if (isMaxed(hunger)){
      clearScreen();
      System.out.println(name + " isn't hungry right now");
    }
    else{

      //check if animal prefers food
      if((species.equalsIgnoreCase(PETS[0]) && food.equalsIgnoreCase(DOG_FOOD)) || (species.equalsIgnoreCase(PETS[1]) && food.equalsIgnoreCase(CAT_FOOD)) ||(species.equalsIgnoreCase(PETS[2]) && food.equalsIgnoreCase(BUNNY_FOOD)) ){
        //prints image
        clearScreen();
        printImage(2);
        interactionBuffer(2000);
        //sets needs
        hunger = setTo(hunger, 3);
        energy = setTo(energy, 1);
        happiness = setTo(happiness, 1);
        bladder = setTo(energy, -1);
        hygiene = setTo(hygiene, -1);
      }
     else{
       clearScreen();
       System.out.println(name + " doesn't seem too interested in eating " + food);
     }
    }

  }

  //water
  public void water(){
    if(isMaxed(thirst)){
      clearScreen();
      System.out.println(name + " isn't thirsty right now");
    }
    else{
      clearScreen();
      printImage(3);
      interactionBuffer(2000);

      thirst = setTo(thirst, 3);
      bladder = setTo(bladder, -2);
    }
  }

  //groom
  public void groom(){
    clearScreen();
    hygiene = setTo(hygiene, 7);
    happiness = setTo(happiness, -1);
  }

  //give toy
  public void giveToy(String toy){

    //checks if pet likes toy
     if((species.equalsIgnoreCase(PETS[0]) && toy.equalsIgnoreCase(DOG_TOY)) || (species.equalsIgnoreCase(PETS[1]) && toy.equalsIgnoreCase(CAT_TOY)) ||(species.equalsIgnoreCase(PETS[2]) && toy.equalsIgnoreCase(BUNNY_TOY)) ){
       //prints image
       clearScreen();
       printImage(1);
       interactionBuffer(2000);
       //sets needs
       happiness= setTo(happiness, 2);
       hunger=setTo(hunger, -1);
       energy= setTo(energy,-1);
       thirst = setTo(thirst, -1);
       bladder= setTo(bladder, -1);
     }
    else{
       clearScreen();
       System.out.println(name + " doesn't seem too interested in playing with a " + toy);
     }
  }

  //potty
  public void potty(){
    if(isMaxed(bladder)){
      clearScreen();
      System.out.println(name + " does not feel like going to the bathroom right now");
    }
    else{
      clearScreen();
      bladder = MAX;
    }
  }

  //sleep
  public void sleep(){
    if(isMaxed(energy)){
      clearScreen();
      System.out.println(name + " does not feel like sleeping right now");
    }
    else{
      clearScreen();
      printImage(4);
      interactionBuffer(4000);
      energy=MAX;
    }
  }

  //prints the pet images
  private void printImage(int x){
    if(species.equals(PETS[0])){
      System.out.println(DOGPIC[x]);
    }
    else if (species.equals(PETS[1])){
      System.out.println(CATPIC[x]);
    }
    else{
      System.out.println(BUNNYPIC[x]);
    }
  }

  ////////////////////////STATIC METHODS/////////////////

  //update status
  public static void clearScreen(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  //pause program for a few seconds
  private static void interactionBuffer(int x){
    try{
      Thread.sleep(x);
    }
    catch(InterruptedException e){
      System.out.println("COULD NOT PAUSE");
    }
    clearScreen();
  }

  //random numbers
  private static int getRandom(){
    int rand = (int)(Math.random()*6)+3;
    return(rand);
  }

  public static void printLogo(){
    System.out.println(
        "  ______  _         _  _   __       _  _    _                   \n" +
        "  |  _  \\(_)       (_)| | / /      (_)| |  | |                  \n" +
        "  | | | | _   __ _  _ | |/ /  _ __  _ | |_ | |_  ___  _ __  ____\n" +
        "  | | | || | / _` || ||    \\ | '__|| || __|| __|/ _ \\| '__||_  /\n" +
        "  | |/ / | || (_| || || |\\  \\| |   | || |_ | |_|  __/| |    / / \n" +
        "  |___/  |_| \\__, ||_|\\_| \\_/|_|   |_| \\__| \\__|\\___||_|   /___|\n" +
        "              __/ |                                             \n" +
        "             |___/                                              \n\n"
    );
  }

  ////////////////////////////////////////////////////
  public String toString(){
    printImage(0);
    System.out.println("----------------------------------------\n\t\t\t" + name.toUpperCase() + "\n----------------------------------------");
    isZero();
    statusBars();
    return("");

  }

}//end class