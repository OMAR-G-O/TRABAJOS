package org.example;

public class Podcast extends Contenido{
    private String nomPresentador;

    public Podcast(String nomPresentador) {
        this.nomPresentador = nomPresentador;
    }

    public Podcast(String titulo, Double duracion, String genero, String nomPresentador) {
        super(titulo, duracion, genero);
        setNomPresentador(nomPresentador);
    }

    public String getNomPresentador() {
        return nomPresentador;
    }

    public void setNomPresentador(String nomPresentador) {
        this.nomPresentador = nomPresentador;
    }

    @Override
    public String obtenerTipoContenido() {
        return "Podcast";
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Nombre del presentador: " + getNomPresentador();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + obtenerDatosParticulares() + "\n";
    }
}
