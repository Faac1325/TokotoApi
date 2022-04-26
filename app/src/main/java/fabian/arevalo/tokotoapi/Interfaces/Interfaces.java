package fabian.arevalo.tokotoapi.Interfaces;

import android.content.Context;
import android.provider.ContactsContract;

public interface Interfaces {

    interface VistaRegistro {
        void mostrarMensaje(String msg);

    }
    interface PresentadorRegistro {

        void recibirDatos(String correo, String pass, String confirmPassm, Context context);
        void mostrarMensaje(String msg);

    }
    interface ModeloRegistro{

        void recibirDatos(String correo, String pass, String confirmPass, Context context);
    }
}
