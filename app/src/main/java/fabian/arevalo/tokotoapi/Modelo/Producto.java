package fabian.arevalo.tokotoapi.Modelo;

import java.util.ArrayList;

public class Producto {

    //dentro de result esta atributes en pagina mercadolibre
    //creo un arraylist y lo llamo results y va ser de tipo productoResult
    ArrayList<ProductoResults> results;

    public ArrayList<ProductoResults> getResults() {

        return results;
    }

    public void setResults(ArrayList<ProductoResults> results) {

        this.results = results;
    }
}
