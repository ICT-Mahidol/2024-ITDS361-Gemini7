class Customer {
    private int customerID;
    private String name;
    private String address;
    private String phone;

    public Customer(int customerID, String name, String address, String phone) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getter และ Setter
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

    // Getter และ Setter
}

class Invoice {
    private int invoiceID;
    private double tradeInAllowance;
    private double finalPrice;
    private double tax;
    private double registrationFee;

    public Invoice(int invoiceID, double tradeInAllowance, double finalPrice, double tax, double registrationFee) {
        this.invoiceID = invoiceID;
        this.tradeInAllowance = tradeInAllowance;
        this.finalPrice = finalPrice;
        this.tax = tax;
        this.registrationFee = registrationFee;
    }

    // Getter และ Setter
}

class SalesPerson {
    private int salesPersonID;
    private String name;
    private String contact;

    public SalesPerson(int salesPersonID, String name, String contact) {
        this.salesPersonID = salesPersonID;
        this.name = name;
        this.contact = contact;
    }

    // Getter และ Setter
}

class TradeInVehicle extends Vehicle {
    public TradeInVehicle(String serialNumber, String name, String model, int year, String manufacturer, double baseCost) {
        super(serialNumber, name, model, year, manufacturer, baseCost);
    }
}

class DealerInstalledOption {
    private String optionCode;
    private String description;
    private double price;

    public DealerInstalledOption(String optionCode, String description, double price) {
        this.optionCode = optionCode;
        this.description = description;
        this.price = price;
    }

    // Getter และ Setter
}
