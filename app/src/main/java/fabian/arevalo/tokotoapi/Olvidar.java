package fabian.arevalo.tokotoapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import fabian.arevalo.tokotoapi.Conexionbd.AdminSQLiteOpenHelper;
import fabian.arevalo.tokotoapi.Vista.MainActivity;

public class Olvidar extends AppCompatActivity {

    Button btnrecuperar,btnatrasolvidar;
    EditText emailolvidar;
    private Cursor fila;
    Bundle pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidar);

        btnrecuperar = findViewById(R.id.btnrecuperar);
        emailolvidar = findViewById(R.id.emailolvidar);
        btnatrasolvidar=findViewById(R.id.btnatrasolvidar);
        pass = getIntent().getExtras();


        btnatrasolvidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                onBackPressed();

            }
        });


    }

    public void recuperar(View view) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "registros", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String email = emailolvidar.getText().toString().trim();

        Cursor fila = db.rawQuery("select correo,clave from userbd where correo='" + email + "'", null);

            if (fila.moveToFirst()) {

                String correo = fila.getString(0);
                String password = fila.getString(1);

                if (correo.equals(email)) {

                    System.out.println("emel: " + password);

                    Toast.makeText(this, ""+password, Toast.LENGTH_SHORT).show();




                }
            }
    }



    //Bloquear atras
    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
    }







}