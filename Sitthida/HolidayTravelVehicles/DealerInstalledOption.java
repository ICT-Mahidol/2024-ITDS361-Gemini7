public class DealerInstalledOption {
    String optionCode;
    String description;
    float price;
    
    public DealerInstalledOption(String optionCode, String description, float price) {
        this.optionCode = optionCode;
        this.description = description;
        this.price = price;
    }
    
    public String getOptionDetails() {
        return "Option Code: " + optionCode + "\nDescription: " + description + "\nPrice: " + price;
    }
}
