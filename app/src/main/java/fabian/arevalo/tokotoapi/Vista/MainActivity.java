package fabian.arevalo.tokotoapi.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fabian.arevalo.tokotoapi.R;

public class MainActivity extends AppCompatActivity {
    EditText etmail,etpass;
    Button btnlogin;
    TextView tvinscribete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etmail=findViewById(R.id.etmail);
        etpass=findViewById(R.id.etpass);
        btnlogin=findViewById(R.id.btnlogin);
        tvinscribete=findViewById(R.id.tvinscribete);

        //Este nos envia de MainActivity a Registro
        tvinscribete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);
                onBackPressed();
            }
        });
    }
}