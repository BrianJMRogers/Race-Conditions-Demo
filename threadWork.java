import java.util.Random;

class threadWork implements Runnable {
   public Thread t;
   private static int threadNumInt;
   private static String threadNumString;
   private static int counter = 0;
   private static boolean isPausing = false;
   private Random ran = new Random();

   threadWork(String n, boolean pausing) {
     this.threadNumString = n;
     threadNumInt = Integer.parseInt(n);
     isPausing = pausing;
   }

   public void run() {
     if (isPausing){
       gunnaWait();
     } else {
       notGunnaWait();
     }
   }

   public void gunnaWait(){
     call(true);
     while (globalVars.threadToGo != Integer.parseInt(Thread.currentThread().getName())){
       /* this holds the threads */
     }
     globalVars.increment();
     globalVars.incrementThreadProgress(Integer.parseInt(Thread.currentThread().getName()));
   }

   public void notGunnaWait(){
     call(false);
   }

   public void start () {
      if (t == null) {
         t = new Thread (this, threadNumString);
         t.start ();
      }
    }

    public static void doWork(int delayTime){
        int waitTime = (int)(Math.random()*delayTime);
        try {
          Thread.sleep(waitTime);
        } catch (Exception e){
          e.printStackTrace();
        }
        /* auto jump is the best zsh plugin! */
      }

    public static void call(boolean waiting){
      if (waiting){
        for (int i = 1; i < 9; i++){
          doWork(80);
          globalVars.incrementThreadProgress(Integer.parseInt(Thread.currentThread().getName()));
        }
      } else {
        for (int i = 1; i < 10; i++){
          doWork(80);
          globalVars.incrementThreadProgress(Integer.parseInt(Thread.currentThread().getName()));
        }
      }
    }

    public static void singleThread(int threadNum){
      for (int i = 1; i < 10; i++){
        doWork(200);
        Draw.drawLine(threadNum, i);
      }
    }
}
