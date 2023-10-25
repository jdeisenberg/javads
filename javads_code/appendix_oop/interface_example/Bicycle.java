class Bicycle {
    private double frameSize;
    private int nGears;
    private int currentGear;
    
    Bicycle(double frameSize, int nGears) {
        this.frameSize = frameSize;
        this.nGears = nGears;
        setCurrentGear(nGears);
    }
    
    public double getFrameSize() {
        return this.frameSize;
    }
    
    public int getNGears() {
        return nGears;
    }
    
    public int getCurrentGear() {
        return currentGear;
    }
    
    public void setCurrentGear(int currentGear) {
        this.currentGear = Math.min(this.nGears, Math.max(currentGear, 1));
    }
}
