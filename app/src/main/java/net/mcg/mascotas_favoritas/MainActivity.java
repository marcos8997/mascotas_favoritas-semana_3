package net.mcg.mascotas_favoritas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMascotas;
    adaptadorMascota apatador;
    List<mascota> lista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
    }

    private void iniciar(){
        rvMascotas = findViewById(R.id.rvMascotas);
        rvMascotas.setLayoutManager(new LinearLayoutManager(this));

        //List<mascota> lista = new ArrayList<>();


        lista.add(new mascota(R.drawable.husky, "Mascota 1", "0"));
        lista.add(new mascota(R.drawable.doberman, "Mascota 2", "0"));
        lista.add(new mascota(R.drawable.pastor_aleman, "Macota 3", "0"));
        lista.add(new mascota(R.drawable.descarga, "Mascota 4", "0"));
        lista.add(new mascota(R.drawable.caniche, "Mascota 5", "0"));

        apatador = new adaptadorMascota(lista, this);
        rvMascotas.setAdapter(apatador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // al dar click en el hueso blanco se ejecuta este metodo.
    public void meGusta(View view){

        View vistaPadre = (View) view.getParent();
        TextView txLikes = (TextView) vistaPadre.findViewById(R.id.likes);


        int iLikes = Integer.parseInt( txLikes.getText().toString() );
        iLikes++;

        txLikes.setText(Integer.toString(iLikes));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.fav_icon:
                verFavoritos();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void verFavoritos() {
        Intent i = new Intent(this, MascotasFavoritas.class);
        startActivity(i);
    }
}