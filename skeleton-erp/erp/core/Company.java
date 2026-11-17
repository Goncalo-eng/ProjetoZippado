package erp.core;

import java.util.TreeMap;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = 202608261200L;

    private int _id;
    private String _name;
    private TreeMap<Integer, Supply> _supplies;

    public Company(int id, String name) {
        _id = id;
        _name = name;
        _supplies = new TreeMap<Integer, Supply>();
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public boolean changeInventory(Product product, int qnt, double factor) {
        Supply supply = _supplies.get(product.getId());

        if (this.hasSupply(product))
            return supply.change(qnt, factor);

        if (qnt <= 0 || factor <= 0)
            return false;

        _supplies.put(product.getId(), new Supply(qnt, factor, product, this));
        return true;

    }

    public boolean hasSupply(Product product) {
        return _supplies.containsKey(product.getId());
    }

    public List<Supply> getSuppliedProducts() {
        return new ArrayList<Supply>(_supplies.values());
    }

    public double getSalePrice(Product product) {
        Supply supply = _supplies.get(product.getId());
        return supply.getSalePrice();
    }
}
