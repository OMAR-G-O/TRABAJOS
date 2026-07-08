package org.example.modelo;

public class Profesor {
    private String nombre;
    private int edad;
    private int numEmpleado;
    private String cedulaProfesional;
    private String puesto;
    private static final String[] PUESTOS_VALIDOS = {"GERENTE", "DOCENTE", "TUTOR", "DIRECTOR", "RECTOR"};

    public Profesor(String nombre, int edad, int numEmpleado, String cedulaProfesional,  String puesto) {
        setNombre(nombre);
        setEdad(edad);
        setNumEmpleado(numEmpleado);
        setCedulaProfesional(cedulaProfesional);
        setPuesto(puesto);
    }

    public Profesor() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() < 3 && nombre.isBlank()) {
            System.out.println( "El nombre debe ser correcto");
        }
        else this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 18 &&  edad < 120 ) {
            this.edad = edad;
        }
        else System.out.println("Ingresa una edad correcta ");
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        if  (numEmpleado > 0) {
            this.numEmpleado = numEmpleado;
        }
        else System.out.println("Ingresa una numEmpleado correcta ");
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getPuesto() {return puesto;}
    public void setPuesto(String puesto) {this.puesto = puesto;}


    @Override
    public String toString() {
        return "-----------   Profesor   -----------" +"\n"+
                "nombre: " + nombre + '\n' +
                "edad: " + edad + "\n"+
                "numEmpleado: " + numEmpleado + "\n"+
                "cedulaProfesional: " + cedulaProfesional + '\n'+
                "puesto: " + puesto;
    }

    public boolean validarPuestos(String puesto) {
        boolean puestoValido = false;
        for (String validar : PUESTOS_VALIDOS) {
            if (puesto.equalsIgnoreCase(validar)) {
                puestoValido = true;
            }
        }
        return puestoValido;
    }
}
