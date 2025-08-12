# Car Inventory CLI 🚗

This is a simple command-line interface (CLI) application for managing a car inventory.  
It allows users to perform basic **CRUD** (Create, Read, Update, Delete) operations on a list of cars.  
The application uses **object-oriented principles** in Java and includes a feature to save and load the inventory to a file, so your data is persistent between sessions.

---

## 🛠️ Features
- **Add a new car**: Enter details like make, model, year, and a unique VIN.
- **View all cars**: Display a list of all cars currently in the inventory.
- **Find a car**: Search for a specific car using its VIN.
- **Remove a car**: Delete a car from the inventory by its VIN.
- **Persistent storage**: The car data is saved to a file (`car_inventory.ser`) and automatically loaded on startup.

---

## 🚀 How to Run
1. Clone or download this repository.
2. Open the project in a Java IDE like **VS Code**, **IntelliJ**, or **Eclipse**.
3. Compile and run the `CarInventoryCLI.java` class.
4. Follow the on-screen menu to interact with the application.

---

## 📂 File Structure
- **`Car.java`**: The model class representing a single car.
- **`CarInventory.java`**: The backend logic for managing the list of cars and handling file I/O.
- **`CarInventoryCLI.java`**: The main class containing the command-line interface and the `main` method.

---

**Built with:** Java ☕
