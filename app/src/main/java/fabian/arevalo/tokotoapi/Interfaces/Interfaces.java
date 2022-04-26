package fabian.arevalo.tokotoapi.Interfaces;

import android.content.Context;
import android.provider.ContactsContract;
import android.provider.SearchRecentSuggestions;

public interface Interfaces {

    interface VistaRegistro {
        void mostrarMensaje(String msg);
    }

    interface PresentadorRegistro {
        void recibirDatos(String correo, String pass, String confirmPassm, Context context);
        void mostrarMensaje(String msg);

        void recibirDatosLogin(String email,String pass2,Context context);
    }

    interface ModeloRegistro{

        void recibirDatos(String correo, String pass, String confirmPass, Context context);

        void recibirDatosLogin(String email, String pass2, Context context);
    }
}
