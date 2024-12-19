package model;

public class CPU extends PCComponent {
    private int cores;
    private double clockSpeed;
    private String socketType;
    private String cpuGeneration;
    private String supportedMemory;
    private double tdp; // 전력 소비

    public CPU(String name, String manufacturer, double price, int cores, double clockSpeed, String socketType, String cpuGeneration, String supportedMemory, double tdp) {
        super(name, manufacturer, price);
        this.cores = cores;
        this.clockSpeed = clockSpeed;
        this.socketType = socketType;
        this.cpuGeneration = cpuGeneration;
        this.supportedMemory = supportedMemory;
        this.tdp = tdp;
    }

    public String getSocketType() {
        return socketType;
    }

    public String getCpuGeneration() {
        return cpuGeneration;
    }

    public String getSupportedMemory() {
        return supportedMemory;
    }

    public double getTdp() {
        return tdp;
    }

    public int getCores() {
        return cores;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

}
