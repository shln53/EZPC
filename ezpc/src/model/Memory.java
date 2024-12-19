package model;

public class Memory extends PCComponent {
    private int size;    // 메모리 크기 (GB)
    private int speed;   // 메모리 속도 (MHz)
    private String type;         // RAM 타입 (예: DDR4, DDR5)
    private int capacity;        // RAM 용량 (GB)
    private double clockSpeed;   // RAM 클럭 속도 (GHz)
    private boolean xmpSupport;  // XMP 지원 여부

    public Memory(String name, String manufacturer, double price, String type, int capacity, double clockSpeed, boolean xmpSupport) {
        super(name, manufacturer, price);
        this.size = size;
        this.speed = speed;
        this.type = type;
        this.capacity = capacity;
        this.clockSpeed = clockSpeed;
        this.xmpSupport = xmpSupport;
    }


    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public boolean isXmpSupport() {
        return xmpSupport;
    }
}
