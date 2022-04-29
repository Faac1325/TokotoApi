package fabian.arevalo.tokotoapi.Presentador;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Modelo.Category;
import fabian.arevalo.tokotoapi.Modelo.Modelo;
import fabian.arevalo.tokotoapi.Modelo.ProductoResults;
import fabian.arevalo.tokotoapi.Vista.Inicio;

public class Presentador implements Interfaces.PresentadorRegistro, Interfaces.PresentadorInicio {

    Interfaces.VistaRegistro view;
    Interfaces.VistaInicio view2;
    Interfaces.ModeloRegistro model;
    Interfaces.ModeloInicio model2;

    public Presentador(Interfaces.VistaRegistro view) {
        this.view = view;
        this.model= new Modelo((Interfaces.PresentadorRegistro) this);
    }

    public Presentador(Interfaces.VistaInicio view2) {
        this.view2 = view2;
        this.model2= new Modelo((Interfaces.PresentadorInicio) this);
    }

    @Override
    public void recibirDatos(String correo, String pass, String confirmPass, Context context) {
        model.recibirDatos(correo,pass,confirmPass,context);

    }

    @Override
    public void mostrarMensaje(String msg) {
        view.mostrarMensaje(msg);
    }

    @Override
    public void recibirDatosLogin(String email, String pass2, Context context) {
        model.recibirDatosLogin(email,pass2,context);
    }

    @Override
    public void recibirDatosRecuperar(String email, Context context) {
        model.recibirDatosRecuperar(email,context);

    }

    @Override
    public void recibirBusqueda(String q) {
        model2.recibirBusqueda(q);
    }

    @Override
    public void procesoExitoso(ArrayList<ProductoResults> productos) {
        view2.mostrarProductos(productos);

    }

    @Override
    public void requestCategorias(String id_pais) {
        model2.requestCategorias(id_pais);
    }

    @Override
    public void successfulQuery(List<Category> categories) {
        view2.successfulQuery(categories);
    }
}
