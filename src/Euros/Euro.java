package Euros;

public class Euro {
    private double amount;
    private static final int CENTS_PER_EURO = 100;

    public Euro(int value) {
        this.amount = value * CENTS_PER_EURO;
    }

    public Euro(double value) {
        this.amount = value * CENTS_PER_EURO;
    }

    @Override
    public String toString() {
        return String.format("EUR %.2f", amount / CENTS_PER_EURO);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Euro) {
           Euro euro = (Euro) o;
           return euro.hashCode() == this.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(amount);
    }

    public Euro minus(Euro anotherOne) {
        Euro result = new Euro(0);
        result.amount = this.amount - anotherOne.amount;
        return result;
    }
}
