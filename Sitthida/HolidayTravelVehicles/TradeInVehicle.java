public class TradeInVehicle {
    String serialNumber;
    String make;
    String model;
    int year;
    float tradeInAllowance;
    
    public TradeInVehicle(String serialNumber, String make, String model, int year, float tradeInAllowance) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.tradeInAllowance = tradeInAllowance;
    }
    
    public float getTradeInValue() {
        return tradeInAllowance;
    }
}

