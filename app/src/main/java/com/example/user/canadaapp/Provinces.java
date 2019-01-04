package com.example.user.canadaapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Cette classes crée un adpater pour la listView de l'activité MainActivity.
 */

public class Provinces extends ArrayAdapter<String> {

    String[] provinces;
    int[] drapeaux;
    Context mContext;


    public Provinces(Context context,
                         String[] nomProvinces, int[] coulDrapeaux) {

        super(context, R.layout.liste_prov_items);

        this.provinces = nomProvinces;
        this.drapeaux = coulDrapeaux;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return provinces.length;
    }

    /**
     * @param position    :position dans la liste
     * @param convertView : objet view
     * @param parent      : nom du viewGroup
     * @return : valeur de retour
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder objetEnVue = new ViewHolder();

        if (convertView == null) {
            LayoutInflater monInflateur = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = monInflateur.inflate(R.layout.liste_prov_items, parent,
                    false);

            objetEnVue.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            objetEnVue.textView = (TextView) convertView.findViewById(R.id.textView_province);

            convertView.setTag(objetEnVue);
        } else {
            objetEnVue = (ViewHolder) convertView.getTag();
        }
        objetEnVue.imageView.setImageResource(drapeaux[position]);
        objetEnVue.textView.setText(provinces[position]);
        return convertView;
    }


}