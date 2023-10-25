class ElectricBicycle extends Bicycle implements Electrified {
    private int chargeCapacity;
    private double currentCharge;
    
    ElectricBicycle(double frameSize, int nGears, int chargeCapacity) {
        super(frameSize, nGears);
        this.chargeCapacity = chargeCapacity;
    }
    
    /* Implement the methods in the interface */
    public int getChargeCapacity() {
        return this.chargeCapacity;
    }
    
    public double getCurrentCharge() {
        return this.currentCharge;
    }
    
    public void setCurrentCharge(double charge) {
        this.currentCharge = Math.max(0, Math.min(charge, chargeCapacity));
    }
}
