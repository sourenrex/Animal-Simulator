class Sheep extends Animals{
  private int x=0;
  private int y=0;
  private int moveX=0;
  private int moveY=0;
  private int sex=0;
  private int gene=0;
  
  /**
    * constructer used to set the x,y value
    * @param moveX sets the x value of sheep
    * @param moveY sets the y value of sheep
    */
  public Sheep(int moveX, int moveY){
    this.moveX=moveX;
    this.moveY=moveY;
  }
  /**
    * method used to set the a random x value to the sheep spawning
    */
  public void spawnSheepX(){
    this.x=((int)(Math.random()* 25));
  }
  /**
    * method used to set the a random y value to the sheep spawning
    */
  public void spawnSheepY(){
    this.y=((int)(Math.random()* 25));
  }
  /**
    * method used to update the sheep's x value
    * @param moveX how much the sheep will move
    */
  public void setSheepX(int moveX){
    this.x=x+moveX;
  }
  /**
    * method used to update the sheep's y value
    * @param moveY how much the sheep will move
    */
  public void setSheepY(int moveY){
    this.y=y+moveY;
  }
  /**
    * method used to return sheep's x value
    * @return x value of sheep's position
    */
  public int getSheepX(){
    return x;
  }
  /**
    * method used to return sheep's y value
    * @return y value of sheep's position
    */
  public int getSheepY(){
    return y;
  }
  /**
    * method used to set a random sex to the sheep
    */
  public void setSheepSex(){
    this.sex=((int)(Math.random()* 2));;
  }
  /**
    * method used to get the sheep'ss sex
    * @return sex of sheep
    */
  public int getSheepSex(){
    return sex;
  }
  
//  public void setSheepGene(int gene){
//    this.gene=gene;
//  }
//  
//  public int getSheepGene(){
//    return gene;
//  }
}