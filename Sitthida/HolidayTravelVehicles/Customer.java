public class Customer {
    int customerID;
    String name;
    String address;
    String phoneNumber;
    
    public Customer(int customerID, String name, String address, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public String getCustomerInfo() {
        return "Customer ID: " + customerID + "\nName: " + name + "\nAddress: " + address + "\nPhone: " + phoneNumber;
    }
}