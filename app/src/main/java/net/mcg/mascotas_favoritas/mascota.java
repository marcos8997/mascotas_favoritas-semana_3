package net.mcg.mascotas_favoritas;

public class mascota {

    private int foto;
    private String nombre;
    private String meGusta;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(String meGusta) {
        this.meGusta = meGusta;
    }

    public mascota(int foto, String nombre, String meGusta) {
        this.foto = foto;
        this.nombre = nombre;
        this.meGusta = meGusta;
    }
}
