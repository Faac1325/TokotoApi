package fabian.arevalo.tokotoapi.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import fabian.arevalo.tokotoapi.Conexionbd.AdminSQLiteOpenHelper;
import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Vista.Inicio;

public class Modelo implements Interfaces.ModeloRegistro {

    Interfaces.PresentadorRegistro presenter;
    private String msgError="";
    private Context context2;
    private Cursor fila;

    public Modelo(Interfaces.PresentadorRegistro presenter) {

        this.presenter = presenter;
    }

    @Override
    public void recibirDatos(String correo, String pass, String confirmPass, Context context) {

        context2=context;
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(context,"registros", null, 1);
        SQLiteDatabase db= admin.getWritableDatabase();



                    if (correo.isEmpty()) {
                        msgError="El campo email está vacio";
                        presenter.mostrarMensaje(msgError);
                    } else{
                        if(!isEmailValid(correo)){
                            msgError="Campo email invalido";
                            presenter.mostrarMensaje(msgError);

                        }else{
                            if (!validarcorreo(correo)) {
                                msgError="Ingrese otro email";
                                presenter.mostrarMensaje(msgError);

                            }else{
                                if (pass.trim().isEmpty()) {
                                    msgError="El campo contraseña está vacio";
                                    presenter.mostrarMensaje(msgError);

                                }else{
                                    if (confirmPass.isEmpty()) {
                                        msgError="El campo contraseña está vacio";
                                        presenter.mostrarMensaje(msgError);

                                    }else{
                                        if (!pass.equals(confirmPass)) {
                                            msgError="las contraseñas no coinciden";
                                            presenter.mostrarMensaje(msgError);

                                        }else{
                                            if (pass.length()<6 && confirmPass.length()<6){
                                                msgError="las contraseñas deben tener mas de 6 caracteres";
                                                presenter.mostrarMensaje(msgError);

                                            }else{

                                                ContentValues registro = new ContentValues();
                                                registro.put("correo", correo);
                                                registro.put("clave", pass);
                                                db.insert("userbd", null, registro);
                                                db.close();
                                                msgError="Usuario registrado exitosamente";
                                                presenter.mostrarMensaje(msgError);


                                            }

                                        }
                                    }
                                }
                            }

                        }
                    }


    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean validarcorreo(String email) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context2, "registros", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();


        Cursor fila = db.rawQuery("select correo from userbd where correo='" + email + "'", null);
        try {
            if (fila.moveToFirst()) {
                String correo = fila.getString(0);
                if (correo.equals(email)) {
                    msgError="El correo ya esta registrado";
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return true;
    }
    @Override
    public void recibirDatosLogin(String email, String pass2, Context context) {

        context2=context;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "registros", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if(validarcampos(email,pass2)){
            fila = db.rawQuery("select correo, clave from userbd where correo='" + email + "' and clave='" + pass2 + "'", null);
            try {
                //busca por registro
                if (fila.moveToFirst()) {
                    String correo = fila.getString(0);
                    String clave = fila.getString(1);


                    if (email.equals(correo) && pass2.equals(clave)) {
                        msgError="Bienvenido";
                        presenter.mostrarMensaje(msgError);

                    }
                } else {
                    msgError="Datos incorrectos";
                    presenter.mostrarMensaje(msgError);
                }
            } catch (Exception e) {
                msgError="Error";
                presenter.mostrarMensaje(msgError);
            }
        }

    }

    private boolean validarcampos(String campo1, String campo2) {

        boolean camposllenos = true;
        if (campo1.trim().isEmpty()) {
            camposllenos = false;
            msgError="Campo email vacio";
            presenter.mostrarMensaje(msgError);

        }
        if (campo2.trim().isEmpty()) {
            camposllenos = false;
            msgError="Campo de contraseña vacio";
            presenter.mostrarMensaje(msgError);
        }
        return camposllenos;
    }

}
