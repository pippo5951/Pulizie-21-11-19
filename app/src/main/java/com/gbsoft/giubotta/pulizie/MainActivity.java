package com.gbsoft.giubotta.pulizie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gbsoft.giubotta.pulizie.R.array.nomiA;
import static com.gbsoft.giubotta.pulizie.R.array.nomiB;
import static com.gbsoft.giubotta.pulizie.R.array.nomiBox;
import static com.gbsoft.giubotta.pulizie.R.array.nomiCortile;
import static com.gbsoft.giubotta.pulizie.R.layout.activity_main;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int mese,giorno,primo,scala,turno,num, numA, numB,num1,num2,num3,num4;
    private String temp="", dove, msg="devi inserire i dati richiesti!";
    private Button bt_invia,bt_home,btnSubmit, bt_salva;
    private CheckBox cb_31,cb_33,cb_box,cb_atrio,cb_corte,cb_altro,cb_martedi,cb_venerdi;
    private CheckBox cb_1,cb_2,cb_3,cb_4,cb_5,cb_6,cb_7,cb_8,cb_9,cb_10,cb_11,cb_12;
    private TextView textView,textView2,tv_nuovo, tv_Data,tv_primo_giorno;
    private Spinner spinner1, spinner2,spinner3,spinner4;
    private String Ascala,Bscala,Cortile,Box,miastringa;
    private EditText et_giorno,et_giorno1,et_giorno2;
    private LinearLayout ll_spunta,ll_atrio,ll_corte,ll_box;
    private String completo[]= {"Atrio","Cortile","Box Auto"};
    private String separa="----------------------------------------",scal;
    int parte1,parte2,parte3,parte4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        final String data = DateFormat.format("dd-MM-yyyy", new Date(System.currentTimeMillis())).toString();

        et_giorno = (EditText)findViewById(R.id.et_giorno);
        ll_spunta = (LinearLayout)findViewById(R.id.ll_spunta);
        ll_atrio = (LinearLayout)findViewById(R.id.ll_atrio);
        ll_corte = (LinearLayout)findViewById(R.id.ll_corte);
        ll_box = (LinearLayout)findViewById(R.id.ll_box);
        textView = (TextView)findViewById(R.id.textView);
        tv_Data = (TextView)findViewById(R.id.tv_Data);
        tv_primo_giorno = (TextView)findViewById(R.id.tv_primo_giorno);
        textView2 = (TextView)findViewById(R.id.textView2);
        tv_nuovo = (TextView)findViewById(R.id.tv_nuovo);
        et_giorno = (EditText)findViewById(R.id.et_giorno);
        et_giorno1 = (EditText)findViewById(R.id.et_giorno1);
        et_giorno2= (EditText)findViewById(R.id.et_giorno2);
        bt_invia = (Button)findViewById(R.id.bt_invia);
        bt_home = (Button)findViewById(R.id.bt_home);
        bt_salva = (Button)findViewById(R.id.bt_salva);


        cb_1 = (CheckBox)findViewById(R.id.cb_1);
        cb_2 = (CheckBox)findViewById(R.id.cb_2);
        cb_3 = (CheckBox)findViewById(R.id.cb_3);
        cb_4 = (CheckBox)findViewById(R.id.cb_4);
        cb_5 = (CheckBox)findViewById(R.id.cb_5);
        cb_6 = (CheckBox)findViewById(R.id.cb_6);
        cb_7 = (CheckBox)findViewById(R.id.cb_7);
        cb_8 = (CheckBox)findViewById(R.id.cb_8);
        cb_9 = (CheckBox)findViewById(R.id.cb_9);
        cb_10 = (CheckBox)findViewById(R.id.cb_10);
        cb_11 = (CheckBox)findViewById(R.id.cb_11);
        cb_12 = (CheckBox)findViewById(R.id.cb_12);

        cb_31 = (CheckBox)findViewById(R.id.cb_31);
        cb_33 = (CheckBox)findViewById(R.id.cb_33);
        cb_box = (CheckBox)findViewById(R.id.cb_box);
        cb_atrio = (CheckBox)findViewById(R.id.cb_atrio);
        cb_corte = (CheckBox)findViewById(R.id.cb_corte);
        cb_altro = (CheckBox)findViewById(R.id.cb_altro);
        cb_martedi = (CheckBox)findViewById(R.id.cb_martedi);
        cb_venerdi = (CheckBox)findViewById(R.id.cb_venerdi);

        // delegate
        cb_atrio.setOnClickListener(this);
        cb_corte.setOnClickListener(this);
        cb_box.setOnClickListener(this);
        cb_altro.setOnClickListener(this);
        cb_31.setOnClickListener(this);
        cb_33.setOnClickListener(this);
        cb_1.setOnClickListener(this);
        cb_2.setOnClickListener(this);
        cb_3.setOnClickListener(this);
        cb_4.setOnClickListener(this);
        cb_5.setOnClickListener(this);
        cb_6.setOnClickListener(this);
        cb_7.setOnClickListener(this);
        cb_8.setOnClickListener(this);
        cb_9.setOnClickListener(this);
        cb_10.setOnClickListener(this);
        cb_11.setOnClickListener(this);
        cb_12.setOnClickListener(this);
        cb_martedi.setOnClickListener(this);
        cb_venerdi.setOnClickListener(this);
        bt_invia.setOnClickListener(this);
        bt_home.setOnClickListener(this);
        bt_salva.setOnClickListener(this);


        cb_martedi.setVisibility(View.GONE);
        cb_venerdi.setVisibility(View.GONE);
        tv_primo_giorno.setVisibility(View.GONE);

        //all'apertura mostro a video il valore della preference
        //prefs = getSharedPreferences(MYIMP, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences=getSharedPreferences("MyData",Context.MODE_PRIVATE);
        miastringa =sharedPreferences.getString("name","0-0-0-0");
        String[] parte = miastringa.split("-");

        parte1 = parseInt (parte[0]);
        parte2 = parseInt (parte[1]);
        parte3 = parseInt (parte[2]);
        parte4 = parseInt (parte[3]);

        Resources res2 = getResources();
        String[] nomiA1 = res2.getStringArray(nomiA);
        String[] nomiB1 = res2.getStringArray(nomiB);
        String[] nomiCortile1 = res2.getStringArray(nomiCortile);
        String[] nomiBox1 = res2.getStringArray(nomiBox);

            Toast.makeText(this, "Crea nuovo calendario", Toast.LENGTH_SHORT).show();

            //tv_nuovo.setText("Scale 32: "+nomiA1[parte1]+" Scala 33: "+nomiB1[parte2]+"\nCortile : "+
                    //nomiCortile1[parte3]+" Box: "+nomiBox1[parte4]);

        tv_Data.setText("Oggi: "+data);

        ScelteMirate();
        nascondiCb();
        //addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }
    // add items into spinner dynamically
    public void addItemsOnSpinner2() {
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        List<String> list3 = new ArrayList<String>();
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter3);
    }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new seleziona_item());
    }
    // get the selected dropdown list value
    public void addListenerOnButton() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ascala = String.valueOf(spinner1.getSelectedItem());
                Bscala = String.valueOf(spinner2.getSelectedItem());
                btnSubmit.setEnabled( false );
                if (et_giorno.getText().toString().equals("")) {
                    StampaToast();
                } else {
                    bt_invia.setVisibility(View.VISIBLE);
                    // Scala A
                    if (Ascala.equals("BOTTA")) {
                        numA = 1;
                        num = 1;
                    } else if (Ascala.equals("MONTALTO") ) {
                        numA = 2;
                        num = 1;
                    } else if (Ascala.equals("SANTALUCIA") ) {
                        numA = 3;
                        num = 1;
                    } else if (Ascala.equals("PRESTIGIACOMO")) {
                        numA = 4;
                        num = 1;
                    } else if (Ascala.equals("FERNICOLA")) {
                        numA = 5;
                        num = 1;
                    } else if (Ascala.equals("MARTINO")) {
                        numA = 6;
                        num = 1;
                    } else if (Ascala.equals("CANE")) {
                        numA = 7;
                        num = 1;
                    } else if (Ascala.equals("MARMO")) {
                        numA = 8;
                        num = 1;
                    } else if (Ascala.equals("BUFALINO")) {
                        numA = 9;
                        num = 1;
                    } else if (Ascala.equals("SHIFANO")) {
                        numA = 10;
                        num = 1;
                    } else if (Ascala.equals("REPETTO") ) {
                        numA = 11;
                        num = 1;
                    } else if (Ascala.equals("INCORVAIA")) {
                        numA = 12;
                        num = 1;
                    }
                    // Scala B
                    if (Bscala.equals("SOARES")) {
                        numB = 1;
                    } else if (Bscala.equals("DATO")) {
                        numB = 2;
                    } else if (Bscala.equals("EL MALIANY")) {
                        numB = 3;
                    } else if (Bscala.equals("REVVA")) {
                        numB = 4;
                    } else if (Bscala.equals("BASILE")) {
                        numB = 5;
                    } else if (Bscala.equals("BOVALLAGA")) {
                        numB = 6;
                    } else if (Bscala.equals("CAMPANALE")) {
                        numB = 7;
                    } else if (Bscala.equals("MERCURIO")) {
                        numB = 8;
                    } else if (Bscala.equals("RITROVATO")) {
                        numB = 9;
                    } else if (Bscala.equals("NANTELE")) {
                        numB = 10;
                    } else if (Bscala.equals("MURVANA")) {
                        numB = 11;
                    } else if (Bscala.equals("NIGLIATO")) {
                        numB = 12;
                    }
                    Resources res = getResources();
                    String[] mesi = res.getStringArray(R.array.mesi);
                    giorno = parseInt(et_giorno.getText().toString());
                  if (scala==31) {textView.setText("Scala 31 : " + Ascala + " n° " + numA+"\n giorno inizio : "+giorno+" "+mesi[mese]+" "+dove);}
                  if (scala==33){ textView.setText("Scala 33 : " + Bscala + " n° " + numB+"\n giorno inizio : "+giorno+ " "+mesi[mese]+" "+dove);}
                }
            }
        });
    }

    private void sceltaMese() {
        Resources res = getResources();
        String[] mesi = res.getStringArray(R.array.mesi);
        if (dove.equals("garage")) {
            textView.setText("PULIZIE " + dove);
            }

        if (dove.equals("atrio")) {
            textView.setText("PULIZIE " + dove);}

        if (dove.equals("cortile")) {
            textView.setText("PULIZIE " + dove);}
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cb_atrio:
                defineAtrio();

                break;
            case R.id.cb_corte:
                ScelteMirate();
                bt_invia.setVisibility(View.VISIBLE);
                ll_corte.setVisibility(View.VISIBLE);
                btnSubmit.setVisibility(View.GONE);
                cb_venerdi.setVisibility(View.GONE);
                cb_martedi.setVisibility(View.GONE);
                tv_primo_giorno.setVisibility(View.GONE);
                dove = "cortile";
                sceltaMese();
                cb_atrio.setChecked(false);
                cb_box.setChecked(false);
                cb_altro.setChecked(false);
                break;
            case R.id.cb_box:
                ScelteMirate();
                ll_box.setVisibility(View.VISIBLE);
                bt_invia.setVisibility(View.VISIBLE);
                btnSubmit.setVisibility(View.GONE);
                cb_venerdi.setVisibility(View.GONE);
                cb_martedi.setVisibility(View.GONE);
                tv_primo_giorno.setVisibility(View.GONE);
                dove = "garage";
                sceltaMese();
                cb_atrio.setChecked(false);
                cb_corte.setChecked(false);
                cb_altro.setChecked(false);
                break;
            case R.id.cb_altro:
                ScelteMirate();
                bt_invia.setVisibility(View.VISIBLE);
                btnSubmit.setVisibility(View.VISIBLE);
                dove = "altro";
                sceltaMese();
                cb_atrio.setChecked(false);
                cb_corte.setChecked(false);
                cb_box.setChecked(false);
                break;
            case R.id.cb_31:
                scala = 31;
                mostraCb();
                btnSubmit.setVisibility(View.VISIBLE);
                ll_atrio.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.GONE);
                sceltaMese();
                cb_33.setChecked(false);
                break;
            case R.id.cb_33:
                scala = 33;
                mostraCb();
                btnSubmit.setVisibility(View.VISIBLE);
                ll_atrio.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.GONE);
                sceltaMese();
                cb_31.setChecked(false);
                break;
            case R.id.cb_1:
                mese = 0;
                sceltaMese();
                ControllaCb();
                cb_1.setChecked(true);
                break;
            case R.id.cb_2:
                mese = 1;
                sceltaMese();
                ControllaCb();
                cb_2.setChecked(true);
                break;
            case R.id.cb_3:
                mese = 2;
                sceltaMese();
                ControllaCb();
                cb_3.setChecked(true);
                break;
            case R.id.cb_4:
                mese = 3;
                sceltaMese();
                ControllaCb();
                cb_4.setChecked(true);
                break;
            case R.id.cb_5:
                mese = 4;
                sceltaMese();
                ControllaCb();
                cb_5.setChecked(true);
                break;
            case R.id.cb_6:
                mese = 5;
                sceltaMese();
                ControllaCb();
                cb_6.setChecked(true);
                break;
            case R.id.cb_7:
                mese = 6;
                sceltaMese();
                ControllaCb();
                cb_7.setChecked(true);
                break;
            case R.id.cb_8:
                mese = 7;
                sceltaMese();
                ControllaCb();
                cb_8.setChecked(true);
                break;
            case R.id.cb_9:
                mese = 8;
                sceltaMese();
                sceltaMese();
                ControllaCb();
                cb_9.setChecked(true);
                break;
            case R.id.cb_10:
                mese = 9;
                sceltaMese();
                ControllaCb();
                cb_10.setChecked(true);
                break;
            case R.id.cb_11:
                mese = 10;
                sceltaMese();
                ControllaCb();
                cb_11.setChecked(true);
                break;
            case R.id.cb_12:
                mese = 11;
                sceltaMese();
                ControllaCb();
                cb_12.setChecked(true);
                break;
            case R.id.cb_martedi:
                primo = 0;
                ControllaCb();
                cb_martedi.setChecked(true);
                cb_venerdi.setChecked(false);
                break;
            case R.id.cb_venerdi:
                primo = 1;
                cb_venerdi.setChecked(true);
                cb_martedi.setChecked(false);
                break;
            case R.id.bt_invia:
                btnSubmit.setVisibility(View.GONE);
                Resources res = getResources();
                String[] mesi = res.getStringArray(R.array.mesi);
                textView.setText("");
                textView.setText("PULIZIE " + dove + " mese di: " + mesi[mese] + " scala " + scala);

                if (dove.equals("garage")) {
                    StampaCalendarioBox();
                    bt_home.setText("Fine");
                    ll_spunta.setVisibility(View.GONE);
                }
                if (dove.equals("atrio")) {
                    StampaCalendarioAtrio();
                    if (scala==31){ bt_home.setText("Crea Atrio scala 33");
                        cb_31.setChecked(false);
                        //cb_33.setChecked(true);
                        btnSubmit.setEnabled( true );
                        mostraCb();
                    }
                    if (scala==33){ bt_home.setText("Crea Cortile");
                        cb_atrio.setChecked(false);
                        cb_33.setChecked(false);
                        cb_31.setChecked(false);
                    }
                }
                if (dove.equals("cortile")) {
                    StampaCalendarioCortile();
                    bt_home.setText("Crea Box Auto");
                    cb_corte.setChecked(false);
                }
                if (dove.equals("altro")) {
                }
                bt_home.setVisibility(View.VISIBLE);
                break;
                case R.id.bt_home:
                textView2.setText("");
                    bt_home.setText("Visualizza Tutto");
                    ll_spunta.setVisibility(View.VISIBLE);
                    if (dove.equals("atrio") || dove.equals("cortile")) {bt_home.setVisibility(View.GONE);}
                    if (dove.equals("garage")) {
                        bt_home.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Resources res = getResources();
                            String[] mesi = res.getStringArray(R.array.mesi);
                            textView.setText("PULIZIE LOTTO 14 mese di : "+ mesi[mese]);
                            textView2.setText(completo[0]+completo[1]+completo[2]);
                            ll_spunta.setVisibility(View.GONE);
                            bt_home.setVisibility(View.GONE);
                            bt_salva.setVisibility(View.VISIBLE);
                        }
                    });
                }
                    break;
            case R.id.bt_salva:
                //salvo il valore nelle preferenze
                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",num1 +"-"+num2+"-"+num3+"-"+num4);
                editor.putString("name2",completo[0]);
                editor.putString("name3",completo[1]);
                editor.putString("name4",completo[2]);
                editor.commit();

                Intent it = new Intent(MainActivity.this, AvvioActivity.class);
                startActivity(it);
                break;
        }
    }

    private void defineAtrio() {
        ScelteMirate();
        cb_31.setVisibility(View.VISIBLE);
        cb_33.setVisibility(View.VISIBLE);
        tv_primo_giorno.setVisibility(View.VISIBLE);
        dove = "atrio";
        sceltaMese();
        cb_corte.setChecked(false);
        cb_box.setChecked(false);
        cb_altro.setChecked(false);
    }

    // Stampa calendario Atrio
    private void StampaCalendarioAtrio() {
        if (et_giorno.getText().toString().equals("")) {
            StampaToast();
        } else {
            ScelteMirate();
            ll_spunta.setVisibility(View.GONE);
            textView2.setVisibility(View.VISIBLE);
            giorno = parseInt(et_giorno.getText().toString());
            if (scala==31){ turno = numA;
                scal="Atrio Scala 31";}
            if (scala==33){ turno = numB;
                scal="Atrio Scala 33";}
            turno--;
            // Stampo l'array nomiA[]
            Resources res = getResources();
            String[] mesi = res.getStringArray(R.array.mesi);
            String[] giorni = res.getStringArray(R.array.giorni);
            String[] nomiA1 = res.getStringArray(nomiA);
            String[] nomiB1 = res.getStringArray(nomiB);
            int nn = 0;
            for (int i = turno; i < 24; i++) {
                if (giorno > 31) {
                    break;
                }
                if (turno > 11) {
                    turno = 0;
                }
                if (nomiA1[turno].equals("Vuoto")){ turno++; }
                if (nomiB1[turno].equals("Vuoto")){ turno++; }
                if (giorno < 32) {
                    if (primo == 2) {
                        primo = 0;
                    }
                    if (scala == 31) {
                        temp = temp + giorni[primo] + " " + giorno + " " + mesi[mese] + " " + nomiA1[turno] + "\n";
                    }
                    if (scala == 33) {
                        temp = temp + giorni[primo] + " " + giorno + " " + mesi[mese] + " " + nomiB1[turno] + "\n";
                    }
                    primo++;
                    turno++;
                    if (nn == 1) {
                        nn = 0;
                        giorno = giorno + 3;
                    } else {
                        giorno = giorno + 4;
                        nn++;
                    }
                }
            }
            if (scala == 31){num1 =turno;}
            if (scala == 33){num2 = turno;}
        }
        completo[0]=  completo[0]+" "+scal+"\n"+temp+separa+"\n";
        textView2.setText(temp);
        temp="";
    }

    // Stampa calendario BoxAuto
    private void StampaCalendarioBox() {
        Box = String.valueOf(spinner4.getSelectedItem());
        ConvertiNomeNumero();
        if (et_giorno1.getText().toString().equals("")){
            StampaToast();
        }else{
            ScelteMirate();
            ll_spunta.setVisibility(View.GONE);
            textView2.setVisibility(View.VISIBLE);
            giorno = parseInt(et_giorno1.getText().toString());
            turno = num;
            turno--;

            // Stampo l'array nomiBox[]
            Resources res = getResources();
            String[] nomiBox1 = res.getStringArray(nomiBox);
            String[] mesi = res.getStringArray(R.array.mesi);
            String[] giorni = res.getStringArray(R.array.giorni);

            for (int  i = turno; i < 32; i++) {
                if (giorno > 31) { break; }
                if (turno >9){ turno=0; }
                if (nomiBox1[turno].equals("Vuoto")) { turno++; }
                if (nomiBox1[turno].equals("Vuoto")) { turno++; }
                if (nomiBox1[turno].equals("Vuoto")) { turno++; }
                if (nomiBox1[turno].equals("Vuoto")) { turno++; }
                if (turno >9){ turno=0; }
                temp = temp + giorni[2] + " " + giorno + " " + mesi[mese] + " " + nomiBox1[turno] + "\n";
                turno++;
                giorno = giorno + 14;
            }
            num4 = turno;
        }
        completo[2]=  completo[2]+"\n"+temp;
        textView2.setText(temp);
        temp="";
    }

    // Stampa calendario Cortile
    private void StampaCalendarioCortile() {
        if (et_giorno2.getText().toString().equals("")){
            StampaToast();
        }else{
            ScelteMirate();
            ll_spunta.setVisibility(View.GONE);
            textView2.setVisibility(View.VISIBLE);
            giorno = parseInt(et_giorno2.getText().toString());
            Cortile = String.valueOf(spinner3.getSelectedItem());
            ConvertiNomeInInterno();
            turno = num;
            turno--;

            // Stampo l'array nomiCortile[]
            Resources res = getResources();
            String[] nomiCortile1 = res.getStringArray(nomiCortile);
            String[] giorni = res.getStringArray(R.array.giorni);
            String[] mesi = res.getStringArray(R.array.mesi);
            for (int  i = turno; i < 40; i++) {
                if (giorno > 31) { break; }
                if (turno >23){ turno=0; }
                if (nomiCortile1[turno].equals("Vuoto")) { turno++; }
                temp = temp + giorni[2] + " " + giorno + " " + mesi[mese] + " " + nomiCortile1[turno] + "\n";
                turno++;
                giorno = giorno + 7;
            }
            num3 = turno;
        }
        completo[1]=  completo[1]+"\n"+temp+separa;
        textView2.setText(temp);
        temp="";
    }

    private void ConvertiNomeInInterno() {
        if (Cortile.equals("BOTTA")) {
            num = 1;
        } else if (Cortile.equals("MONTALTO")) {
            num = 2;
        } else if (Cortile.equals("SANTALUCIA")) {
            num = 3;
        } else if (Cortile.equals("PRESTIGIACOMO")) {
            num = 4;
        } else if (Cortile.equals("FERNICOLA")) {
            num = 5;
        } else if (Cortile.equals("MARTINO")) {
            num = 6;
        } else if (Cortile.equals("CANE")) {
            num = 7;
        } else if (Cortile.equals("MARMO")) {
            num = 8;
        } else if (Cortile.equals("BUFALINO")) {
            num = 9;
        } else if (Cortile.equals("SHIFANO")) {
            num = 10;
        } else if (Cortile.equals("REPETTO")) {
            num = 11;
        } else if (Cortile.equals("INCORVAIA")) {
            num = 12;
        } else if (Cortile.equals("SOARES")) {
            num = 13;
        } else if (Cortile.equals("DATO")) {
            num= 14;
        } else if (Cortile.equals("EL MALIANY")) {
            num = 15;
        } else if (Cortile.equals("REVVA")) {
            num = 16;
        } else if (Cortile.equals("BASILE")) {
            num = 17;
        } else if (Cortile.equals("BOVALLAGA")) {
            num = 18;
        } else if (Cortile.equals("CAMPANALE")) {
            num = 19;
        } else if (Cortile.equals("Vuoto")) {
            num = 20;
        } else if (Cortile.equals("RITROVATO")) {
            num = 21;
        } else if (Cortile.equals("NANTELE")) {
            num = 22;
        } else if (Cortile.equals("MURVANA")) {
            num = 23;
        } else if (Cortile.equals("NIGLIATO")) {
            num = 24;
        }
    }
    private void ConvertiNomeNumero() {
        if (Box.equals("NANTELE")) {
            num = 1;
        } else if (Box.equals("MARMO")) {
            num = 2;
        } else if (Box.equals("MARTINO")) {
            num = 3;
        } else if (Box.equals("BOTTA")) {
            num = 4;
        } else if (Box.equals("DATO")) {
            num = 5;
        } else if (Box.equals("BUFALINO")) {
            num = 6;
        } else if (Box.equals("Vuoto")) {
            num = 7;
        } else if (Box.equals("Vuoto")) {
            num = 8;
        } else if (Box.equals("Vuoto")) {
            num = 9;
        } else if (Box.equals("Vuoto")) {
            num = 10;
        }
    }


    private void ScelteMirate() {
        ll_box.setVisibility(View.GONE);// nasconde il layuot box lasciando il posto vuoto
        ll_atrio.setVisibility(View.GONE);// nasconde il layuot atrio lasciando il posto vuoto
        ll_corte.setVisibility(View.GONE);// nasconde il layuot cortile lasciando il posto vuoto
        bt_invia.setVisibility(View.GONE);// nasconde bottone lasciando il posto vuoto
        textView2.setVisibility(View.GONE);// nasconde  il testo lasciando il posto vuoto
        bt_home.setVisibility(View.GONE);
    }

    private void StampaToast() {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void ControllaCb() {
        cb_1.setChecked(false);//toglie la spunta alle ceckBox
        cb_2.setChecked(false);
        cb_3.setChecked(false);
        cb_4.setChecked(false);
        cb_5.setChecked(false);
        cb_6.setChecked(false);
        cb_7.setChecked(false);
        cb_8.setChecked(false);
        cb_9.setChecked(false);
        cb_10.setChecked(false);
        cb_11.setChecked(false);
        cb_12.setChecked(false);
    }
    private void  nascondiCb(){
        cb_1.setVisibility(View.GONE);
        cb_2.setVisibility(View.GONE);
        cb_3.setVisibility(View.GONE);
        cb_4.setVisibility(View.GONE);
        cb_5.setVisibility(View.GONE);
        cb_6.setVisibility(View.GONE);
        cb_7.setVisibility(View.GONE);
        cb_8.setVisibility(View.GONE);
        cb_9.setVisibility(View.GONE);
        cb_10.setVisibility(View.GONE);
        cb_11.setVisibility(View.GONE);
        cb_12.setVisibility(View.GONE);
        cb_31.setVisibility(View.GONE);
        cb_33.setVisibility(View.GONE);

    }
    private void mostraCb(){
        cb_1.setVisibility(View.VISIBLE);
        cb_2.setVisibility(View.VISIBLE);
        cb_3.setVisibility(View.VISIBLE);
        cb_4.setVisibility(View.VISIBLE);
        cb_5.setVisibility(View.VISIBLE);
        cb_6.setVisibility(View.VISIBLE);
        cb_7.setVisibility(View.VISIBLE);
        cb_8.setVisibility(View.VISIBLE);
        cb_9.setVisibility(View.VISIBLE);
        cb_10.setVisibility(View.VISIBLE);
        cb_11.setVisibility(View.VISIBLE);
        cb_12.setVisibility(View.VISIBLE);
        cb_31.setVisibility(View.VISIBLE);
        cb_33.setVisibility(View.VISIBLE);
        cb_martedi.setVisibility(View.VISIBLE);
        cb_venerdi.setVisibility(View.VISIBLE);
    }

    private void Crea_Atrio_Scala_33(){
        scala = 33;
        btnSubmit.setVisibility(View.VISIBLE);
        ll_atrio.setVisibility(View.VISIBLE);
        spinner2.setVisibility(View.VISIBLE);
        spinner1.setVisibility(View.GONE);
    }
}
