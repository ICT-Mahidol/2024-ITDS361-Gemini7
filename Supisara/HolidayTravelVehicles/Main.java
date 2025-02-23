public class Main {
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle("456789", "Model X", "Plaid", 2023, "Tesla", 5000000);
        System.out.println(vehicle);

        System.out.println("Vehicle Serial Number: " + vehicle.getSerialNumber());
        System.out.println("Vehicle Name: " + vehicle.getName());
        System.out.println("Vehicle Model: " + vehicle.getModel());
        System.out.println("Vehicle Year: " + vehicle.getYear());
        System.out.println("Vehicle Manufacturer: " + vehicle.getManufacturer());
        System.out.println("Vehicle Base Cost: $" + vehicle.getBaseCost());
    }
}