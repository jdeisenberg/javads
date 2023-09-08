abstract class LogicGate {
    public String name;
    public int output;
    static final int NONE = -1;
    
    public LogicGate(String name) {
        this.name = name;
        this.output = NONE;
    }
    
    public String getname() {
        return this.name;
    }
    
    public int getOutput() {
        this.output = this.performGateLogic();
        return this.output;
    }
    
    public abstract int performGateLogic();
    
}

class SourceGate extends LogicGate {
    int value;
    
    public SourceGate(String name) {
        super(name);
        this.value = NONE;
    }
    
    public SourceGate(String name, int value) {
        super(name);
        this.value = value;
    }
    
    public int performGateLogic() {
        return this.value;
    }
}

abstract class BinaryGate extends LogicGate{
    LogicGate pinA;
    LogicGate pinB;
    
    public BinaryGate(String name) {
        super(name);
        pinA = NONE;
        pinB = NONE;
    }
    
    public BinaryGate(String name, int pinA, int pinB) {
        super(name);
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
    
    public UnaryGate(String name) {
        super(name);
        pin = NONE;
    }
    
    public UnaryGate(String name, int pin) {
        super(name);
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
    
    public AndGate(String name) {
        super(name);
    }
    
    public AndGate(String name, int pinA, int pinB) {
        super(name, pinA, pinB);
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
    
    public OrGate(String name) {
        super(name);
    }
    
    public OrGate(String name, int pinA, int pinB) {
        super(name, pinA, pinB);
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
    public NotGate(String name) {
        super(name);
    }
    
    public NotGate(String name, int pin) {
        super(name, pin);
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

public class GateExample {
    public static void main(String[] args) {
        OrGate g2 = new OrGate("G2", 1, 1);
        System.out.println(g2.getOutput());

        g2.setPins(0, 0);
        System.out.println(g2.getOutput());

        NotGate g3 = new NotGate("G3", 0);
        System.out.println(g3.getOutput());
    }
}
