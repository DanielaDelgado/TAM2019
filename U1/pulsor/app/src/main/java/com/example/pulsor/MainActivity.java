package com.example.pulsor;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView principal;
    Button boton, numeritos;
    CountDownTimer timercito;
    float avance, cap, nfinal;
    String cadena1, cadena2, cadena3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        principal= findViewById(R.id.numero);
        boton=findViewById(R.id.boton);
        numeritos=findViewById(R.id.cuenta);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DecimalFormat df = new DecimalFormat("#.0");
                float random = (float) (Math.random()*3);
                cadena1 = df.format(random);
                principal.setText(""+cadena1);
                nfinal=Float.parseFloat(cadena1);

                timercito = new CountDownTimer(10000,300)	 {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        avance = (float) (avance+0.1);
                        cadena2 = df.format(avance);
                        numeritos.setText(""+cadena2);

                        if (avance>=2.9){
                            avance= (float) 0.0;
                        }

                    }

                    @Override
                    public void onFinish() {
                        timercito.start();

                    }
                };timercito.start();

            }
        });

        numeritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena3=cadena2;
                cap= Float.parseFloat(cadena3);
                if (nfinal==cap){
                    Toast.makeText(MainActivity.this,"¡LO LOGRASTE! ", Toast.LENGTH_LONG).show();
                    timercito.cancel();
                }else {

                    Toast.makeText(MainActivity.this, "SUERTE PARA LA PROXIMA", Toast.LENGTH_SHORT).show();
                    timercito.cancel();
                }


            }
        });

    }
}
