// CarInventoryCLI.java
// This is the main class for the command-line interface.
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Dummy CarInventory and Car class definitions for compilation
class CarInventory {
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

class Car {
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

public class CarInventoryCLI {

    private static CarInventory inventory = new CarInventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Car Inventory CLI!");
        runMenu();
    }

    // Displays the menu and handles user input.
    private static void runMenu() {
        int choice = -1;
        while (choice != 5) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a new car");
            System.out.println("2. View all cars");
            System.out.println("3. Find a car by VIN");
            System.out.println("4. Remove a car by VIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addCar();
                        break;
                    case 2:
                        viewAllCars();
                        break;
                    case 3:
                        findCar();
                        break;
                    case 4:
                        removeCar();
                        break;
                    case 5:
                        System.out.println("Exiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                choice = -1;
            }
        }
        scanner.close();
    }

    // Method to add a new car based on user input.
    private static void addCar() {
        System.out.println("\n--- Add New Car ---");
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();

        if (inventory.findCar(vin) != null) {
            System.out.println("A car with that VIN already exists.");
            return;
        }

        Car newCar = new Car(make, model, year, vin);
        inventory.addCar(newCar);
        System.out.println("Car added successfully!");
    }

    // Method to display all cars.
    private static void viewAllCars() {
        System.out.println("\n--- All Cars ---");
        List<Car> allCars = inventory.getAllCars();
        if (allCars.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Car car : allCars) {
                System.out.println(car);
            }
        }
    }

    // Method to find and display a specific car.
    private static void findCar() {
        System.out.println("\n--- Find Car ---");
        System.out.print("Enter VIN to search: ");
        String vin = scanner.nextLine();
        Car foundCar = inventory.findCar(vin);
        if (foundCar != null) {
            System.out.println("Car found: " + foundCar);
        } else {
            System.out.println("No car found with VIN: " + vin);
        }
    }

    // Method to remove a car.
    private static void removeCar() {
        System.out.println("\n--- Remove Car ---");
        System.out.print("Enter VIN of car to remove: ");
        String vin = scanner.nextLine();
        if (inventory.removeCar(vin)) {
            System.out.println("Car removed successfully.");
        } else {
            System.out.println("No car found with VIN: " + vin);
        }
    }
}
