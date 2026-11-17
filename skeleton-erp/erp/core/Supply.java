package erp.core;

import java.io.Serializable;

class Supply implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = 202608261200L;

    private int _units;
    private double _factor;
    private final Product _product;
    private final Company _company;

    public Supply(int units, double factor, Product product, Company company) {
        _units = units;
        _factor = factor;
        _product = product;
        _company = company;
        _product.addSupply(this);
    }

    public int getUnits() {
        return _units;
    }

    public double getFactor() {
        return _factor;
    }

    public Product getProduct() {
        return _product;
    }

    public Company getCompany() {
        return _company;
    }

    public double getSalePrice() {
        return Math.round(_product.getRecommendedPrice() * _factor * 100) / 100.0;
    }

    boolean canChange(int qnt, double factor) {
        return _units + qnt >= 0 && factor > 0;
    }

    boolean change(int qnt, double factor) {
        if (!canChange(qnt, factor))
            return false;

        _units += qnt;
        _factor = factor;
        return true;
    }
}