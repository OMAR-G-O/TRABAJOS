package org.example;

public abstract class Contenido {
    private String titulo;
    private Double duracion;
    private String genero;

    public Contenido(){}
    public Contenido(String titulo, Double duracion, String genero) {
       setTitulo(titulo);
       setDuracion(duracion);
       setGenero(genero);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        if (duracion > 0){
            this.duracion = duracion;
        }
        else System.out.println("ingresa una duracion valida");
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Contenido" + "\n"+
                "Titulo: " + this.getTitulo() + "\n"+
                "Duracion: " + this.getDuracion() + "\n"+
                "Genero: " + this.getGenero();
    }

    public static String reproducir(){
        return "reproduciendo: ";
    }
    // 2.\\ Abstracto: Cada hijo define qué tipo es
    public abstract String obtenerTipoContenido();

    // 4. No abstracto: Regresa la duración del contenido
    public Double obtenerTiempoTotal() {
        return this.getDuracion();
    }

    // 6. No abstracto: Muestra los datos de la clase padre
    public String obtenerDatosGenerales() {
        return "Titulo: " + titulo + ", Duracion: " + duracion + ", Genero: " + genero;
    }

    // 7. Abstracto: Cada hijo mostrará sus atributos específicos
    public abstract String obtenerDatosParticulares();
}
