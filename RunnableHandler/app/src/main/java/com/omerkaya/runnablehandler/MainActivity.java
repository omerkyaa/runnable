package com.omerkaya.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    int number;

    Runnable runnable;
    Handler handler;

    Button button; //start butonunu tanımladık.



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= findViewById(R.id.textView);

        button=findViewById(R.id.button);

        number=0;



    }
    public void start (View view){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                //yapmasını istediğim işlemi buraya yazıyorum.
                textView.setText("Time: " + number);
                //burda 0'dan başlayıp 1 ekleyerek ilerle dedik.
                number++;
                textView.setText("Time: " + number);

                handler.postDelayed(runnable, 1000);
                //üstte runnable'ı kaç saniyede bir yazması gerektiğini söyledik.

            }
        };
        handler.post(runnable); //burda da runnable'ı hand et demiş olduk.

        button.setEnabled(false); //bunu yazarsam starta bir kere bastıktan sonra tekrar basılmasını engelleriz.

    }

    public  void pause (View view) {

        button.setEnabled(true); //stop'a basınca startı tekrar işlevsel hale getirmiş olduk.

        handler.removeCallbacks(runnable); //stop'a basınca runnable'ı kapat demiş olduk.
    }

    public void stop (View view) {

        button.setEnabled(true); //stop'a basınca startı tekrar işlevsel hale getirmiş olduk.

        handler.removeCallbacks(runnable); //stop'a basınca runnable'ı kapat demiş olduk.

        number = 0; //tuşa basılınca sayıyı sıfırla
        textView.setText("Time: " + number); //tuşa basılınca ilk haline döndür.


    }




}