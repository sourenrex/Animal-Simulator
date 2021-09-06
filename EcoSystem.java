/*
 * EcoSystem
 *  Main program that takes in all classes to allow ecosystem to funciton
 * Souren Amini
 * May, 4, 2019
 */

/* Extra stuff added:
 * Added Sheep gender, sheep will only breed with other gender
 * Added Wolf Gender, wolves will only breed with other gender
 * Parents will keep breeding as long as they have ample food, mimicking how animals will breed large broods of children if there is a lot of food
 * Children will not breed instantly, need food to gain health first to mimick growing up and strong to breed
 * Children will spawn away from wolves in a safe spot, mimcking mothers finding a safe area for children
 * Sheep and wolves are somewhat dumb, however sheep will no commit suicide and will go the opisate direction in face of a wolf
 * Seasons have been added: game starts in summer with a 50% chance to have food spawn. Other seasons have diffrent food spawns, spring being the most, winter being 0.
 * Plants will spawn depending on season to make a sustainable eco-system
 * Graphics have been added
 * Sheep have a sheep image
 * wolves have a wolf image
 * grass have an image
 * Also ground and area will change color in winter, mimicking lack of food spawning then.
 * Season and description displayed on right
 * Turn displayed on right
 * Sheep count and wolf count displayed on right
 * Smart fighting, winning wolf will no longer lose so much health to loser, only little
 * Health cap has been added for realism
 * Music added for a calming experience
 * Sheep genes have been added to the code in which some sheep carry a blue gene while others carry white gene,(Been comented out as no way to rep it graphically)
 */



import java.util.Scanner;
import java.io.*;
//import sun.audio.*;

abstract class EcoSystem{
  //Public variables to be used in display grid
  public static String seasonName="Summer, 50% chance for food to spawn";
  public static int realTurn=0;
  public static int season=2;
  public static int amountOfSheep=18;
  public static int amountOfWolf=2;
  public static void main (String[] args) throws Exception{
      System.out.print("working)");
    //music to play calm sounds
    //String soundFile = "sound.au";
    //InputStream in = new FileInputStream(soundFile);
    //AudioStream audioStream = new AudioStream(in);
    //AudioPlayer.player.start(audioStream);
    int turn=0;
    int x=0;
    int y=0;
    int z=0;
    int sheepX=0;
    int sheepY=0;
    int wolfX=0;
    int wolfY=0;
    int ySheepPos=0;
    int xSheepPos=0;
    int ySheepPos2=0;
    int xSheepPos2=0;
    int yWolfPos=0;
    int xWolfPos=0;
    int randomSpawnX=0;
    int randomSpawnY=0;
    int sheepSex=0;
    int sheepSex2=0;
    int wolfSex=0;
    int wolfSex2=0;
    
//    int sheepGene=0;
//    int sheepGene2=0;
//    int randomGene=0;
//    
    boolean tryAgain=true;
    //Asks for amount of plants to be spawned in
    Scanner choice= new Scanner(System.in);
    System.out.print("How many plants(recomended 100 plants)");
    int plantNumber= choice.nextInt();
    //creates plants and world
    Plants p1= new Plants(20);
    Sheep p2= new Sheep(0,0);
    Animals p3 = new Animals ();
    String[][] world = new String[25][25];
    
    //fills empty world
    Animals[ ] animals = new Animals[100];
    for (int i=0; i<25; i++){
      for (int j=0; j<25; j++){
        world [j][i]=".";
      }
    }
    System.out.print("\n");
    //spawn plants
    for (int i=0; i<plantNumber; i++){
      int xPlantPos= p1.spawnPlantsX();
      int yPlantPos= p1.spawnPlantsY();
      world[yPlantPos][xPlantPos]="1";
    }
    // put sheep in animal array
    for (int i=0; i<18; i++){
      animals[i]= new Sheep(0,0);
    }
    //put wolves in animal array
    for (int i=18; i<20; i++){
      animals[i]= new Wolf(0,0);
    }
    // spawn sheep and wolves into world, give them gender
    System.out.print ("\n");
    while (animals[x]!=null){
      if(animals[x] instanceof Sheep){
        ((Sheep)animals[x]).spawnSheepY();
        ((Sheep)animals[x]).spawnSheepX();
        ySheepPos=(((Sheep)animals[x]).getSheepY());
        xSheepPos=(((Sheep)animals[x]).getSheepX());
        world[ySheepPos][xSheepPos]="2";
        ((Sheep)animals[x]).setSheepSex();
//      ((Sheep)animals[x]).setSheepGene=((int)(Math.random()* 2));
      }else{
        ((Wolf)animals[x]).spawnWolfY();
        ((Wolf)animals[x]).spawnWolfX();
        yWolfPos=(((Wolf)animals[x]).getWolfY());
        xWolfPos=(((Wolf)animals[x]).getWolfX());
        world[yWolfPos][xWolfPos]="3";
        ((Wolf)animals[x]).setWolfSex();
      }x++;
    }x=0;
    //Main program responsible for movement, breeding, death, etc.
    DisplayGrid grid = new DisplayGrid(world);
    choice.close();
    //will loop as long as an animal is alive in the array
    while (animals[0]!=null){
      turn++;
      realTurn++;
      x=0;
      //changes spawn rate of plants depending on season
      if (season==2){
        int moveXY=((int)(Math.random()* 2));
        if (moveXY==0){
          for (int i=0; i<10; i++){
            int xPlantPos= p1.spawnPlantsX();
            int yPlantPos= p1.spawnPlantsY();
            world[yPlantPos][xPlantPos]="1";
          }
        }
      }else if (season==3){
        int moveXY=((int)(Math.random()* 4));
        if (moveXY==0){
          for (int i=0; i<10; i++){
            int xPlantPos= p1.spawnPlantsX();
            int yPlantPos= p1.spawnPlantsY();
            world[yPlantPos][xPlantPos]="1";
          }
        }
      }else if (season==4){
        int moveXY=((int)(Math.random()* 100));
        if (moveXY==0){
          for (int i=0; i<10; i++){
            int xPlantPos= p1.spawnPlantsX();
            int yPlantPos= p1.spawnPlantsY();
            world[yPlantPos][xPlantPos]="1";
          }
        }
      }else if (season==1){
        int moveXY=((int)(Math.random()* 1));
        if (moveXY==0){
          for (int i=0; i<10; i++){
            int xPlantPos= p1.spawnPlantsX();
            int yPlantPos= p1.spawnPlantsY();
            world[yPlantPos][xPlantPos]="1";
          }
        }
      }
      //will loop through every sheep and wolf in array allowing them to move, breed, kill, etc.
      while (animals[x]!=null){
        //will pick randomly whether to go on the y axis or x axis
        int moveXY=((int)(Math.random()* 2));
        //check if its a sheep
        if (animals[x] instanceof Sheep){
          //x axis
          if (moveXY==0){
            tryAgain=true;
            //will get positions of sheep
            while(tryAgain == true){
              ySheepPos=(((Sheep)animals[x]).getSheepY());
              xSheepPos=(((Sheep)animals[x]).getSheepX());
              //randomly pick whether it will move forward or backward
              sheepX=p2.move();
              //make sure sheep does not move out of boundries
              if(xSheepPos+sheepX<25 && xSheepPos+sheepX>-1){
                //make sure sheeo doesnt kill it self on a wolf while moving
                if (world [ySheepPos][xSheepPos+sheepX]!="3"){
                  //check if sheep is going to breed with another sheep, will breed when they want to go to the same spot
                  if (world [ySheepPos][xSheepPos+sheepX]=="2"){
                    tryAgain=false;
                    y=0;
                    //get gender and pos of both sheep
                    for (int i=0; i<100; i++){
                      if (animals[y] instanceof Sheep){
                      ySheepPos2=((Sheep)animals[y]).getSheepY();
                      xSheepPos2=((Sheep)animals[y]).getSheepX();
                      sheepSex=((Sheep)animals[x]).getSheepSex();
                      sheepSex2=((Sheep)animals[y]).getSheepSex();
                      //sheepGene=((Sheep)animals[x]).getSheepGene();
                     // sheepGene2=((Sheep)animals[y]).getSheepGene();
                      }
                      //checks which sheep the sheep of focus is breeding with, checks also if it has enough life to breed
                      if (animals[y] instanceof Sheep && ySheepPos==ySheepPos2 && xSheepPos+sheepX==xSheepPos2 && animals[x].getLife()>20 && animals[y].getLife()>20 && sheepSex!=sheepSex2){
                        i+=100;
                        //lowers life of both sheep while breeding
                        animals[x].setLife(-10);
                        animals[y].setLife(-10);
                        y=0;
                        //find empty spot for new sheep
                        while (animals[y] != null){
                          y++;
                        }
                        //increase amount of sheep alive on counter
                        amountOfSheep++;
                        //random safe spot for sheep
                        randomSpawnX=((int)(Math.random()* 25));
                        randomSpawnY=((int)(Math.random()* 25));
                        while (world[randomSpawnY][randomSpawnX]=="2"&& world[randomSpawnY][randomSpawnX]=="3"){
                          randomSpawnX=((int)(Math.random()* 25));
                          randomSpawnY=((int)(Math.random()* 25)); 
                        }
                        //spawns new weak sheep
                        animals[y]= new Sheep(randomSpawnY,randomSpawnX);
                        animals[y].setLife(-20);
                        //genes NOT ADDED
//                        if (sheepGene==0 && sheepGene2==0){
//                          ((Sheep)animals[y]).setSheepGene(0);
//                        }else if(sheepGene==1 && sheepGene2==1){
//                          ((Sheep)animals[y]).setSheepGene(1);
//                        }else{
//                          randomGene=((int)(Math.random()* 3))
//                          if(randomGene==3){
//                            ((Sheep)animals[y]).setSheepGene(1);
//                          }
//                          else{
//                            ((Sheep)animals[y]).setSheepGene(0);
//                          }
//                        }
                      }y++;
                    }
                  }else{
                    //moves sheep on the x axis
                    world[(((Sheep)animals[x]).getSheepY())][(((Sheep)animals[x]).getSheepX())]=".";
                    ((Sheep)animals[x]).setSheepX(sheepX);
                    // if sheep lands on grass it will gain life and eat the grass
                    if(world[(((Sheep)animals[x]).getSheepY())][(((Sheep)animals[x]).getSheepX())]=="1"){
                      animals[x].setLife(p1.getLife());
                    }
                    world[(((Sheep)animals[x]).getSheepY())][(((Sheep)animals[x]).getSheepX())]="2";
                    tryAgain=false;
                  }
                }else{
                  //if there is no safe place for the sheep to go it will not move
                  tryAgain=false;
                }
              }tryAgain=false;
            }
          }else{
            //move sheep on the y axis
            tryAgain=true;
            // get sheep pos
            while(tryAgain == true){
              ySheepPos=(((Sheep)animals[x]).getSheepY());
              xSheepPos=(((Sheep)animals[x]).getSheepX());
              sheepY=p2.move();
              //check if sheep will not leave boundries
              if(ySheepPos+sheepY<25 && ySheepPos+sheepY>-1 ){
                //make sure sheep wont kill themselves  on a wolf
                if (world [ySheepPos+sheepY][xSheepPos]!="3"){
                  //check if sheep are breeding, they breed when they want to go to the same spot
                  if (world [ySheepPos+sheepY][xSheepPos]=="2"){
                    tryAgain=false;
                    y=0;
                    for (int i=0; i<100; i++){
                      //get pos and gender of sheep
                      if (animals[y] instanceof Sheep ){
                      ySheepPos2=((Sheep)animals[y]).getSheepY();
                      xSheepPos2=((Sheep)animals[y]).getSheepX();
                      sheepSex=((Sheep)animals[x]).getSheepSex();
                      sheepSex2=((Sheep)animals[y]).getSheepSex();
                      //sheepGene=((Sheep)animals[x]).getSheepGene();
                      //sheepGene2=((Sheep)animals[y]).getSheepGene();
                      }
                      //checks which sheep the sheep of focus is breeding with, checks also if it has enough life to breed
                      if (animals[y] instanceof Sheep && ySheepPos+sheepY==ySheepPos2 && xSheepPos==ySheepPos2 && animals[x].getLife()>20 && animals[y].getLife()>20 && sheepSex!=sheepSex2){
                        //parents lose life
                        animals[x].setLife(-10);
                        animals[y].setLife(-10);
                        y=0;
                        //finds empty spot to put sheep on array
                        while (animals[y] != null){
                          y++;
                        }
                        amountOfSheep++;
                        //sheep will spawn in empty location
                        randomSpawnX=((int)(Math.random()* 25));
                        randomSpawnY=((int)(Math.random()* 25));
                        while (world[randomSpawnY][randomSpawnX]=="2"&& world[randomSpawnY][randomSpawnX]=="3"){
                          randomSpawnX=((int)(Math.random()* 25));
                          randomSpawnY=((int)(Math.random()* 25));
                        }
                        animals[y]= new Sheep(randomSpawnY,randomSpawnX);
                        animals[y].setLife(-20);
                        i+=100;
                        //Genes commented out
//                        if (sheepGene==0 && sheepGene2==0){
//                          ((Sheep)animals[y]).setSheepGene(0);
//                        }else if(sheepGene==1 && sheepGene2==1){
//                          ((Sheep)animals[y]).setSheepGene(1);
//                        }else{
//                          randomGene=((int)(Math.random()* 3))
//                          if(randomGene==3){
//                            ((Sheep)animals[y]).setSheepGene(1);
//                          }
//                          else{
//                            ((Sheep)animals[y]).setSheepGene(0);
//                          }
//                        }
                      }y++;
                    }
                  }else{
                    //sheep will move on y axis
                    world[(((Sheep)animals[x]).getSheepY())][(((Sheep)animals[x]).getSheepX())]=".";
                    ((Sheep)animals[x]).setSheepY(sheepY);
                    //sheep will eat plants gaining its life
                    if(world[(((Sheep)animals[x]).getSheepY())][(((Sheep)animals[x]).getSheepX())]=="1"){
                      animals[x].setLife(p1.getLife());
                    }
                    world[(((Sheep)animals[x]).getSheepY())][(((Sheep)animals[x]).getSheepX())]="2";
                    tryAgain=false;
                  }
                }else{
                  //sheep will not move if no safe spot to move to
                  tryAgain=false;
                }
              }tryAgain=false;
            }
          }
          //sheep will lose a life every year(aka one turn or one movement of all animals)
          ((Sheep)animals[x]).setLife(-1);
          //will kill any sheep bellow 0 life
          if  (((Sheep)animals[x]).getLife()<0){
            world[(((Sheep)animals[x]).getSheepY())][(((Sheep)animals[x]).getSheepX())]=".";
            animals[x]=null;
            amountOfSheep--;
            y=x;
            // will move all animals down one in array to make sure no empty null spots
            while (animals[y]==null && animals[y+1]!=null){
              animals[y]=animals[y+1];
              animals[y+1]=null;
              y+=1;
            }
          }
        }else{
          //move the wolves on x axis
          if (moveXY==0){
            tryAgain = true;
            while(tryAgain == true){
              //get wolf pos
              yWolfPos=(((Wolf)animals[x]).getWolfY());
              xWolfPos=(((Wolf)animals[x]).getWolfX());
              wolfX=p2.move();
              //wolves will move in boundries
              if(xWolfPos+wolfX<25 && xWolfPos+wolfX>-1){
                // check if wolf wants to move onto sheep pos to eat it
                if (world [yWolfPos][xWolfPos+wolfX]=="2"){
                  tryAgain=false;
                  y=0;
                  for (int i=0; i<100; i++){
                    //will find sheep that is being eaten
                    if (animals[y] instanceof Sheep && yWolfPos==((Sheep)animals[y]).getSheepY()&& xWolfPos+wolfX==((Sheep)animals[y]).getSheepX()){          
                      z=y;
                      // sheep
                      animals[x].setLife(animals[y].getLife());
                      animals[y]=null;
                      amountOfSheep--;
                      //if sheep was earlier on the array, will subtract one from which animal we are moving on the list as to compinsate for moving all animals down one
                      if (y<x){
                        x-=1;
                      }
                      //move everything down one to fill empty spot
                      while (animals[z]==null && animals[z+1]!=null){
                        animals[z]=animals[z+1];
                        animals[z+1]=null;
                        z+=1;
                      }y=0;
                      i+=100;
                    } y++;
                  }
                }else if (world [yWolfPos][xWolfPos+wolfX]=="3"){
                  //checks if wolf wants to go to another postion of a wolf
                  tryAgain=false;
                  y=0;
                  for (int i=0; i<100; i++){
                    if (animals[y] instanceof Wolf ){
                      wolfSex=((Wolf)animals[x]).getWolfSex();
                      wolfSex2=((Wolf)animals[y]).getWolfSex();
                    }
                    //finds the correct wolf that wants to breed or fight
                    if (animals[y] instanceof Wolf && yWolfPos==((Wolf)animals[y]).getWolfY()&& xWolfPos+wolfX==((Wolf)animals[y]).getWolfX()){
                      //if wolves have diffrent genders they will breed
                      if(wolfSex!=wolfSex2){
                        amountOfWolf++;
                        animals[x].setLife(-10);
                        animals[y].setLife(-10);
                        y=0;
                        while (animals[y] != null){
                          y++;
                        }
                        //spawn wolf in random location
                        randomSpawnX=((int)(Math.random()* 25));
                        randomSpawnY=((int)(Math.random()* 25));
                        while (world[randomSpawnY][randomSpawnX]=="2"&& world[randomSpawnY][randomSpawnX]=="3"){
                          randomSpawnX=((int)(Math.random()* 25));
                          randomSpawnY=((int)(Math.random()* 25));
                        }
                        animals[y]= new Wolf(randomSpawnY,randomSpawnX);
                        animals[y].setLife(-20);
                      }else{
                        //wolves will fight in which 3 outcomes are possible (uses compareTo)
                        if (((Wolf)animals[y]).compareTo(((Wolf)animals[y]))==1){
                          //this wolf has more healh therefore kills the other
                          z=y;
                          ((Wolf)animals[x]).setLife(-10);
                          if (y<x){
                            x-=1;
                          }
                          animals[y]=null;
                          amountOfWolf--;
                          while (animals[z]==null && animals[z+1]!=null){
                            animals[z]=animals[z+1];
                            animals[z+1]=null;
                            z+=1;
                          }
                        }else if (((Wolf)animals[y]).compareTo(((Wolf)animals[y]))==-1){
                          //the other wolf has more health, therefore this wolf dies
                          z=x;
                          ((Wolf)animals[y]).setLife(-10);
                          animals[x]=null;
                          amountOfWolf--;
                          while (animals[z]==null && animals[z+1]!=null){
                            animals[z]=animals[z+1];
                            animals[z+1]=null;
                            z+=1;
                          }
                          x-=1;
                        }else if (((Wolf)animals[y]).compareTo((Wolf)animals[y])==0){
                          //wolves tie in which they damage each other and back off
                          ((Wolf)animals[y]).setLife(-10);
                          ((Wolf)animals[x]).setLife(-10);
                        }
                      }y=0;
                      i+=100;
                    }y++;
                  }
                }
                //wolf will move on the x axis
                world[(((Wolf)animals[x]).getWolfY())][(((Wolf)animals[x]).getWolfX())]=".";
                ((Wolf)animals[x]).setWolfX(wolfX);
                world[(((Wolf)animals[x]).getWolfY())][(((Wolf)animals[x]).getWolfX())]="3";
                tryAgain=false;
              }
            }tryAgain=true;
          }else{
            tryAgain = true;
            while(tryAgain == true){
              //wolf will move on y axis
              yWolfPos=(((Wolf)animals[x]).getWolfY());
              xWolfPos=(((Wolf)animals[x]).getWolfX());
              wolfY=p2.move();
              //check if wolf is moving in boundries
              if(yWolfPos+wolfY<25 && yWolfPos+wolfY>-1){
                //eating a sheep
                if (world [yWolfPos+wolfY][xWolfPos]=="2"){
                  tryAgain=false;
                  y=0;
                  for (int i=0; i<100; i++){
                    //check which sheep the wolf is eating 
                    if (animals[y] instanceof Sheep && yWolfPos+wolfY==((Sheep)animals[y]).getSheepY()&& xWolfPos==((Sheep)animals[y]).getSheepX()){          
                      z=y;
                      //increase wolf's life equal to its prey
                      animals[x].setLife(animals[y].getLife());
                      animals[y]=null;
                      amountOfSheep--;
                      if (y<x){
                        x-=1;
                      }
                      //move everything down to fill empty spot in array
                      while (animals[z]==null && animals[z+1]!=null){
                        animals[z]=animals[z+1];
                        animals[z+1]=null;
                        z+=1;
                      }
                      y=0;
                      i+=100;
                    }y++;
                  }
                }else if (world [yWolfPos+wolfY][xWolfPos]=="3"){
                  //check if wolves want to breed or fight
                  tryAgain=false;
                  y=0;
                  for (int i=0; i<100; i++){
                    if (animals[y] instanceof Wolf ){
                      wolfSex=((Wolf)animals[x]).getWolfSex();
                      wolfSex2=((Wolf)animals[y]).getWolfSex();
                    }
                    //finds which is the other wolf that this wolf is stepping on
                    if (animals[y] instanceof Wolf && yWolfPos+wolfY==((Wolf)animals[y]).getWolfY()&& xWolfPos==((Wolf)animals[y]).getWolfX()){
                      //if both wolves are diffrent genders they will mate
                      if(wolfSex!=wolfSex2){
                        amountOfWolf++;
                        animals[x].setLife(-10);
                        animals[y].setLife(-10);
                        y=0;
                        while (animals[y] != null){
                          y++;
                        }
                        //spawn new wolf in random location
                        randomSpawnX=((int)(Math.random()* 25));
                        randomSpawnY=((int)(Math.random()* 25));
                        while (world[randomSpawnY][randomSpawnX]=="2"&& world[randomSpawnY][randomSpawnX]=="3"){
                          randomSpawnX=((int)(Math.random()* 25));
                          randomSpawnY=((int)(Math.random()* 25));
                        }
                        animals[y]= new Wolf(randomSpawnY,randomSpawnX);
                        animals[y].setLife(-20);
                      }else{
                        //wolves will fight in which 3 outcomes are possible (uses compareTo)
                        if (((Wolf)animals[y]).compareTo((Wolf)animals[y])==1){
                          //this wolf has more healh therefore kills the other
                          z=y;
                          ((Wolf)animals[x]).setLife(-10);
                          if (y<x){
                            x-=1;
                          }
                          animals[y]=null;
                          amountOfWolf--;
                          while (animals[z]==null && animals[z+1]!=null){
                            animals[z]=animals[z+1];
                            animals[z+1]=null;
                            z+=1;
                          }
                        }
                        else if (((Wolf)animals[y]).compareTo((Wolf)animals[y])==-1){
                          //this wolf has less healh therefore dies to the other
                          z=x;
                          ((Wolf)animals[y]).setLife(-10);
                          animals[x]=null;
                          amountOfWolf--;
                          while (animals[z]==null && animals[z+1]!=null){
                            animals[z]=animals[z+1];
                            animals[z+1]=null;
                            z+=1;
                          }
                          x-=1;
                        }
                        else if (((Wolf)animals[y]).compareTo((Wolf)animals[y])==0){
                          //they tie, damaging each other then backing off
                          ((Wolf)animals[y]).setLife(-10);
                          ((Wolf)animals[x]).setLife(-10);
                        }
                      }y=0;
                      i+=100;
                    }y++;
                  }
                }
                //wolf will moce on the y axis
                world[(((Wolf)animals[x]).getWolfY())][(((Wolf)animals[x]).getWolfX())]=".";
                ((Wolf)animals[x]).setWolfY(wolfY);
                world[(((Wolf)animals[x]).getWolfY())][(((Wolf)animals[x]).getWolfX())]="3";
                tryAgain=false;
              }
            }tryAgain=true;
          }
          //wolves lose one life every turn/year/movement
          ((Wolf)animals[x]).setLife(-1);
          //kills any wolves whose life value is less than 0
          if (((Wolf)animals[x]).getLife()<0){
            world[(((Wolf)animals[x]).getWolfY())][(((Wolf)animals[x]).getWolfX())]=".";
            animals[x]=null;
            amountOfWolf--;
            y=x;
            //move everything down one on the array to fill empty spot if wolf dies
            while (animals[y]==null && animals[y+1]!=null){
              animals[y]=animals[y+1];
              animals[y+1]=null;
              y+=1;
            }
          }
        }x++;
      }
      //fps of the screen, how fast the program updates its screen
      grid.refresh();
      try{ Thread.sleep(300); }catch(Exception e) {};
      //changes the season every 25 turns
      if (turn==25){
        season=3;
        seasonName="Fall, 25% chance for food to spawn";
      }else if (turn==50){
        season=4;
        seasonName="Winter, 1% chance for food to spawn, SURVIVE";
      }else if (turn==75){
        season =1;
        seasonName="Spring, 100% chance for food to spawn";
      }else if (turn==100){
        season =2;
        seasonName="Summer, 50% chance for food to spawn";
        turn =0;
      }
    }
  }
  /**
    * method used to return the map of the world to be used in the DisplayGrid class to show the map
    * @param world the 2d array of the world filled with wolves, sheep, and plants
    * @return world 2d array of the world/map
    */
  public String [][] worldMap(String[][] world){
    return world;
  }
  /**
    * method used to return String season the game is at
    * @return seasonName name and description of season game is at
    */
  public static String getSeason(){
    return seasonName;
  }
  /**
    * method used to return int season the game is at
    * @return season the actual season to be used for graphical changes
    */
  public static int getSeasonNumber(){
    return season;
  }
  /**
    * method used to return int turn/year game is at
    * @return realTurn the int turn the game is at, updating every time every animal has moved
    */
  public static int getTurn(){
    return realTurn;
  }
  /**
    * method used to return int amount of sheep alive
    * @return amountOfSheep the int number of sheep alive
    */
  public static int sheep(){
    return amountOfSheep;
  }
  /**
    * method used to return int amount of wolves alive
    * @return amountOfWolf the int number of wolves alive
    */
  public static int wolf(){
    return amountOfWolf;
  }
}