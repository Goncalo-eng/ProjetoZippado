package erp.core;

import java.io.Serializable;
import java.util.HashMap;

public class Client implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = 202608261200L;

    private String _name;
    private String _email;
    private HashMap<Company, Basket> _baskets;

    public Client(String name, String email) {
        _name = name;
        _email = email;
    }

    public String getMail() {
        return _email;
    }

    public String getName() {
        return _name;
    }

    public Basket basketTo(Company company) {
        if (_baskets.containsKey(company))
            return _baskets.get(company);
        Basket basket = new Basket(this, company);
        _baskets.put(company, basket);
        return basket;
    }
}
