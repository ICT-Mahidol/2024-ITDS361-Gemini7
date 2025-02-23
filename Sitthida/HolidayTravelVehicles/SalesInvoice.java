import java.sql.Date;

public class SalesInvoice {
    String invoiceNumber;
    Date date;
    float agreedPrice;
    float tax;
    float registrationFee;
    float totalCost;
    
    public SalesInvoice(String invoiceNumber, Date date, float agreedPrice, float tax, float registrationFee) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.agreedPrice = agreedPrice;
        this.tax = tax;
        this.registrationFee = registrationFee;
        calculateTotalCost();
    }
    
    public void calculateTotalCost() {
        totalCost = agreedPrice + tax + registrationFee;
    }
}