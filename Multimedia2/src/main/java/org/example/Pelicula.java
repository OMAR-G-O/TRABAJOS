package org.example;

public class Pelicula extends Contenido {

    private String director;

    public Pelicula(String director) {
        this.director = director;
    }

    public Pelicula(String titulo, Double duracion, String genero, String director) {
        super(titulo, duracion, genero);
        setDirector(director);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String obtenerTipoContenido() {
        return "Película";
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Director: " + getDirector();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + obtenerDatosParticulares() + "\n";
    }
}
