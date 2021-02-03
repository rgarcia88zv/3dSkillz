package com.example.a3dskillz.pojo;

public class Artista {

    private long id;
    private String nombreArtista, apellidoArtista,estiloArtista,imgArtista;
    private int telfArtista;

    public Artista(String nombreArtista, String apellidoArtista, String estiloArtista, String imgArtista, int telf) {
        this.nombreArtista = nombreArtista;
        this.apellidoArtista = apellidoArtista;
        this.estiloArtista = estiloArtista;
        this.imgArtista = imgArtista;
        this.telfArtista = telf;
    }

    public Artista(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getApellidoArtista() {
        return apellidoArtista;
    }

    public void setApellidoArtista(String apellidoArtista) {
        this.apellidoArtista = apellidoArtista;
    }

    public String getEstiloArtista() {
        return estiloArtista;
    }

    public void setEstiloArtista(String estiloArtista) {
        this.estiloArtista = estiloArtista;
    }

    public String getImgArtista() {
        return imgArtista;
    }

    public void setImgArtista(String imgArtista) {
        this.imgArtista = imgArtista;
    }

    public int getTelfArtista() {
        return telfArtista;
    }

    public void setTelfArtista(int telfArtista) {
        this.telfArtista = telfArtista;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nombreArtista='" + nombreArtista + '\'' +
                ", apellidoArtista='" + apellidoArtista + '\'' +
                ", estiloArtista='" + estiloArtista + '\'' +
                ", imgArtista='" + imgArtista + '\'' +
                ", telf=" + telfArtista +
                '}';
    }
}
