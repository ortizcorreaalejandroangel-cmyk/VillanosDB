package com.example.villanosdb.adaptadores;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.villanosdb.R;
import com.example.villanosdb.clases.Villano;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class VillanoAdaptador extends RecyclerView.Adapter<VillanoAdaptador.ViewHolder> {

    private List<Villano> datos;

    public VillanoAdaptador(List<Villano> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_villano, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView card;
        ImageView img;
        TextView txtNombre, txtSaga, txtRaza, txtEstado, txtKi, txtDescripcion;
        ProgressBar barraPoder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_villano);
            img = itemView.findViewById(R.id.img_villano);
            txtNombre = itemView.findViewById(R.id.txt_nombre_villano);
            txtSaga = itemView.findViewById(R.id.txt_saga_villano);
            txtRaza = itemView.findViewById(R.id.txt_raza_villano);
            txtEstado = itemView.findViewById(R.id.txt_estado_villano);
            txtKi = itemView.findViewById(R.id.txt_ki_villano);
            barraPoder = itemView.findViewById(R.id.barra_poder);
            txtDescripcion = itemView.findViewById(R.id.txt_descripcion_villano);
        }

        public void bind(Villano v) {
            card.setCardBackgroundColor(Color.parseColor(v.getColor()));
            img.setImageResource(v.getImagen());
            txtNombre.setText(v.getNombre().toUpperCase());
            txtSaga.setText(v.getSaga());
            txtRaza.setText("Raza: " + v.getRaza());
            txtDescripcion.setText(v.getDescripcion());
            txtKi.setText("⚡ Ki máx: " + v.getKi());
            barraPoder.setProgress(v.getPoder());

            String estado = v.isDerrotado()
                    ? "DERROTADO por " + v.getDerrotadoPor()
                    : "LIBRE";
            txtEstado.setText(estado);

            GradientDrawable pastilla = new GradientDrawable();
            pastilla.setCornerRadius(60f);
            pastilla.setColor(Color.parseColor(v.isDerrotado() ? "#B71C1C" : "#2E7D32"));
            txtEstado.setBackground(pastilla);
        }
    }
}