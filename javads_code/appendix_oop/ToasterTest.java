/*
 * Simulate a toaster with slots, voltage, slices of bread,
 * and darkness control
 */
class PowerSupply {
    private int voltage;
    private boolean turnedOn;
    
    public PowerSupply(int voltage) {
        if (voltage == 110 || voltage == 220) {
            this.voltage = voltage;
        } else {
            this.voltage = 110;
        }
        // new power supplies are always turned off.
        this.turnedOn = false;
    }
    
    public int getVoltage() {
        return voltage;
    }
    
    // once set during construction, the voltage
    // does not change
    
    public boolean isTurnedOn() {
        return turnedOn;
    }
    
    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }
}

class Dial {
    private double dialValue;
    private int minValue;
    private int maxValue;
    
    public Dial(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        // new dials are always shipped set to lowest value
        this.dialValue = minValue;
    }
    
    public double getDialValue() {
        return dialValue;
    }
    
    // make sure that the new value is clamped in the
    // range minValue - maxValue (inclusive)
    public void setDialValue(double dialValue) {
        this.dialValue = Math.min(maxValue, Math.max(minValue, dialValue));
    }
    
    public int getMinValue() {
        return minValue;
    }
    
    public int getMaxValue() {
        return maxValue;
    }
    
    // There are no setters for the minimum and maximum value;
    // they are set at construction time and never change.
}
    
class Toaster {
    private int nSlots;
    private int nSlices;
    private PowerSupply power;
    private Dial darkness;
    
    public Toaster(int nSlots, int voltage) {
        this.power = new PowerSupply(voltage);
        this.darkness = new Dial(1, 10);
        this.nSlots = Math.max(1, Math.min(4, nSlots));
        this.nSlices = 0;
    }
    
    // Provide only setters for power, darkness, and nSlots;
    // once sets, they will never change.
    
    public PowerSupply getPower() {
        return power;
    }
    
    public Dial getDarkness() {
        return darkness;
    }
    
    public int getNSlots() {
        return nSlots;
    }
        
    public int getNSlices() {
        return nSlices;
    }
    
    public void setNSlices(int nSlices) {
        this.nSlices = Math.min(nSlots, Math.abs(nSlices));
    }
    
    public void insertBread(int n) {
        if (power.isTurnedOn()) {
            setNSlices(nSlices + n);
        }
    }
    
    public void popBread() {
        if (power.isTurnedOn()) {
            setNSlices(0);
        }
    }
    
    // Provide methods to allow Toaster users to get/set
    // attributes and methods of the power supply without
    // having to do a chain like:
    // myToaster.getPower().setTurnedOn(true);
    
    public boolean isTurnedOn() {
        return this.power.isTurnedOn();
    }
    
    public void setTurnedOn(boolean turnedOn) {
        this.power.setTurnedOn(turnedOn);
    }
    
    public double getDialValue() {
        return this.darkness.getDialValue();
    }
    
    public void setDialValue(double dialValue) {
        this.darkness.setDialValue(dialValue);
    }
    
    public String toString() {
        return String.format("%d slot %dV toaster with %d slice%s at darkness %.1f: %s",
            nSlots, power.getVoltage(),
            nSlices, ((nSlices == 1) ? "" : "s"),
            darkness.getDialValue(),
            ((power.isTurnedOn())? "ON" : "OFF"));
    }
}

public class ToasterTest {
    public static void main(String[] args) {
        Toaster euroFour = new Toaster(4, 220);
        
        euroFour.setTurnedOn(true);
        euroFour.setDialValue(4);
        euroFour.insertBread(1);
        
        System.out.println(euroFour);
    }
}

