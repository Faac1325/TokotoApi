package fabian.arevalo.tokotoapi.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fabian.arevalo.tokotoapi.Adaptadores.AdaptadorHistorial;
import fabian.arevalo.tokotoapi.Conexionbd.AdminSQLiteOpenHelper;
import fabian.arevalo.tokotoapi.Modelo.ListHistorial;
import fabian.arevalo.tokotoapi.R;

public class Historial extends AppCompatActivity {
    List<ListHistorial> elehistorial;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "registros", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        fila = db.rawQuery("select nombre, precio, foto from histouser ", null);


        elehistorial = new ArrayList<>();

        while (fila.moveToNext()) {

            elehistorial.add(new ListHistorial(fila.getString(0), fila.getString(1),fila.getString(2)));

        }
        AdaptadorHistorial listadapHistorial = new AdaptadorHistorial(elehistorial, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listadapHistorial);
        Collections.reverse(elehistorial);

    }
}