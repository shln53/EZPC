package model;

public class Storage extends PCComponent {
    private int capacity; // 저장 용량 (GB)
    private String type;  // 저장소 유형 (HDD, SSD)
    private String interfaceType; // 인터페이스 (SATA, NVMe)

    public Storage(String name, String manufacturer, double price, int capacity, String type, String interfaceType) {
        super(name, manufacturer, price);
        this.capacity = capacity;
        this.type = type;
        this.interfaceType = interfaceType;
    }

    // Getter 메서드
    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public String getInterfaceType() {
        return interfaceType;
    }
}
