package model;

public class Motherboard extends PCComponent {
    private String chipset;           // 칩셋
    private String formFactor;        // 폼팩터 (ATX, Micro-ATX 등)
    private String pcieVersion;       // 메인보드 PCIe 버전
    private int maxGpuLength;         // GPU 장착 가능한 최대 길이 (mm)
    private int availableSlots;       // 메인보드에 남은 슬롯 수
    private String ramType;           // 메인보드가 지원하는 RAM 타입 (DDR4, DDR5)
    private double maxRamSpeed;       // 메인보드에서 지원 가능한 최대 RAM 클럭 속도
    private boolean xmpSupported;     // 메인보드 XMP 지원 여부
    private int ramSlotCapacity;      // 메인보드 RAM 슬롯 용량 (GB)
    private int availableRamSlots;    // 메인보드에서 남은 RAM 슬롯 수
    private boolean supportsNVMe;     // NVMe SSD 지원 여부
    private boolean supportsSATA;     // SATA SSD 지원 여부
    private boolean hasM2Slot;        // M.2 슬롯 존재 여부
    private boolean m2SataConflict;   // M.2 슬롯 사용 시 SATA 포트 비활성화 여부
    private boolean hasPcieLanes;     // PCIe 레인 지원 여부

    // Constructor
    public Motherboard(String name, String manufacturer, double price, String chipset, String formFactor, String pcieVersion, int maxGpuLength, int availableSlots,
                       String ramType, double maxRamSpeed, boolean xmpSupported, int ramSlotCapacity, int availableRamSlots,
                       boolean supportsNVMe, boolean supportsSATA, boolean hasM2Slot, boolean m2SataConflict, boolean hasPcieLanes) {
        super(name, manufacturer, price);
        this.chipset = chipset;
        this.formFactor = formFactor;
        this.pcieVersion = pcieVersion;
        this.maxGpuLength = maxGpuLength;
        this.availableSlots = availableSlots;
        this.ramType = ramType;
        this.maxRamSpeed = maxRamSpeed;
        this.xmpSupported = xmpSupported;
        this.ramSlotCapacity = ramSlotCapacity;
        this.availableRamSlots = availableRamSlots;
        this.supportsNVMe = supportsNVMe;
        this.supportsSATA = supportsSATA;
        this.hasM2Slot = hasM2Slot;
        this.m2SataConflict = m2SataConflict;
        this.hasPcieLanes = hasPcieLanes;
    }

    // Getter 메서드
    public String getChipset() {
        return chipset;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public String getPcieVersion() {
        return pcieVersion;
    }

    public int getMaxGpuLength() {
        return maxGpuLength;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public String getRamType() {
        return ramType;
    }

    public double getMaxRamSpeed() {
        return maxRamSpeed;
    }

    public boolean isXmpSupported() {
        return xmpSupported;
    }

    public int getRamSlotCapacity() {
        return ramSlotCapacity;
    }

    public int getAvailableRamSlots() {
        return availableRamSlots;
    }

    public boolean supportsNVMe() {
        return supportsNVMe;
    }

    public boolean supportsSATA() {
        return supportsSATA;
    }

    public boolean hasM2Slot() {
        return hasM2Slot;
    }

    public boolean isM2SataConflict() {
        return m2SataConflict;
    }

    public boolean hasPcieLanes() {
        return hasPcieLanes;
    }
}
