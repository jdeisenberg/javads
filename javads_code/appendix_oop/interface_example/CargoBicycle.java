class CargoBicycle extends Bicycle {
    private double maxLoad;
    private double currentLoad;
    
    public CargoBicycle(double frameSize, int nGears, double maxLoad) {
        super(frameSize, nGears);
        this.maxLoad = maxLoad;
        this.currentLoad = 0;
    }
    
    public double getMaxLoad() {
        return this.maxLoad;
    }
    
    public double getCurrentLoad() {
        return this.currentLoad;
    }
    
    public void setCurrentLoad(double currentLoad) {
        this.currentLoad = Math.max(0, Math.min(currentLoad, maxLoad));
    }
}
