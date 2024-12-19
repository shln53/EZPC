package model;

import java.io.Serializable;

abstract class PCComponent implements Serializable {
    private String name;
    private String manufacturer;
    private double price;

    public PCComponent(String name, String manufacturer, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

}
