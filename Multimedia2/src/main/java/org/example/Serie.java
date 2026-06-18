package org.example;

public class Serie extends Contenido {
    private Integer numEpisodios = 10;
    private Integer numTemporadas;

    public Serie(Integer numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public Serie(String titulo, Double duracion, String genero, Integer numTemporadas) {
        super(titulo, duracion, genero);
        setNumTemporadas(numTemporadas);
    }

    public Integer getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(Integer numTemporadas) {
        if (numTemporadas > 0) {
            this.numTemporadas = numTemporadas;
        }
        else System.out.println("El numero de temporadas no puede ser menor a 0");
    }

    public Integer numeroDeEpisodios() {
        return this.numTemporadas * this.numEpisodios;
    }

    @Override
    public Double obtenerTiempoTotal() {
        // En una serie, el tiempo total podría ser la duración de un cap multiplicado por el total de episodios
        return this.getDuracion() * numeroDeEpisodios();
    }

    @Override
    public String obtenerTipoContenido() {
        return "Serie";
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Numero de temporadas: " + getNumTemporadas() + ", Total Episodios: " + numeroDeEpisodios();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + obtenerDatosParticulares() + "\n";
    }
}