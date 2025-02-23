import java.util.ArrayList;
import java.util.List;

public class SalesInvoice {
    private int invoiceID;
    private double negotiatedPrice;
    private double tax;
    private double registrationFee;
    private double tradeInAllowance;
    private Customer customer;
    private Vehicle vehicle;
    private List<DealerInstalledOption> options = new ArrayList<>();
    private boolean signed;

    public SalesInvoice(int invoiceID, Customer customer, Vehicle vehicle, double negotiatedPrice, double tax, double registrationFee, double tradeInAllowance) {
        this.invoiceID = invoiceID;
        this.customer = customer;
        this.vehicle = vehicle;
        this.negotiatedPrice = negotiatedPrice;
        this.tax = tax;
        this.registrationFee = registrationFee;
        this.tradeInAllowance = tradeInAllowance;
        this.signed = false;
    }

    public double calculateTotal() {
        double optionsCost = options.stream().mapToDouble(DealerInstalledOption::getPrice).sum();
        return negotiatedPrice + tax + registrationFee - tradeInAllowance + optionsCost;
    }
    
    public void addDealerOption(DealerInstalledOption option) {
        options.add(option);
    }
    
    public void addTradeInVehicle(TradeInVehicle tradeIn) {
        this.tradeInAllowance = tradeIn.getTradeInValue();
    }
    
    public void signInvoice() {
        this.signed = true;
    }
}