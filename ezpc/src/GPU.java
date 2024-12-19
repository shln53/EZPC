public class GPU extends PCComponent {
    private int memorySize;        // GPU 메모리 크기 (GB)
    private String chipset;        // GPU 칩셋
    private String pcieVersion;    // GPU의 PCIe 버전 (예: PCIe 4.0)
    private int length;            // GPU의 길이 (mm)
    private int slotCount;         // GPU가 차지하는 슬롯 수

    public GPU(String name, String manufacturer, double price, int memorySize, String chipset,
               String pcieVersion, int length, int slotCount) {
        super(name, manufacturer, price);
        this.memorySize = memorySize;
        this.chipset = chipset;
        this.pcieVersion = pcieVersion;
        this.length = length;
        this.slotCount = slotCount;
    }

    // Getter 메서드
    public int getMemorySize() {
        return memorySize;
    }

    public String getChipset() {
        return chipset;
    }

    public String getPcieVersion() {
        return pcieVersion;
    }

    public int getLength() {
        return length;
    }

    public int getSlotCount() {
        return slotCount;
    }
}