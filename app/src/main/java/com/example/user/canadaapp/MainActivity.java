package com.example.user.canadaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



/**
 * Cette classe construit l'interface qui
 * présente la liste des Provinces et térritoires
 */
public class MainActivity extends Activity {

    // index du view cliqué
    private static int indexClick;
    // tableau des noms de provinces
    String nomProvinces[] = {
            "Alberta",
            "Colombie Britannique",
            "Ile du Prince Edouard",
            "Manitoba",
            "Nouvelle Ecosse",
            "Nouveau Brunswick",
            "Nunavut",
            "Ontario",
            "Québec",
            "Saskachewan",
            "Terre Neuve et Labrardor",
            "Territoires du Nord Ouest",
            "Yukon"
    };
    // tableau des drapeau de province
    int[] drapeauxProvinces = {

            R.drawable.alberta,
            R.drawable.british_colombia,
            R.drawable.ile_prince_edward,
            R.drawable.manitoba,
            R.drawable.nw_brunswick,
            R.drawable.nw_scotia,
            R.drawable.nnvt,
            R.drawable.ontario,
            R.drawable.quebec,
            R.drawable.saskatchewan,
            R.drawable.newfoundland,
            R.drawable.ntw,
            R.drawable.yukon
    };


    public int getIndexClick() {
        return indexClick;
    }

    public void setIndexClick(int indexClick) {
        this.indexClick = indexClick;
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listViewProvinces = (ListView) findViewById(R.id.listewiew_main);
        Provinces listProvinces = new Provinces(MainActivity.this, nomProvinces, drapeauxProvinces);
        listViewProvinces.setAdapter(listProvinces);
        listViewProvinces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Met à jour indexClick
                setIndexClick(i);
                // instance de la classe Options
                Intent intent = new Intent(getApplicationContext(), Options.class);
                startActivity(intent);
            }
        });

    }

}


