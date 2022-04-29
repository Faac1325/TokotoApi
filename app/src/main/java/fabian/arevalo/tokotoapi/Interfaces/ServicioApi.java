package fabian.arevalo.tokotoapi.Interfaces;

import java.util.List;

import fabian.arevalo.tokotoapi.Modelo.Category;
import fabian.arevalo.tokotoapi.Modelo.Producto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicioApi {


    @GET("sites/MCO/search?q=")
    Call<Producto> obtenerProductos(@Query("q") String q);

    @GET("/sites/{id}/categories")
    Call<List<Category>> getCategory(@Path("id") String id);

}
