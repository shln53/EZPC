package component;

public class Storage extends PCComponent {
    private int capacity; // 저장 용량 (GB)
    private String type;  // 저장소 유형 (HDD, SSD)

    public Storage(String name, String manufacturer, double price, int capacity, String type) {
        super(name, manufacturer, price);
        this.capacity = capacity;
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }
}
