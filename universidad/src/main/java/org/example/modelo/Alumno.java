package org.example.modelo;

import java.io.Serializable;

public class Alumno extends PersonaUT implements Ensenable, Evaluable{
    private int numExpediente;
    private int edad;
    private String carrera;
    private int cuatrimestre;
    private boolean registroCorrecto = false;
    private static final String[] CARRERAS_VALIDAS = {"DESARROLLO DE SOFTWARE", "MECATRÓNICA", "INDUSTRIAL", "MERCADOTECNIA"};

    public Alumno() {}

    public Alumno(String nombre, String curp) {
        super(nombre, curp);
    }

    public Alumno(int numExpediente, int edad, String carrera, int cuatrimestre) {
        setNumExpediente(numExpediente);
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
        return mostrarTipoPersona() +"\n"+
                super.toString() +"\n"+
                "numExpediente= " + getNumExpediente() +"\n"+
                "edad= " + getEdad() + "\n" +
                "carrera= " + getCarrera() + '\n' +
                "cuatrimestre= " + getCuatrimestre()+"\n"+
                aprender() + "\n" +
                recibirEvaluacion()+ "\n"+
                "--------------------------------------";

    }

    @Override
    public String mostrarTipoPersona() {
        return "----- Alumno -----";
    }

    @Override
    public String aprender(){
        return "El alumno "+ getNombre()+ "esta aprendiendo...";
    }

    @Override
    public String recibirEvaluacion(){
        return "El alumno "+getNombre()+ "esta evaluado...";
    }
}
