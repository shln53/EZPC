package model;

public class GPU extends PCComponent {
    private int memorySize; // GPU 메모리 크기 (GB)
    private String chipset; // GPU 칩셋

    public GPU(String name, String manufacturer, double price, int memorySize, String chipset) {
        super(name, manufacturer, price);
        this.memorySize = memorySize;
        this.chipset = chipset;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public String getChipset() {
        return chipset;
    }
}
