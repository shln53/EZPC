public class Memory extends PCComponent {
    private int size;    // 메모리 크기 (GB)
    private int speed;   // 메모리 속도 (MHz)

    public Memory(String name, String manufacturer, double price, int size, int speed) {
        super(name, manufacturer, price);
        this.size = size;
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }
}
