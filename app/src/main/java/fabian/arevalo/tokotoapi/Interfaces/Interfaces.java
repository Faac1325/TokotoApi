package fabian.arevalo.tokotoapi.Interfaces;

import android.content.Context;
import android.provider.ContactsContract;
import android.provider.SearchRecentSuggestions;

import java.util.ArrayList;
import java.util.List;

import fabian.arevalo.tokotoapi.Modelo.Category;
import fabian.arevalo.tokotoapi.Modelo.ProductoResults;

public interface Interfaces {

    interface VistaRegistro {
        void mostrarMensaje(String msg);
    }

    interface PresentadorRegistro {
        void recibirDatos(String correo, String pass, String confirmPassm, Context context);
        void mostrarMensaje(String msg);

        void recibirDatosLogin(String email,String pass2,Context context);
        void recibirDatosRecuperar(String email,Context context);
    }

    interface ModeloRegistro{

        void recibirDatos(String correo, String pass, String confirmPass, Context context);
        void recibirDatosLogin(String email, String pass2, Context context);

        void recibirDatosRecuperar(String email,Context context);
    }
    interface VistaInicio {
        void enviarBusqueda(String q);
        void mostrarProductos(ArrayList<ProductoResults> productos);
       void  requestCategorias(String id_pais);
        void successfulQuery(List<Category> categories);
    }

    interface PresentadorInicio {
        void recibirBusqueda(String q);
        void procesoExitoso(ArrayList<ProductoResults> productos);
        void  requestCategorias(String id_pais);
        void successfulQuery(List<Category> categories);
    }

    interface ModeloInicio{
        void recibirBusqueda(String q);
        void  requestCategorias(String id_pais);
        void successfulQuery(List<Category> categories);

    }
}
