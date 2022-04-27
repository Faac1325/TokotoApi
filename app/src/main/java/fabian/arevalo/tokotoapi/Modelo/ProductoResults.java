package fabian.arevalo.tokotoapi.Modelo;

import java.util.ArrayList;

public class ProductoResults {
    private String title;
    private String price;
    private String available_quantity;
    private String thumbnail;

    ArrayList<ProductoAttributes> attributes;

    public ArrayList<ProductoAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<ProductoAttributes> attributes) {
        this.attributes = attributes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(String available_quantity) {
        this.available_quantity = available_quantity;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
