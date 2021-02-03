package com.example.a3dskillz.pojo;

public class Figura {

    private long id,idArtista;

    private String nombreFigura,materialFigura,imgFigura;

    private Double precioFigura;

    public Figura(long idArtista, String nombreFigura, String materialFigura, String imgFigura, Double precioFigura) {
        this.idArtista = idArtista;
        this.nombreFigura = nombreFigura;
        this.materialFigura = materialFigura;
        this.imgFigura = imgFigura;
        this.precioFigura = precioFigura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(long idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public String getMaterialFigura() {
        return materialFigura;
    }

    public void setMaterialFigura(String materialFigura) {
        this.materialFigura = materialFigura;
    }

    public String getImgFigura() {
        return imgFigura;
    }

    public void setImgFigura(String imgFigura) {
        this.imgFigura = imgFigura;
    }

    public Double getPrecioFigura() {
        return precioFigura;
    }

    public void setPrecioFigura(Double precioFigura) {
        this.precioFigura = precioFigura;
    }

    @Override
    public String toString() {
        return "Figura{" +
                "id=" + id +
                ", idArtista=" + idArtista +
                ", nombreFigura='" + nombreFigura + '\'' +
                ", materialFigura='" + materialFigura + '\'' +
                ", imgFigura='" + imgFigura + '\'' +
                ", precioFigura=" + precioFigura +
                '}';
    }
}
