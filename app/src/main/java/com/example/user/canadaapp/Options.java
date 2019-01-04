package com.example.user.canadaapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Cette classe construit l'interface qui
 * présente les rubriques d'informations disponibles
 * pour chacune des provinces
 */

public class Options extends AppCompatActivity {

    // Intance de la classe MainActivity
    MainActivity mainActivity = new MainActivity();

    String[] mesProvinces = mainActivity.nomProvinces;

    public static String getProvince_Choisie() {
        return province_Choisie;
    }

    private static String province_Choisie;

    ListView listViewProvinces;
    // Tableau des rubriques d'informations
    String[] mesOptions = {
            "Actualités",
            "Histoire",
            "Météo",
            "Carte",
            "Taxes",

    };
    //tableau des icônes
    int[] icones = {R.drawable.actualite, R.drawable.histoire, R.drawable.meteo,
            R.drawable.carte, R.drawable.taxe,};

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int x = mainActivity.getIndexClick();
        province_Choisie = mesProvinces[x];
        switch (x) {

            case 0:
                getSupportActionBar().setTitle("Alberta");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

            case 1:
                getSupportActionBar().setTitle("Colombie Britannique");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

            case 2:
                getSupportActionBar().setTitle("Ile du Prince Edouard");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;


            case 3:
                getSupportActionBar().setTitle("Manitoba");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

            case 4:
                getSupportActionBar().setTitle("Nouvelle Ecosse");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;


            case 5:
                getSupportActionBar().setTitle("Nouveau Brunswick");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

            case 6:
                getSupportActionBar().setTitle("Nunavut");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

            case 7:
                getSupportActionBar().setTitle("Ontario");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

            case 8:
                getSupportActionBar().setTitle("Québec");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

            case 9:
                getSupportActionBar().setTitle("Saskachewan");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

            case 10:
                getSupportActionBar().setTitle("Terre Neuve et Labrardor");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

            case 11:
                getSupportActionBar().setTitle("Territoires du Nord Ouest");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;


            case 12:
                getSupportActionBar().setTitle("Yukon");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                break;

        }


        setContentView(R.layout.activity_options);
        listViewProvinces = (ListView) findViewById(R.id.option_list);
        ListProvinces listProvinces = new ListProvinces(Options.this, mesOptions,
                icones);
        listViewProvinces.setAdapter(listProvinces);

        listViewProvinces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case (0):
                        Intent intent1 = new Intent(getApplicationContext(), Actualite.class);
                        startActivity(intent1);
                        break;
                    case (1):
                        Intent intent2 = new Intent(getApplicationContext(), Histoire.class);
                        startActivity(intent2);
                        break;
                    case (2):
                        Intent intent3 = new Intent(getApplicationContext(), Meteo.class);
                        startActivity(intent3);
                        break;
                    case (3):
                        Intent intent5 = new Intent(getApplicationContext(), Carte.class);
                        startActivity(intent5);
                        break;
                    case (4):
                        Intent intent6 = new Intent(getApplicationContext(), Taxe.class);
                        startActivity(intent6);
                        break;


                }

            }
        });

    }


}