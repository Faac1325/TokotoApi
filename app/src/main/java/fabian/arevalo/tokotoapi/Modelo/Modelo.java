package fabian.arevalo.tokotoapi.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fabian.arevalo.tokotoapi.Conexionbd.AdminSQLiteOpenHelper;
import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Interfaces.ServicioApi;
import fabian.arevalo.tokotoapi.Vista.Inicio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Modelo implements Interfaces.ModeloRegistro, Interfaces.ModeloInicio {

    Interfaces.PresentadorRegistro presenter;
    Interfaces.PresentadorInicio presentadorInicio;
    private String msgError="";
    private Context context2;
    private Cursor fila;

    public Modelo(Interfaces.PresentadorRegistro presenter) {

        this.presenter = presenter;
    }

    public Modelo(Interfaces.PresentadorInicio presentadorInicio) {
        this.presentadorInicio = presentadorInicio;
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



    @Override
    public void recibirDatosRecuperar(String email,Context context) {

        context2=context;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "registros", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();


        if (email.isEmpty()) {
            msgError="El campo email está vacio";
            presenter.mostrarMensaje(msgError);
        } else{
            if(!isEmailValid(email)){
                msgError="Campo email invalido";
                presenter.mostrarMensaje(msgError);

            }else{
                Cursor fila = db.rawQuery("select correo,clave from userbd where correo='" + email + "'", null);

                if (fila.moveToFirst()) {

                    String correo = fila.getString(0);
                    String password = fila.getString(1);


                    if (correo.equals(email)) {
                        msgError="La contraseña es: "+password;
                        presenter.mostrarMensaje(msgError);


                    }
                }
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

    @Override
    public void recibirBusqueda(String q) {
        //Se buscan los datos con retrofit

        System.out.println("diego "+q);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServicioApi service=retrofit.create(ServicioApi.class);
        Call<Producto> call=service.obtenerProductos(q);

        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {

                if(!response.isSuccessful()){
                    /*procesoFallido();*/

                    return;
                }

                Producto datosProducto= response.body();
                ArrayList<ProductoResults> productos = datosProducto.getResults();

                if(datosProducto!=null){
                    presentadorInicio.procesoExitoso(productos);
                    System.out.println("Proceso exitoso!");

                }

            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
               /* procesoFallido();
                mensajeError();*/
            }
        });
    }
}
