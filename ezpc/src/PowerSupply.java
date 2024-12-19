public class PowerSupply extends PCComponent {
    private int wattage; // 출력 용량 (W)

    public PowerSupply(String name, String manufacturer, double price, int wattage) {
        super(name, manufacturer, price);
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }
}
