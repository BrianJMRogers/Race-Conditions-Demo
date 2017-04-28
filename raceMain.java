//YAO
import javax.swing.*;
import java.util.Scanner;

class raceMain{
  private static boolean isMulti = false;
  private static boolean isPausing = false;
  private static int numJobs = 0;
  private static Scanner scan = new Scanner(System.in);

  public static void main (String[] yao){

    String param = "";

    if (yao.length == 0){
      System.out.println("Missing parameter: -s, -m, or -mp");
      System.exit(0);
    } else {
      param = yao[0];
    }

    if (param.equals("-s")){
      //single threading
      //don't need to do anything since isMulti is defined as false
    } else if (param.equals("-m")){
      //change isMulti to true for future use
      isMulti = true;
    } if (param.equals("-mp")){
      //change isPausing to true for future use
      isMulti = true;
      isPausing = true;
    }

    //how many jobs?
    System.out.print("How many jobs would you like to execute with ");
    numJobs = scan.nextInt();
    System.out.println("All right lets roll the visual");
    JFrame window = new JFrame(" Bick and Nrian ");
    window.getContentPane().add(new Draw(numJobs, isMulti, isPausing));
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
    window.setSize(1200, 800);
  }
}
