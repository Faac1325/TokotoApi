package fabian.arevalo.tokotoapi.Modelo;

import java.io.Serializable;

public class ProductoAttributes implements Serializable {
    private String value_name;
    private String name;


    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
