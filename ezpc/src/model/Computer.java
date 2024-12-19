package model;

import java.io.Serializable;

public class Computer implements Serializable {
    private CPU cpu;
    private CPUCooler cpuCooler;
    private Motherboard motherboard;
    private Memory memory;
    private Storage storage;
    private GPU gpu;
    private PowerSupply powerSupply;

    // 생성자에서 각 부품을 초기화
    public Computer(CPU cpu, CPUCooler cpuCooler, Motherboard motherboard,
                    Memory memory, Storage storage, GPU gpu, PowerSupply powerSupply) {
        this.cpu = cpu;
        this.cpuCooler = cpuCooler;
        this.motherboard = motherboard;
        this.memory = memory;
        this.storage = storage;
        this.gpu = gpu;
        this.powerSupply = powerSupply;
    }

    // 각 부품을 설정하는 메서드
    public void setCPU(CPU cpu) {
        this.cpu = cpu;
    }

    public void setCPUCooler(CPUCooler cpuCooler) {
        this.cpuCooler = cpuCooler;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setGPU(GPU gpu) {
        this.gpu = gpu;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    // 각 부품을 반환하는 get 메서드
    public CPU getCPU() {
        return cpu;
    }

    public CPUCooler getCPUCooler() {
        return cpuCooler;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public Memory getMemory() {
        return memory;
    }

    public Storage getStorage() {
        return storage;
    }

    public GPU getGPU() {
        return gpu;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

}