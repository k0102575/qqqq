/* 멀티 태스킹 */
package step19;

public class Test01v {
  public static void main(String[] args) {
    System.out.println("step19 Test01 실행중");
    System.out.println();
    
    Thread t = Thread.currentThread();
    
    System.out.println(t.getName());
    
    ThreadGroup g = t.getThreadGroup();
    System.out.println(g.getName());
    
    ThreadGroup g2 = g.getParent();
    System.out.println(g2.getName());
    
//    ThreadGroup g3 = g2.getParent();
//    System.out.println(g3.getName());
    
    System.out.println("[system]------------------");
    
    printThreadGroup(g2, "  ");
    printThread(g2, "  ");
    
    
  } // main
  
  static void printThreadGroup(ThreadGroup tg, String prefix) {
    ThreadGroup[] groupArray = new ThreadGroup[10];
    int count = tg.enumerate(groupArray, false);
    for (int i = 0;i < count; i++){
      System.out.printf("%sTG '%s' \n", prefix, groupArray[i].getName());
    }
  } // printThreadGroup()
  
  static void printThread(ThreadGroup tg, String prefix) {
    Thread[] threadArray = new Thread[10];
    int count = tg.enumerate(threadArray, false);
    for (int i =0; i < count; i++){
      System.out.printf("%s-- '%s' \n", prefix, threadArray[i].getName());
    }
  } // printThread()
  
}
