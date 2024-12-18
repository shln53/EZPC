public class CPU extends PCComponent {
    private int cores;         // 코어 수
    private double clockSpeed; // 클럭 속도 (GHz)

    public CPU(String name, String manufacturer, double price, int cores, double clockSpeed) {
        super(name, manufacturer, price);
        this.cores = cores;
        this.clockSpeed = clockSpeed;
    }

    public int getCores() {
        return cores;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

}
