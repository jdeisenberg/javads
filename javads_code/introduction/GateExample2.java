abstract class LogicGate {
    public String label;
    public int output;
    static final int NONE = -1;
    
    public LogicGate(String label) {
        this.label = label;
        this.output = NONE;
    }
    
    public String getlabel() {
        return this.label;
    }
    
    public int getOutput() {
        this.output = this.performGateLogic();
        return this.output;
    }
    
    public abstract int performGateLogic();
    
}

class SourceGate extends LogicGate {
    int value;
    
    public SourceGate(String label) {
        super(label);
        this.value = NONE;
    }
    
    public SourceGate(String label, int value) {
        super(label);
        this.value = value;
    }
    
    public int performGateLogic() {
        return this.value;
    }
}

abstract class BinaryGate extends LogicGate{
    LogicGate pinA;
    LogicGate pinB;
    
    public BinaryGate(String label) {
        super(label);
        pinA = new SourceGate("", NONE);
        pinB = new SourceGate("", NONE);
    }
    
    public BinaryGate(String label, int pinA, int pinB) {
        super(label);
        this.pinA = pinA;
        this.pinB = pinB;
    }
    
    public int getPinA() {
        return this.pinA;
    }
    
    public int getPinB() {
        return this.pinB;
    }
    
    public void setPins(int pinA, int pinB) {
        this.pinA = pinA;
        this.pinB = pinB;
    }
    
    public void setNextPin(Connector conn) {
        if (this.pinA == NONE) {
            this.pinA = conn;
        } else if (this.pinB == NONE) {
            this.pinB = conn;
        } else {
            throw new RuntimeException("Error: NO EMPTY PINS");
        }
    }
}

abstract class UnaryGate extends LogicGate{
    int pin;
    
    public UnaryGate(String label) {
        super(label);
        pin = NONE;
    }
    
    public UnaryGate(String label, int pin) {
        super(label);
        this.pin = pin;
    }
    
    public int getPin() {
        return this.pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setNextPin(Connector conn) {
        if (this.pin == NONE) {
            this.pin = conn;
        } else {
            throw new RuntimeException("Error: NO EMPTY PINS");
        }
    }
}


class AndGate extends BinaryGate {
    
    public AndGate(String label) {
        super(label);
    }
    
    public AndGate(String label, int pinA, int pinB) {
        super(label, pinA, pinB);
    }
    
    public int performGateLogic() {
        if (this.pinA == NONE || this.pinB == NONE) {
            return NONE;
        }
        else if (this.pinA == 1 && this.pinB == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
   
class OrGate extends BinaryGate {
    
    public OrGate(String label) {
        super(label);
    }
    
    public OrGate(String label, int pinA, int pinB) {
        super(label, pinA, pinB);
    }
    
    public int performGateLogic() {
        if (this.pinA == NONE || this.pinB == NONE) {
            return NONE;
        }
        else if (this.pinA == 1 || this.pinB == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}

class NotGate extends UnaryGate {
    public NotGate(String label) {
        super(label);
    }
    
    public NotGate(String label, int pin) {
        super(label, pin);
    }
    
    public int performGateLogic() {
        if (this.pin == NONE) {
            return NONE;
        }
        else if (this.pin == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Connector {
    LogicGate fromGate;
    LogicGate toGate;
    
    public Connector(LogicGate fromGate, LogicGate toGate) {
        this.fromGate = fromGate;
        this.toGate = toGate;
        if (toGate instanceof BinaryGate) {
            ((BinaryGate) this.toGate).setNextPin(this);
        } else if (toGate instanceof UnaryGate) {
            ((UnaryGate) this.toGate).setNextPin(this);
        }
    }
    
    public LogicGate getFrom() {
        return this.fromGate;
    }
    
    public LogicGate getTo() {
        return this.toGate;
    }
}    

public class GateExample2 {
    public static void main(String[] args) {
        OrGate g2 = new OrGate("G2", 1, 1);
        System.out.println(g2.getOutput());

        g2.setPins(0, 0);
        System.out.println(g2.getOutput());

        NotGate g3 = new NotGate("G3", 0);
        System.out.println(g3.getOutput());
    }
}
