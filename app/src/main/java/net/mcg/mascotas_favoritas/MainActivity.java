package net.mcg.mascotas_favoritas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.appbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        SetupViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new InicioFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void SetupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menuop, menu);

        return true;
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
                break;
            case R.id.mContacto:
                contacto();
                break;
            case  R.id.mAbout:
                bio();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void verFavoritos() {
        Intent i = new Intent(this, MascotasFavoritas.class);
        startActivity(i);
    }

    public void contacto(){
        Intent i = new Intent(this, Contacto.class);
        startActivity(i);
    }

    public void bio(){
        Intent i = new Intent(this, Biografia.class);
        startActivity(i);
    }
}