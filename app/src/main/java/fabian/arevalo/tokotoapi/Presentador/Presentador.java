package fabian.arevalo.tokotoapi.Presentador;

import android.content.Context;

import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Modelo.Modelo;

public class Presentador implements Interfaces.PresentadorRegistro {

    Interfaces.VistaRegistro view;
    Interfaces.ModeloRegistro model;

    public Presentador(Interfaces.VistaRegistro view) {
        this.view = view;
        this.model= new Modelo(this);
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
}
