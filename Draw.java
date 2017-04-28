import java.awt.*;
import javax.swing.JApplet;
import java.util.Scanner;
import java.util.Random;


class Draw extends JApplet{

  //CHANGE THESE NUMBERS ACCORDING TO WINDOW SIZE
  private static double windowYSize = 800;
  private static int windowXSize = 1200;
  private static int lineLength = 0;
  private static Graphics2D page;
  private static Scanner scan = new Scanner(System.in);
  private static boolean isMulti = false;
  private static boolean isPausing = false;
  private static int numJobs = 0;
  private static int onlyCallOnce = 0;
  private static double[] xPositions, yPositions;
  private static int counter = 0;
  private static float colorIncrement = 0;
  private static boolean[] isDone;

  public void paint(Graphics p){
    if (onlyCallOnce == 0){
      page = (Graphics2D)p;
      int width = 10;
      page.setStroke(new BasicStroke(width));
      onlyCallOnce++;
      doMainStuff();
    }
  }

  private static void doMainStuff(){
    isDone = new boolean[numJobs];
    for (int i = 0; i < numJobs; i++){
      isDone[i] = false;
    }
    colorIncrement = 1/(float)(numJobs);
    lineLength = windowXSize/10;
    globalVars.createThreadArray(numJobs);
    for (int i = 0; i < numJobs; i++){
      double yLocation = (800/numJobs * (i+1))-(800/numJobs/2);
      yPositions[i] = yLocation;
    }

    if (isMulti){ //we are multithreading
      //launch threads
      for (int i = 0; i < numJobs; i++){
        String name = Integer.toString(i);
        threadWork R1 = new threadWork(name, isPausing);
        R1.start();
      }
      while (true){
        for (int i = 0; i < numJobs; i++){
          drawLine(i, globalVars.threadProgress[i]);
        }
      }
    } else {
      //we are singlethreading
      for (int i = 0; i < numJobs; i++){
        threadWork.singleThread(i);
      }
    }
    System.out.println();
  }

  public Draw(int numJ, boolean isM, boolean isP){
    numJobs = numJ;
    isMulti = isM;
    isPausing = isP;
    xPositions = new double[numJobs];
    for (int i = 0; i<numJobs; i++){
      xPositions[i] = 0;
    }
    yPositions = new double[numJobs];
  }

    public static void drawLine(int threadNumInt, int drawTo){
      int yLoc = (int)yPositions[threadNumInt];
      page.drawLine(0,yLoc,(drawTo+1) * lineLength,yLoc);
    }
}
