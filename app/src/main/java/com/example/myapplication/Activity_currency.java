package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Activity_currency extends AppCompatActivity {
    private Document doc;
    private Thread secThread;
    private Runnable runnable;
    TextView tv_Dollar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        tv_Dollar = findViewById(R.id.tv_dollar);


        init();
    }

    private void getWeb() {
        try {
            doc = Jsoup.connect("http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002").get();
//            tv_Dollar.setText(doc.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Запускаем второстепенный поток для подключения к интернету. !! В главном потоке нельзя выполнять
    // трудоемкие операции
    private void init () {
        runnable = new Runnable() {
            @Override
            public void run() {
                // Здесь и будет запускаться код во втором потоке
                getWeb();
            }
        };
        secThread = new Thread(runnable);
        secThread.start();
    }
}