public class TradeInVehicle {
    private String serialNumber;
    private String make;
    private String model;
    private int year;
    private double tradeInValue;

    public TradeInVehicle(String serialNumber, String make, String model, int year, double tradeInValue) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.tradeInValue = tradeInValue;
    }

    public double getTradeInValue() { return tradeInValue; }
}