package erp.core;

import java.io.Serializable;

class Category implements Serializable {
    private String _name;

    public Category(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Category c && _name.equalsIgnoreCase(c._name);
    }

    @Override
    public int hashCode() {
        return _name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return _name;
    }
}