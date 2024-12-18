public class Motherboard extends PCComponent {
    private String chipset;     // 칩셋
    private String formFactor;  // 폼팩터 (ATX, Micro-ATX 등)

    public Motherboard(String name, String manufacturer, double price, String chipset, String formFactor) {
        super(name, manufacturer, price);
        this.chipset = chipset;
        this.formFactor = formFactor;
    }

    public String getChipset() {
        return chipset;
    }

    public String getFormFactor() {
        return formFactor;
    }

}
