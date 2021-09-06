class Wolf extends Animals {
  private int x=0;
  private int y=0;
  private int moveX=0;
  private int moveY=0;
  private int sex=0;
  /**
    * constructer used to set the x,y value
    * @param moveX sets the x value of wolf
    * @param moveY sets the y value of wolf
    */
  public Wolf(int moveX, int moveY){
    this.moveX=moveX;
    this.moveY=moveY;
  }
  /**
    * method used to set the a random x value to the wolf spawning
    */
  public void spawnWolfX(){
    this.x=((int)(Math.random()* 25));
  }
  /**
    * method used to set the a random y value to the wolf spawning
    */
  public void spawnWolfY(){
    this.y=((int)(Math.random()* 25));
  }
  /**
    * method used to update the wolf's x value
    * @param moveX how much the wolf will move
    */
  public void setWolfX(int moveX){
    this.x=x+moveX;
  }
  /**
    * method used to update the wolf's y value
    * @param moveY how much the wolf will move
    */
  public void setWolfY(int moveY){
    this.y=y+moveY;
  }
  /**
    * method used to return wofl's x value
    * @return x value of wolf's position
    */
  public int getWolfX(){
    return x;
  }
   /**
    * method used to return wolf's y value
    * @return y value of wolf's position
    */
  public int getWolfY(){
    return y;
  }
  /**
    * method used to set a random sex to the wolf
    */
  public void setWolfSex(){
    this.sex=((int)(Math.random()* 2));;
  }
  /**
    * method used to get the wolf's sex
    * @return sex of wolf
    */
  public int getWolfSex(){
    return sex;
  }
//  public void setLife(int health){
//    this.life+=health;
//    if (life>100){
//      this.life=100;
//    }
//  }
}