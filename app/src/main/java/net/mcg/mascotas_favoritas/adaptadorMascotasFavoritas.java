package net.mcg.mascotas_favoritas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adaptadorMascotasFavoritas extends RecyclerView.Adapter<adaptadorMascotasFavoritas.ViewHolder>{
    private List<mascota> listaMascotas;
    private Context ctx;

    public adaptadorMascotasFavoritas(List<mascota> listaMascotas, Context ctx) {
        this.listaMascotas = listaMascotas;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombreMacota.setText(listaMascotas.get(position).getNombre());
        holder.likesMascota.setText(listaMascotas.get(position).getMeGusta());
        holder.imgMascota.setImageResource(listaMascotas.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView nombreMacota;
        private TextView likesMascota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMascota =  itemView.findViewById(R.id.fotoMascota);
            nombreMacota = itemView.findViewById(R.id.nombreMascota);
            likesMascota = itemView.findViewById(R.id.likes);
        }
    }
}