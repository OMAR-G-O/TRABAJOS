package org.example.modelo;

public class Alumno {
    private int numExpediente;
    private String nombre;
    private int edad;
    private String carrera;
    private int cuatrimestre;
    private boolean registroCorrecto = false;
    private static final String[] CARRERAS_VALIDAS = {"DESARROLLO DE SOFTWARE", "MECATRÓNICA", "INDUSTRIAL", "MERCADOTECNIA"};
    public Alumno() {}

    public Alumno(int numExpediente, String nombre, int edad, String carrera, int cuatrimestre) {
        setNumExpediente(numExpediente);
        setNombre(nombre);
        setEdad(edad);
        setCarrera(carrera);
        setCuatrimestre(cuatrimestre);
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isBlank() || nombre.length() < 3) {
            System.out.println("El nombre debe ser correcto");

        }
        else this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0 && edad <= 90) {this.edad = edad;}
        else System.out.println("La edad debe ser correcta");

    }

    public String getCarrera() {
        return carrera.toUpperCase();
    }

    public void setCarrera(String carrera) {
        if  (validarCarreras(carrera));
        this.carrera = carrera;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {

        if  (cuatrimestre < 12 || cuatrimestre > 0) { this.cuatrimestre = cuatrimestre;}
        else System.out.println("El cuatrimestre debe ser mayor a 1 y menor igual a 11");

    }

    public boolean validarCarreras(String carrera){
        boolean carreraValida = false;
        for(String validar : CARRERAS_VALIDAS){
            if (carrera.equalsIgnoreCase(validar)){
                carreraValida = true;
            }
        }
        return carreraValida;

    }

    @Override
    public String toString() {
        return "-------  Alumno  -------" +"\n"+
                "numExpediente= " + getNumExpediente() +"\n"+
                "nombre= " + getNombre() + '\n' +
                "edad= " + getEdad() + "\n" +
                "carrera= " + getCarrera() + '\n' +
                "cuatrimestre= " + getCuatrimestre();
    }
}
