package com.example.villanosdb.adaptadores;

import android.app.Dialog;
import android.content.Context;
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

            img.setOnClickListener(vista -> mostrarImagenGrande(v));
        }

        private void mostrarImagenGrande(Villano v) {
            Context ctx = itemView.getContext();
            Dialog dialog = new Dialog(ctx, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.setContentView(R.layout.dialog_villano);

            View root = dialog.findViewById(R.id.dialog_root);
            ImageView imgGrande = dialog.findViewById(R.id.img_grande);
            TextView nombre = dialog.findViewById(R.id.txt_nombre_grande);
            TextView saga = dialog.findViewById(R.id.txt_saga_grande);

            root.setBackgroundColor(Color.parseColor(v.getColor()));
            imgGrande.setImageResource(v.getImagen());
            nombre.setText(v.getNombre().toUpperCase());
            saga.setText(v.getSaga());

            imgGrande.setScaleX(0.4f);
            imgGrande.setScaleY(0.4f);
            imgGrande.setAlpha(0f);
            imgGrande.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(300).start();

            root.setOnClickListener(vista -> dialog.dismiss());
            dialog.show();
        }
    }
}