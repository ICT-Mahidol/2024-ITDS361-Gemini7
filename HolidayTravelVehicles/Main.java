public class Main {
    public static void main(String[] args) {
        // สร้าง Vehicle object
        Vehicle myCar = new Vehicle("12345ABC", "Sedan", "Toyota Camry", 2023, "Toyota", 30000.00);

        // แสดงข้อมูลของ Vehicle
        System.out.println("Vehicle Information:");
        System.out.println("Serial Number: " + myCar.getSerialNumber());
        System.out.println("Name: " + myCar.getName());
        System.out.println("Model: " + myCar.getModel());
        System.out.println("Year: " + myCar.getYear());
        System.out.println("Manufacturer: " + myCar.getManufacturer());
        System.out.println("Base Cost: $" + myCar.getBaseCost());
    }
}

class Vehicle {
    private String serialNumber;
    private String name;
    private String model;
    private int year;
    private String manufacturer;
    private double baseCost;

    public Vehicle(String serialNumber, String name, String model, int year, String manufacturer, double baseCost) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }

    // Getter methods
    public String getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getBaseCost() {
        return baseCost;
    }
}
