class ElectricCargoBicycle extends CargoBicycle implements Electrified {
    private int chargeCapacity;
    private double currentCharge;
    
    public ElectricCargoBicycle(double frameSize, int nGears,
      double maxLoad, int chargeCapacity) {
        super(frameSize, nGears, maxLoad);
        this.chargeCapacity = chargeCapacity;
        this.currentCharge = 0.0;
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
