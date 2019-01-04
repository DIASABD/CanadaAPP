package com.example.user.canadaapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classes crée un adpater pour la listView de l'activité Actualités.
 */

public class ListActuAdapter extends BaseAdapter {

    private Activity activite;
    private ArrayList<HashMap<String, String>> data;

    public ListActuAdapter(Activity acti, ArrayList<HashMap<String, String>> d) {
        activite = acti;
        data = d;
    }

    // Retourne la taille de la liste
    public int getCount() {
        return data.size();
    }

    // Retour un objet item de la liste
    public Object getItem(int position) {
        return position;
    }

    // retourne un id de l'item de la liste
    public long getItemId(int position) {
        return position;
    }

    /**
     * @param position    :position dans la liste
     * @param convertView : objet view
     * @param parent      : nom du viewGroup
     * @return : valeur de retour
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ListActuViewHolder holder = null;
        if (convertView == null) {
            holder = new ListActuViewHolder();
            convertView = LayoutInflater.from(activite).inflate(
                    R.layout.liste_actu, parent, false);
            holder.galleryImage = (ImageView) convertView.findViewById(R.id.galleryImage);
            ;
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.sdetails = (TextView) convertView.findViewById(R.id.sdetails);
            convertView.setTag(holder);
        } else {
            holder = (ListActuViewHolder) convertView.getTag();
        }
        holder.galleryImage.setId(position);
        holder.title.setId(position);
        holder.sdetails.setId(position);
        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        try {
            //  Titre de l'actualié
            holder.title.setText(song.get(Actualite.KEY_TITLE));
            //Description de l'actualité
            holder.sdetails.setText(song.get(Actualite.KEY_DESCRIPTION));

            if (song.get(Actualite.KEY_URLTOIMAGE).toString().length() < 5) {
                holder.galleryImage.setVisibility(View.GONE);
            } else {

            }
        } catch (Exception e) {
        }
        return convertView;
    }

    /**
     * Cette classe construit l'interface qui
     * présente la liste des Provinces et térritoires
     */
    public static class MainActivity extends Activity {

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
}


/**
 * Cette classe construit les items de la listView de l'activité Actualite
 */
class ListActuViewHolder {
    ImageView galleryImage;
    TextView title, sdetails;
}
