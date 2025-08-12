public class Car {
    private String make;
    private String model;
    private int year;
    private String vin;

    public Car(String make, String model, int year, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " (VIN: " + vin + ")";
    }
}