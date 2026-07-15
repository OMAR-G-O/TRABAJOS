package org.example.modelo;

public class Profesor extends PersonaUT implements Ensenador, Evaluador {
    private int edad;
    private int numEmpleado;
    private int cedulaProfesional;
    private String puesto;
    private static final String[] PUESTOS_VALIDOS = {"GERENTE", "DOCENTE", "TUTOR", "DIRECTOR", "RECTOR"};

    public Profesor(String nombre, String curp) {
        super(nombre, curp);
    }

    public Profesor( int edad, int numEmpleado, int cedulaProfesional,  String puesto) {
        setEdad(edad);
        setNumEmpleado(numEmpleado);
        setCedulaProfesional(cedulaProfesional);
        setPuesto(puesto);
    }

    public Profesor() {}







    @Override
    public String mostrarTipoPersona() {
        return "----- Profesor -----";
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

    public int getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(int cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getPuesto() {return puesto;}
    public void setPuesto(String puesto) {this.puesto = puesto;}


    @Override
    public String toString() {
        return  mostrarTipoPersona() +"\n"+
                super.toString() +"\n"+
                "edad: " + getEdad() + "\n"+
                "numEmpleado: " + getNumEmpleado() + "\n"+
                "cedulaProfesional: " + getCedulaProfesional() + '\n'+
                "puesto: " + getPuesto() + "\n"+
                 ensenar() + "\n"+
                Evaluar();
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
    @Override
    public String ensenar() {
        return "El maestro "+getNombre()+" esta enseñando...";
    }
    @Override
    public String Evaluar(){
        return "El maestro "+getNombre()+" esta evaluando...";
    }
}
