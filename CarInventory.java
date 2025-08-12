public class CarInventory {
    private java.util.ArrayList<Car> cars = new java.util.ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public java.util.List<Car> getAllCars() {
        return new java.util.ArrayList<>(cars);
    }

    public Car findCar(String vin) {
        for (Car car : cars) {
            if (car.getVin().equals(vin)) {
                return car;
            }
        }
        return null;
    }

    public boolean removeCar(String vin) {
        return cars.removeIf(car -> car.getVin().equals(vin));
    }
}

