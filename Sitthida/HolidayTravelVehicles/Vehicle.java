public class Vehicle {
    String serialNumber;
    String name;
    String model;
    int year;
    String manufacturer;
    float baseCost;
    
    public Vehicle(String serialNumber, String name, String model, int year, String manufacturer, float baseCost) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }
    
    public String getVehicleDetails() {
        return "Serial Number: " + serialNumber + "\nName: " + name + "\nModel: " + model + "\nYear: " + year + "\nManufacturer: " + manufacturer + "\nBase Cost: " + baseCost;
    }
}
