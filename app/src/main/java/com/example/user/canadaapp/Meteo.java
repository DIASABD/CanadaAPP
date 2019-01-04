package com.example.user.canadaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Cette classe les details  conténu dans le JSON de notre API pour l'activité Météo
 */

public class Meteo extends AppCompatActivity {

    TextView t1_temp, t2_city, t3_description, t4_date;

    ImageView imageMeteo;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);
        getSupportActionBar().setTitle("Météo");


        t1_temp = (TextView) findViewById(R.id.textView_province);
        t2_city = (TextView) findViewById(R.id.textView_City);
        t3_description = (TextView) findViewById(R.id.textView_Description);
        t4_date = (TextView) findViewById(R.id.textView_Date);

        find_weather();
    }

    /**
     * Methode qui recupere les informations dans le JSON de l'API en fonction de la province choisie.
     */
    public void find_weather() {

        MainActivity mainActivity = new MainActivity();
        String[] tabProv = mainActivity.nomProvinces;
        int x = mainActivity.getIndexClick();
        String maProv = tabProv[x];

        String choix = "";
        switch (maProv) {

            case "Alberta":
                choix = "Calgary,alberta";
                break;
            case "Ile du Prince Edouard":
                choix = "charlottetown,ileduprinceedouard";
                break;
            case "Manitoba":
                choix = "winnipeg,manitoba";
                break;
            case "Nouvelle Ecosse":
                choix = "halifax,nouvelleecosse";
                break;
            case "Nouveau Brunswick":
                choix = "fredericton,nouveaubrunswick";
                break;

            case "Nunavut":
                choix = "iqaluit,nunavut";
                break;
            case "Ontario":
                choix = "Toronto,ontario";
                break;

            case "Saskachewan":
                choix = "saskatoon,saskatchewan";
                break;

            case "Terre Neuve et Labrardor":
                choix = "Gander,Newfoundland and Labrador";
                break;

            case "Territoires du Nord Ouest":
                choix = "Yellowknife,NorthwestTerritories";
                break;

            case "Quebec":
                choix = "montreal,quebec";
                break;

            case "Yukon":
                choix = "whitehorse,yukon";
                break;

            case "Colombie Britannique":
                choix = "vancouver,colombiebritannique";
                break;
        }
        imageMeteo = (ImageView) findViewById(R.id.imageMeteo);
        // initialistaion de l'url contenant la clef
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + choix + "&appid=a4d47da0bc4ea7ef9c58564085ee4af2&units=imperial";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String description = object.getString("description");
                    String city = response.getString("name");
                    String image = object.optString("icon").toString();


                    t1_temp.setText(temp);
                    t2_city.setText(city);
                    t3_description.setText(description);
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                    String formatted_date = sdf.format(calendar.getTime());
                    t4_date.setText(formatted_date);


                    switch (description) {

                        case "broken clouds":
                            imageMeteo.setImageResource(R.drawable.broken_clouds);
                            break;

                        case "clear sky":
                            imageMeteo.setImageResource(R.drawable.sunn);
                            break;

                        case "few clouds":
                            imageMeteo.setImageResource(R.drawable.scattered_clouds);
                            break;

                        case "mist":
                        case "haze":
                            imageMeteo.setImageResource(R.drawable.mist);
                            break;

                        case "rain":
                        case "light rain":
                        case "moderate rain":
                        case "shower rain":
                            imageMeteo.setImageResource(R.drawable.rain);
                            break;

                        case "scattered clouds":
                            imageMeteo.setImageResource(R.drawable.scattered_clouds);
                            break;

                        case "snow":
                        case "light snow":
                        case "light shower snow":
                            imageMeteo.setImageResource(R.drawable.snow);
                            break;

                        case "thunderstorm":
                            imageMeteo.setImageResource(R.drawable.thunderstorm);
                            break;

                        case "overcast clouds":
                            imageMeteo.setImageResource(R.drawable.overcast_cloud);
                            break;
                    }

                    double temp_int = Double.parseDouble(temp);
                    double centi = (temp_int - 32) / 1.8000;
                    centi = Math.round(centi);
                    int i = (int) centi;
                    t1_temp.setText(String.valueOf(i));


                } catch (JSONException e) {

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
    }


}
