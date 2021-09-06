class Animals implements Comparable <Wolf>{
  //all animals start at
  private int life =50;
  /**
    * method used to return int turn/year game is at
    * @return move the int direction the animal will go, whether it be up, down, forward, or backwards
    */
  public int move(){
    int move=0;
    int animalRandom=((int)(Math.random()* 2));
    if (animalRandom==0){
      return move=-1;
    }else{
      return move=+1;
    }
  }
  /**
    * method used to set the life or change the life of all animals and cap it at 300
    * @param health int value of how much health will be gained or loss
    */
  public void setLife(int health){
    this.life+=health;
    if (life>300){
      this.life=300;
    }
  }
  /**
    * method used to return int life the animal has
    * @return life the amount of life the animal has
    */
  public int getLife(){
    return this.life;
  }
  /**
    * method used to compare which wolf has a higher health value and will win the fight, uses compare to
    * @param object fightWolf is the other wolf that will be compared to this one
    * @return whether this wolf has a higher or lower health value
    */
  public int compareTo(Wolf fightWolf){
    if (this.life>fightWolf.getLife()){
      return 1;
    }else if (this.life==fightWolf.getLife()){
      return 0;
    }else{
      return -1;
    }
  }
}