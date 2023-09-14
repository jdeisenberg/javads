public class PrintQueue {
    public static void main(String[] args) {
        System.out.println("TBD");
    }
}

class Task {
    public Task() {
    }
    
    public int getPages() {
        return 0;
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
    /*
class Printer:
 
    def start_next(self, new_task):
        self.current_task = new_task
        self.time_remaining = new_task.get_pages() * 60 / self.page_rate
        */
