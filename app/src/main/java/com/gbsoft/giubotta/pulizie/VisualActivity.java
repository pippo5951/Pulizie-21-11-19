package com.gbsoft.giubotta.pulizie;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class VisualActivity extends AppCompatActivity {

    private final static String DEFAULT = "Calendario non esistente";
    private TextView textView, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);

        //all'apertura mostro a video il valore della preference
        SharedPreferences sharedPreferences=getSharedPreferences("MyData",Context.MODE_PRIVATE);
        String name2=sharedPreferences.getString("name2",DEFAULT);
        String name3=sharedPreferences.getString("name3",DEFAULT);
        String name4=sharedPreferences.getString("name4",DEFAULT);


            textView.setText(name2);
            textView2.setText(name3);
            textView3.setText(name4);

    }
}
