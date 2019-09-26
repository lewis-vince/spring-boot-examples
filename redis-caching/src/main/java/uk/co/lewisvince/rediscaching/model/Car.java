package uk.co.lewisvince.rediscaching.model;

public class Car {

    private String Manufacturer;

    private String licensePlate;

    private int yearOfManufacture;

    public Car(String manufacturer, String licensePlate, int yearOfManufacture) {
        Manufacturer = manufacturer;
        this.licensePlate = licensePlate;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
}
