package com.example.villanosdb;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.villanosdb.adaptadores.VillanoAdaptador;
import com.example.villanosdb.clases.Villano;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvVillanos;
    List<Villano> listaVillanos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rcvVillanos = findViewById(R.id.rcv_villanos);

        listaVillanos.add(new Villano(R.drawable.freezer, "Freezer", "Raza Freezer",
                "Saga de Freezer", true, "Goku",
                "52.71 Septillion", 80,
                "Tirano espacial que destruyó el planeta Vegeta y busca la inmortalidad.",
                "#4A2C7A"));

        listaVillanos.add(new Villano(R.drawable.cell, "Cell", "Bioandroide",
                "Saga de Cell", true, "Gohan",
                "5 Billion", 85,
                "Bioandroide creado con las células de los mejores guerreros del universo.",
                "#2E5E1E"));

        listaVillanos.add(new Villano(R.drawable.super_buu, "Super Buu", "Majin",
                "Saga de Majin Buu", true, "Goku",
                "POR COMPLETAR", 90,
                "Criatura mágica capaz de absorber a sus rivales y regenerarse al instante.",
                "#C2185B"));

        listaVillanos.add(new Villano(R.drawable.janemba, "Janemba", "Demonio",
                "Película: Fusión (Fusion Reborn)", true, "Gogeta",
                "POR COMPLETAR", 92,
                "Demonio nacido de la maldad acumulada que mezcló el cielo con el infierno.",
                "#A67C00"));

        listaVillanos.add(new Villano(R.drawable.broly, "Broly", "Saiyan",
                "Película: El legendario Super Saiyajin", true, "Goku y Gohan",
                "10,000,000 millones", 100,
                "Saiyan de poder descontrolado, conocido como el legendario Super Saiyajin.",
                "#7B1E3A"));

        listaVillanos.add(new Villano(R.drawable.turles, "Turles", "Saiyan",
                "Película: El Árbol del Poder", true, "Goku",
                " 300,000 mill", 55,
                "Saiyan idéntico a Goku que usa el Fruto del Árbol del Poder.",
                "#1F3A93"));

        rcvVillanos.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rcvVillanos.setAdapter(new VillanoAdaptador(listaVillanos));

        new PagerSnapHelper().attachToRecyclerView(rcvVillanos);
    }
}