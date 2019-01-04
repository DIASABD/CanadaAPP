package com.example.user.canadaapp;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
/*
Classe de l'activité histoire
 */

public class Histoire extends AppCompatActivity {

    TextView textView_hist;

    ListActuAdapter.MainActivity mainActivity = new ListActuAdapter.MainActivity();

    static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_histoire);

        i = mainActivity.getIndexClick();
        textView_hist = (TextView) findViewById(R.id.histoire);

        switch (i) {

            case 0:
                lireFichier("Alberta", textView_hist);
                break;

            case 1:
                lireFichier("Colombie_Britannique", textView_hist);
                break;

            case 2:
                lireFichier("Ile_du_Prince_Edouard", textView_hist);
                break;

            case 3:
                lireFichier("Manitoba", textView_hist);
                break;

            case 4:
                lireFichier("Nouvelle_Ecosse", textView_hist);
                break;

            case 5:
                lireFichier("Nouveau_Brunswick", textView_hist);
                break;

            case 6:
                lireFichier("Nunavut", textView_hist);
                break;

            case 7:
                lireFichier("Ontario", textView_hist);
                break;

            case 8:
                lireFichier("Quebec", textView_hist);
                break;

            case 9:
                lireFichier("Saskachewan", textView_hist);
                break;

            case 10:
                lireFichier("Terre_Neuve_et_Labrardor", textView_hist);
                break;

            case 11:
                lireFichier("Terre_du_Nord_Ouest", textView_hist);
                break;

            case 12:
                lireFichier("Yukon", textView_hist);
                break;
        }
        getSupportActionBar().setTitle("Histoire");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
    }

    /**
     * @param clef
     * @param txtContent
     */
    public void lireFichier(String clef, TextView txtContent) {
        String text = "";
        try {
            InputStream inputStream = getAssets().open(clef);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        txtContent.setText(text);

    }
}

