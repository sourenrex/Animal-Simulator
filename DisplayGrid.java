import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
class DisplayGrid { 
  private JFrame frame;
  private int maxX,maxY, GridToScreenRatio;
  private String[][] world;
  //sets up some collors to be used
  Color brown = new Color(109, 69, 8);
  Color green = new Color(67, 140, 56);
  Color white = new Color(255, 255, 255);
  Color red = new Color(255, 0, 0);
  DisplayGrid(String[][] w){ 
    this.world = w;
    maxX = Toolkit.getDefaultToolkit().getScreenSize().width;
    maxY = Toolkit.getDefaultToolkit().getScreenSize().height;
    GridToScreenRatio = maxY / (world.length+1);
    //prints out specs of the map for the user
    System.out.println("Map size: "+world.length+" by "+world[0].length + "\nScreen size: "+ maxX +"x"+maxY+ " Ratio: " + GridToScreenRatio);
    this.frame = new JFrame("Map of World");
    GridAreaPanel worldPanel = new GridAreaPanel();
    frame.getContentPane().add(BorderLayout.CENTER, worldPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    frame.setVisible(true);
  }
  public void refresh() { 
    frame.repaint();
  }
  //where the graphics are shown
  class GridAreaPanel extends JPanel {
    //private BufferedImage sheep;
    public void paintComponent(Graphics g) {
      //imports images for all living things
      //try {                
       //   sheep = ImageIO.read(new File("sheep.png"));
       //} catch (IOException ex) {
       //}  
      Image sheep = Toolkit.getDefaultToolkit().getImage("sheep.png");
      Image wolf = Toolkit.getDefaultToolkit().getImage("wolf.png");
      Image grass = Toolkit.getDefaultToolkit().getImage("grass1.png");
      setDoubleBuffered(true); 
      g.setColor(Color.BLACK);
      for(int i = 0; i<world[0].length;i=i+1){ 
        for(int j = 0; j<world.length;j=j+1) {
          //prints a color for the ground
          if (world[i][j].equals(".")){
            //if it is winter ground is brown
            if (EcoSystem.getSeasonNumber()==4){
              g.setColor(brown);
            }else{
              //if it is any other season ground is green
              g.setColor(green);
            }
            g.fillRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
            g.setColor(Color.BLACK);
            g.drawRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
          }else if (world[i][j].equals("2")){
            //if it is winter ground is brown
            if (EcoSystem.getSeasonNumber()==4){
              g.setColor(brown);
            }else{
              //if it is any other season ground is green
              g.setColor(green);
            }
            g.fillRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
            g.setColor(Color.BLACK);
            g.drawRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
            //print image of a sheep
            g.drawImage(sheep,j*GridToScreenRatio,i*GridToScreenRatio,GridToScreenRatio,GridToScreenRatio,this);
            
          }
          else if (world[i][j].equals("3")){
            //if it is winter ground is brown
            if (EcoSystem.getSeasonNumber()==4){
              g.setColor(brown);
            }else{
              //if it is any other season ground is green
              g.setColor(green);
            }
            g.fillRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
            g.setColor(Color.BLACK);
            g.drawRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
            //print image of a wolf
            g.drawImage(wolf,j*GridToScreenRatio,i*GridToScreenRatio,GridToScreenRatio,GridToScreenRatio,this);
          }else{
            //if it is winter ground is brown
            if (EcoSystem.getSeasonNumber()==4){
              g.setColor(brown);
            }else{
              //if it is any other season ground is green
              g.setColor(green);
            }
            g.fillRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
            g.setColor(Color.BLACK);
            g.drawRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
            //print image of grass
            g.drawImage(grass,j*GridToScreenRatio,i*GridToScreenRatio,GridToScreenRatio,GridToScreenRatio,this);
          }
          //text at side of the screen for user
          g.setFont(new Font("Calibri",Font.PLAIN, 20));
          //shows what season it is
          g.drawString("The season is " + EcoSystem.getSeason(),1200,700);
          //shows the year/turn
          g.drawString("The year is " + EcoSystem.getTurn(),1200,500);
          //shows amount of sheep
          g.drawString("The amount of sheep " + EcoSystem.sheep(),1200,200);
          //shows amount of wolves
          g.drawString("The amount of wolf  " + EcoSystem.wolf(),1200,300);
        }
      }
    }
  }//end of GridAreaPanel
  
} //end of DisplayGrid

