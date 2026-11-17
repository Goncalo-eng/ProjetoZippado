package erp.core;

class ImportedProduct extends Product {
    @java.io.Serial
    private static final long serialVersionUID = 202608261200L;

    private String _originCountry;
    private double _customsFee;

    public ImportedProduct(int id, String name, int basePrice, Category category, int baseDeadline,
            String originCountry, double customsFee) {
        super(id, name, basePrice, category, baseDeadline);
        _originCountry = originCountry;
        _customsFee = customsFee;
    }

    @Override
    public double getRecommendedPrice() {
        return getBasePrice() * (100 + _customsFee) / 100;
    }

    public String getOriginCountry() {
        return _originCountry;
    }
}