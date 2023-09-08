import java.util.Scanner;

public abstract class LogicGate {
    public String label;
    public int output;
    static final int NONE = -1;
    static Scanner input = new Scanner(System.in);
    
    public LogicGate(String label) {
        this.label = label;
        this.output = NONE;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public int getOutput() {
        this.output = this.performGateLogic();
        return this.output;
    }
    
    public abstract int performGateLogic();
    
}
