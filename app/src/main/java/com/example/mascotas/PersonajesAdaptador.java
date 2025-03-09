package com.example.mascotas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonajesAdaptador extends RecyclerView.Adapter<PersonajesAdaptador.ViewHolder> {

    private List<Personaje> personajes;
    private Context context;

    public PersonajesAdaptador(List<Personaje> personajes, Context context) {
        this.personajes = personajes;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personajee_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);
        holder.nombre.setText(personaje.getNombre());
        holder.genero.setText(personaje.getGenero());
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, genero;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            genero = itemView.findViewById(R.id.genero);
        }
    }
}