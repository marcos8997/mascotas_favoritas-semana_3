package net.mcg.mascotas_favoritas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MascotasFavoritas extends AppCompatActivity {
    RecyclerView rvMascotas;
    adaptadorMascotasFavoritas apatador;
    List<mascota> listaOrdenada = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        iniciar();
    }

    private void iniciar(){
        rvMascotas = findViewById(R.id.rvMascotas);
        rvMascotas.setLayoutManager(new LinearLayoutManager(this));

        // Obtener cardviews ordenados


        apatador = new adaptadorMascotasFavoritas(listaOrdenada, this);
        rvMascotas.setAdapter(apatador);
    }

    public void meGusta(View view){

        View vistaPadre = (View) view.getParent();
        TextView txLikes = (TextView) vistaPadre.findViewById(R.id.likes);


        int iLikes = Integer.parseInt( txLikes.getText().toString() );
        iLikes++;

        txLikes.setText(Integer.toString(iLikes));
    }
}