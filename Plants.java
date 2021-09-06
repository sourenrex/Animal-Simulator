class Plants {
  private int life=0;
  private int x=0;
  private int y=0;
  /**
    * method used to set the life of all plants
    * @param the life the plants all have
    */
  public Plants(int life){
    this.life=life;
  }
  /**
    * method used to randomly chose where the x spawn value of the plant value will be
    * @return the x value of where the plant will spawn
    */
  public int spawnPlantsX(){
   return x=((int)(Math.random()* 25));
  }
  /**
    * method used to randomly chose where the y spawn value of the plant value will be
    * @return the y value of where the plant will spawn
    */
  public int spawnPlantsY(){
    return y=((int)(Math.random()* 25));
  }
  /**
    * method used to return the life of the plant
    * @return the life int value of the plants life
    */
  public int getLife(){
    return life;
  }
}