package fabian.arevalo.tokotoapi.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import fabian.arevalo.tokotoapi.Conexionbd.AdminSQLiteOpenHelper;
import fabian.arevalo.tokotoapi.Interfaces.Interfaces;

public class Modelo implements Interfaces.ModeloRegistro {

    Interfaces.PresentadorRegistro presenter;
    private String msgError="";
    private Context context2;

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

}
