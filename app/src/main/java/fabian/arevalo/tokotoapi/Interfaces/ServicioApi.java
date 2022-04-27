package fabian.arevalo.tokotoapi.Interfaces;

import fabian.arevalo.tokotoapi.Modelo.Producto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServicioApi {


    @GET("sites/MCO/search?q=")
    Call<Producto> obtenerProductos(@Query("q") String q);
}
