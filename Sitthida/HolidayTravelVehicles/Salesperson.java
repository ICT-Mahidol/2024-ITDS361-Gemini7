public class Salesperson {
    int salespersonID;
    String name;
    String phoneNumber;
    
    public Salesperson(int salespersonID, String name, String phoneNumber) {
        this.salespersonID = salespersonID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public String getSalespersonInfo() {
        return "Salesperson ID: " + salespersonID + "\nName: " + name + "\nPhone: " + phoneNumber;
    }
}
