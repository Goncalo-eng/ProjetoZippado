package erp.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public abstract class Product implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = 202608261200L;

    private int _id;
    private String _name;
    private int _basePrice;
    private int _baseDeadline;
    private Category _category;
    private final List<Supply> _supplies = new ArrayList<>();

    public Product(
            int id, String name,
            int basePrice, Category category,
            int baseDeadline) {
        _id = id;
        _name = name;
        _basePrice = basePrice;
        _baseDeadline = baseDeadline;
        _category = category;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public int getBasePrice() {
        return _basePrice;
    }

    public Category getCategory() {
        return _category;
    }

    public int getBaseDeadline() {
        return _baseDeadline;
    }

    public abstract double getRecommendedPrice();

    public int getTotalUnits() {
        return _supplies.stream().mapToInt(Supply::getUnits).sum();
    }

    void addSupply(Supply s) {
        _supplies.add(s);
    }
}
