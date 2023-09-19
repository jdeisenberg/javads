public class TowerOfHanoi {
    public static void moveTower(int height, String fromPole,
        String toPole, String withPole) {
        if (height >= 1) {
            moveTower(height - 1, fromPole, withPole, toPole);
            moveDisk(fromPole, toPole);
            moveTower(height - 1, withPole, toPole, fromPole);
        }
    }
    public static void moveDisk(String fromPole, String toPole) {
        System.out.printf("Moving disk from %s to %s.%n", fromPole, toPole);
    }
    
    public static void main(String[] args) {
        moveTower(3, "A", "C", "B");
    }
}
