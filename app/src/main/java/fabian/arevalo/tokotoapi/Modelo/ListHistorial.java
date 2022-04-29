package fabian.arevalo.tokotoapi.Modelo;

public class ListHistorial {
    public String nombreProducto;
    public String precio;
    public String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ListHistorial(String nombreProducto, String precio, String imagen) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.imagen= imagen;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
