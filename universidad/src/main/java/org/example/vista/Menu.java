package org.example.vista;

import org.example.dao.AlumnoDao;
import org.example.dao.ProfesorDao;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Menu {
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static AlumnoDao alumnoDao = new AlumnoDao();
    static Alumno alumno =  new Alumno();
    static Profesor profesor = new Profesor();
    static ProfesorDao profesorDao = new ProfesorDao();
    static public void inscribir() throws IOException{
        System.out.print("Numero de expediente");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Nombre");
        alumno.setNombre(leer.readLine());
        System.out.print("Edad");
        alumno.setEdad(Integer.parseInt(leer.readLine()));
        System.out.print("Carrera (DESARROLLO DE SOFTWARE\", \"MECATRÓNICA\", \"INDUSTRIAL\", \"MERCADOTECNIA)");
        alumno.setCarrera(leer.readLine());
        System.out.print("Cuatrimestre");
        alumno.setCuatrimestre(Integer.parseInt(leer.readLine()));
        alumnoDao.nuevoAlumno(alumno);
    }
    public static void mostrar(){
        ArrayList<Alumno> alumnos = alumnoDao.extraerAlumnos();
        System.out.println("Alumnos inscritos: ");
        for (Alumno alumno : alumnos){
            System.out.println(alumno);
        }
    }
    public static void modificar()throws IOException{

        System.out.println("Modificar alumno por numero de expediente");
        System.out.println("Numero de expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.println("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.println("Edad: ");
        alumno.setEdad(Integer.parseInt(leer.readLine()));
        System.out.println("Carrera: (DESARROLLO DE SOFTWARE\", \"MECATRÓNICA\", \"INDUSTRIAL\", \"MERCADOTECNIA) ");
        alumno.setCarrera(leer.readLine());
        System.out.println("Cuatrimestre: ");
        alumno.setCuatrimestre(Integer.parseInt(leer.readLine()));
        alumnoDao.actualizarAlumno(alumno);

    }
    public static void borrar()throws IOException{
        System.out.println("Borrar alumno");
        System.out.println("Ingresa el numero de expediente");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        alumnoDao.borrarAlumno(alumno);
    }
    public static void buscar() throws IOException{
        System.out.println("Buscar alumno por numero de expediente");
        System.out.println("Numero de expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        boolean encontrado = alumnoDao.buscarAlumno(alumno);

        if (encontrado) {
            System.out.println("\n--- Datos del Alumno Encontrado ---");
            System.out.println(alumno);
        } else {
            System.out.println("No se pudo mostrar el alumno porque no existe.");
        }
    }
    public static void insertarMaestro()throws IOException{
        System.out.println("Ingresa el numero de empleado: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));
        System.out.println("Ingresa el puesto(gerente, docente, tutor, director, rector: ");
        profesor.setPuesto(leer.readLine());
        System.out.println("Ingresa el nombre del empleado: ");
        profesor.setNombre(leer.readLine());
        System.out.println("Ingresa el edad del empleado: ");
        profesor.setEdad(Integer.parseInt(leer.readLine()));
        System.out.println("Ingresa la cedula del Profesor: ");
        profesor.setCedulaProfesional(Integer.parseInt(leer.readLine()));
        profesorDao.nuevoProfesor(profesor);
    }
    public static void mostrarMaestros()throws IOException{
        ArrayList<Profesor> maestros = profesorDao.extraerProfesores();
        System.out.println("Alumnos inscritos: ");
        for (Profesor profesor : maestros){
            System.out.println(profesor);
        }
    }
    public static void eliminarMaestros()throws IOException{
        System.out.println("----------------- Eliminar profesor -------------");
        System.out.println("Ingresa el numero de empleado: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));
        profesorDao.eliminarProfesor(profesor);
    }
    public static void modificarMaestros()throws IOException{
        System.out.println("-------- Modificar Profesor por numero de cédula --------");
        System.out.println("Ingresa el numero de cedula del Profesor: ");
        profesor.setCedulaProfesional(Integer.parseInt(leer.readLine()));
        System.out.println("Ingresa el numero de empleado del profesor: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));
        System.out.println("Ingresa el nombre del profesor: ");
        profesor.setNombre(leer.readLine());
        System.out.println("Ingresa la edad del profesor: ");
        profesor.setEdad(Integer.parseInt(leer.readLine()));
        System.out.println("Ingresa el puesto del profesor: ");
        profesor.setPuesto(leer.readLine());
        profesorDao.actualizarProfesor(profesor);
    }
    public static void buscarMaestro()throws IOException{

        System.out.println("Buscar alumno por numero de empleado: ");
        System.out.println("Numero de empleado: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));
        boolean encontrado = profesorDao.buscarProfesor(profesor);

        if (encontrado) {
            System.out.println("\n--- Datos del profesor encontrado ---");
            System.out.println(profesor);
        } else {
            System.out.println("No se pudo mostrar el profesor porque no existe.");
        }

    }

    public static void menu() throws IOException {
        int salir = 0;
        while (salir != 11){
            System.out.println("1. Inscribir nuevo alumno");
            System.out.println("2. Mostrar todos los alumnos");
            System.out.println("3. Modificar un alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Buscar alumno");
            System.out.println("6. Insertar maestro");
            System.out.println("7. mostrar todos los maestros");
            System.out.println("8. Modificar maestro");
            System.out.println("9. Eliminar maestro");
            System.out.println("10. Buscar maestro");
            System.out.println("11. Salir");
            salir = Integer.parseInt(leer.readLine());
            switch (salir){
                case 1: inscribir();break;
                case 2: mostrar(); break;
                case 3: modificar(); break;
                case 4: borrar(); break;
                case 5: buscar(); break;
                case 6: insertarMaestro(); break;
                case 7: mostrarMaestros(); break;
                case 8: modificarMaestros(); break;
                case 9: eliminarMaestros(); break;
                case 10: buscarMaestro();  break;
                case 11:
                    System.out.println("Adios"); break;
                default:
                    System.out.println("Incorrecta opcion");
            }
        }
    }
}
