import java.util.Random;
import java.util.ArrayList;

public class PrintSimulation {
    
    static Random generator = new Random();
    
    int numSeconds;
    Printer labPrinter;
    Queue<Task> printQueue;
    ArrayList<Integer> waitingTimes;
    
    public PrintSimulation (int numSeconds, int pagesPerMinute) {
        this.numSeconds = numSeconds;
        labPrinter = new Printer(pagesPerMinute);
    }
    
    public void performSimulation() {
        printQueue = new Queue<Task>();
        waitingTimes = new ArrayList<Integer>();
        for (int currentSecond = 0; currentSecond < numSeconds;
          currentSecond++) {
            if (newPrintTask()) {
                Task t = new Task(currentSecond);
                printQueue.enqueue(t);
            }
            
            if ((!labPrinter.busy()) && (!printQueue.isEmpty())) {
                Task nextTask = printQueue.dequeue();
                waitingTimes.add(nextTask.waitTime(currentSecond));
                labPrinter.startNext(nextTask);
            }
            
            labPrinter.tick();
        }
        
        int totalWaitingTime = 0;
        for (int i = 0; i < waitingTimes.size(); i++) {
            totalWaitingTime = totalWaitingTime +
                waitingTimes.get(i);
        }
        double average_wait =
            (double) totalWaitingTime / waitingTimes.size();
            
        System.out.printf("Average wait %6.2f secs. ", average_wait);
        System.out.printf("%d tasks remaining.%n", printQueue.size());
    }
    
    public boolean newPrintTask() {
        int num = generator.nextInt(180) + 1;
        return (num == 180);
    }
    
    public static void main(String[] args) {
        PrintSimulation sim = new PrintSimulation(3600, 5);
        for (int i = 0; i < 10; i++) {
            sim.performSimulation();
        }
    }
}

class Task {    
    int timeStamp;
    int pages;
    
    // The random number generator is static, as it is
    // shared among all tasks.
    static Random generator = new Random();
    
    public Task(int timeStamp) {
        this.timeStamp = timeStamp;
        this.pages = generator.nextInt(20) + 1;
    }
    
    public int getPages() {
        return this.pages;
    }
    
    public int waitTime(int currentTime) {
        return currentTime - this.timeStamp;
    }
}

class Printer {
    int pageRate; // pages per minute
    int timeRemaining;
    Task currentTask;
    
    public Printer(int pageRate) {
        this.pageRate = pageRate;
        this.currentTask = null;
        this.timeRemaining = 0;
    }
    
    public void tick() {
        if (this.currentTask != null) {
            this.timeRemaining = this.timeRemaining - 1;
            if (this.timeRemaining <= 0) {
                this.currentTask = null;
            }
        }
    }
    
    public boolean busy() {
        return this.currentTask != null;
    }
    
    public void startNext(Task newTask) {
        this.currentTask = newTask;
        this.timeRemaining = newTask.getPages() * 60 / this.pageRate;
    }
}
