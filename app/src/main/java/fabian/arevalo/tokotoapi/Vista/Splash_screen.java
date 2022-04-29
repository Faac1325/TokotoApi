package fabian.arevalo.tokotoapi.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import fabian.arevalo.tokotoapi.Adaptadores.SliderAdapter;
import fabian.arevalo.tokotoapi.R;

public class Splash_screen extends AppCompatActivity {
     Button btnsplash;
     TextView tvtokoto,tvsplash;

    private RecyclerView recyclerView;
    private int[] images;
    private String[] text;
    private SliderAdapter adapter;
    private SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        btnsplash=findViewById(R.id.btnsplash);
        tvtokoto=findViewById(R.id.btnsplash);
        tvsplash=findViewById(R.id.tvsplash);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        sliderView = findViewById(R.id.sliderView);
        images = new int[]{R.drawable.splash_1, R.drawable.splash_2, R.drawable.splash_3};
        text = new String[]{"", "", ""};

        adapter = new SliderAdapter(images, text);
        sliderView.setSliderAdapter(adapter);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.startAutoCycle();


        //Este nos envia de Splash a MainActivity
        btnsplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Splash_screen.this, MainActivity.class);
                startActivity(i);
                onBackPressed();
            }
        });


    }
    //Bloquear atras
    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
    }


}