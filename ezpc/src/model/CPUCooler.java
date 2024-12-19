package model;

public class CPUCooler extends PCComponent {
    private String coolingType; // 공랭/수랭

    public CPUCooler(String name, String manufacturer, double price, String coolingType) {
        super(name, manufacturer, price);
        this.coolingType = coolingType;
    }

    public String getCoolingType() {
        return coolingType;
    }
}
