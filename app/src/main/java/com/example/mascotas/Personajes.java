package com.example.mascotas;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Personajes extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonajesAdaptador adaptador;
    private List<Personaje> personajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        personajes = new ArrayList<>();
        adaptador = new PersonajesAdaptador(personajes, this);
        recyclerView.setAdapter(adaptador);

        fetchCharacters();
    }

    private void fetchCharacters() {
        String url = "https://swapi.dev/api/people/";

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray results = response.getJSONArray("results");
                            for (int i = 0; i < results.length(); i++) {
                                JSONObject personajejson = results.getJSONObject(i);
                                String nombre = personajejson.getString("name");
                                String genero = personajejson.getString("gender");

                                personajes.add(new Personaje(nombre, genero));
                            }
                            adaptador.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", "Error al cargar los personajes: " + error.getMessage());
                    }
                }
        );

        queue.add(request);
    }
}