package ch_09.exercise09_02;


public class Stock {
    public String getSymbol() {
        return symbol;
    }

    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock() {
    }

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;

    }

    public double getChangePercent() {
        return (currentPrice - previousClosingPrice) / currentPrice;

    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stock{}";
    }
}
