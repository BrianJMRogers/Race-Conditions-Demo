public class globalVars{
  public static int threadToGo = 0;
  public static int[] threadProgress;
  public static void increment(){
    threadToGo++;
  }
  public static void createThreadArray(int threadNum){
    threadProgress = new int[threadNum];
  }
  public static void incrementThreadProgress(int threadNum){
    int currentProgress = threadProgress[threadNum];
    threadProgress[threadNum] = currentProgress+1;
  }
}
