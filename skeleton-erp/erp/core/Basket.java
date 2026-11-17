package erp.core;

import java.io.Serializable;
import java.util.HashMap;
//FIXME maybe import classes

/**
 * A client's shopping basket at one company: what it intends to buy, and how it
 * wants the purchase shipped.
 *
 * <p>
 * The basket menu is opened <em>over</em> a basket, so this class is the
 * receiver of every command in {@code erp.app.basket}. Its name and package are
 * fixed by that code; its content is yours to define.
 * </p>
 */
public class Basket implements Serializable {

  @java.io.Serial
  private static final long serialVersionUID = 202608261200L;

  private HashMap<Product, Integer> _items;
  private final Client _client;
  private final Company _company;

  public Basket(Client client, Company company) {
    _client = client;
    _company = company;
    _items = new HashMap<Product, Integer>();
  }

  public Client getClient() {
    return _client;
  }

  public Company getCompany() {
    return _company;
  }

  public int productsInBasket(Product product) {
    return _items.get(product);
  }

  public int changeProduct(Product product, int qnt) {
    if (!(_items.containsKey(product))) {
    }
  }

  // FIXME maybe define attributes
  // FIXME maybe implement constructor
  // FIXME maybe implement methods
}
