package com.gbsoft.giubotta.pulizie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AvvioActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNuovo,btnCarica;
    TextView textView5;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avvio);


        textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setText(("Turni Pulizie Lotto 14"+(Html.fromHtml(getString(R.string.MIA_Stringa).replace("!", "<").replace("@", ">")))));
        btnNuovo = (Button)findViewById(R.id.btnNuovo);
        btnCarica = (Button)findViewById(R.id.btnCarica);




        btnNuovo.setOnClickListener(this);
        btnCarica.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNuovo:
                Intent it = new Intent(AvvioActivity.this, MainActivity.class);
                startActivity(it);
                break;
            case R.id.btnCarica:
                it = new Intent(AvvioActivity.this, VisualActivity.class);
                startActivity(it);

        }
    }
}
