package erp.core;

class NationalProduct extends Product {
    @java.io.Serial
    private static final long serialVersionUID = 202608261200L;

    public NationalProduct(int id, String name, int basePrice, Category category, int baseDeadline) {
        super(id, name, basePrice, category, baseDeadline);
    }

    @Override
    public double getRecommendedPrice() {
        int units = getTotalUnits();
        if (units > 10000)
            return getBasePrice() * 90 / 100.0;
        if (units < 100)
            return getBasePrice() * 130 / 100.0;
        return getBasePrice();
    }
}
