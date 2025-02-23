public class Salesperson {
    private int salespersonID;
    private String name;
    private String phoneNumber;

    public Salesperson(int salespersonID, String name, String phoneNumber) {
        this.salespersonID = salespersonID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public SalesInvoice createSalesInvoice(int invoiceID, Customer customer, Vehicle vehicle, double negotiatedPrice, double tax, double registrationFee, double tradeInAllowance) {
        return new SalesInvoice(invoiceID, customer, vehicle, negotiatedPrice, tax, registrationFee, tradeInAllowance);
    }

    public double negotiatePrice(double baseCost, double discount) {
        return baseCost - discount;
    }
}