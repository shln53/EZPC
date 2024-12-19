package model;

public class CPUCooler extends PCComponent {
    private String socketType;    // CPU 소켓 타입
    private double tdp;           // CPU TDP (Thermal Design Power)
    private String coolingType;   // CPU 쿨러 타입 (공랭, 수랭 등)
    private String socketCompatibility; // CPU 쿨러의 호환 소켓 타입
    private double coolingCapacity; // 쿨러의 냉각 용량 (CPU의 TDP보다 클 것)

    // 생성자
    public CPUCooler(String name, String manufacturer, double price, String socketType, double tdp,
                     String coolingType, String socketCompatibility, double coolingCapacity) {
        super(name, manufacturer, price);
        this.socketType = socketType;
        this.tdp = tdp;
        this.coolingType = coolingType;
        this.socketCompatibility = socketCompatibility;
        this.coolingCapacity = coolingCapacity;
    }

    // CPU 관련 메서드
    public String getSocketType() {
        return socketType;
    }

    public double getTdp() {
        return tdp;
    }

    // CPU 쿨러 관련 메서드
    public String getCoolingType() {
        return coolingType;
    }

    public String getSocketCompatibility() {
        return socketCompatibility;
    }

    public double getCoolingCapacity() {
        return coolingCapacity;
    }
}
