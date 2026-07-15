package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDao {
    public boolean nuevoAlumno(Alumno alumno){
        boolean registrado = false;

        String sql = "INSERT INTO alumnos VALUES(?,?,?,?,?,?)";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql);){
            stm.setInt(1,alumno.getNumExpediente());
            stm.setString(2,alumno.getNombre());
            stm.setInt(3,alumno.getEdad());
            stm.setString(4,alumno.getCarrera());
            stm.setInt(5,alumno.getCuatrimestre());
            stm.setString(6, alumno.getCurp());
            stm.executeUpdate();
            System.out.println("Alumno agregado correctamente");
        }
        catch (SQLException err) {
            System.out.println("Error al agregar alumno"+ err.getMessage());

        }

        return registrado;
    }

    public ArrayList<Alumno> extraerAlumnos(){
        ArrayList<Alumno> alumnosBD = new ArrayList<Alumno>();
        String sql = "SELECT * FROM alumnos";
        try (Connection conexion = Conexion.conectar();
        PreparedStatement stm = conexion.prepareStatement(sql);
            ResultSet rs = stm.executeQuery()){
            while (rs.next()){
                Alumno alumno = new Alumno();
                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCarrera(rs.getString("carrera"));
                alumno.setCuatrimestre(rs.getInt("cuatrimestre"));
                alumno.setCurp(rs.getString("curp"));
                alumnosBD.add(alumno);
            }
        }
        catch(SQLException err){
            System.out.println("Error al extraer los Datos: "+ err.getMessage());
        }
    return alumnosBD;
    }
    public boolean actualizarAlumno(Alumno alumno){
        boolean actualizado = false;
        String sql = "UPDATE alumnos SET nombre = ?, edad = ?, carrera = ?, cuatrimestre = ?, curp = ? WHERE numExpediente = ?";
        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql);){

            stm.setString(1, alumno.getNombre());
            stm.setInt(2, alumno.getEdad());
            stm.setString(3, alumno.getCarrera());
            stm.setInt(4, alumno.getCuatrimestre());
            stm.setString(5, alumno.getCurp());
            stm.setInt(6, alumno.getNumExpediente());

            int registrosAfectado = stm.executeUpdate();
            if (registrosAfectado > 0) {
                System.out.println("Alumno actualizado correctamente");
            } else {
                System.out.println("Error al actualizar alumno");
            }
        }
        catch(SQLException err){
                System.out.println("Error al actualizar alumno" + err.getMessage());
            }
            return actualizado;

    }

    public boolean borrarAlumno(Alumno alumno){
        boolean borrado = false;
        String sql = "DELETE FROM alumnos WHERE numExpediente = ?";
        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql);){
            stm.setInt(1, alumno.getNumExpediente());
            stm.executeUpdate();
            System.out.println("Alumno eliminado correctamente");
        }
        catch (SQLException err){
            System.out.println("Error al borrar alumno"+ err.getMessage());
        }
        return borrado;
    }

    public boolean buscarAlumno(Alumno alumno){
        boolean buscado = false;
        String sql = "SELECT * FROM alumnos WHERE numExpediente = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, alumno.getNumExpediente());

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setEdad(rs.getInt("edad"));
                    alumno.setCarrera(rs.getString("carrera"));
                    alumno.setCuatrimestre(rs.getInt("cuatrimestre"));
                    alumno.setCurp(rs.getString("curp"));

                    buscado = true;
                    System.out.println("Alumno buscado y cargado correctamente");
                } else {
                    System.out.println("No se encontró ningún alumno con ese número de expediente");
                }
            }
        }
        catch (SQLException err) {
            System.out.println("Error al buscar alumno: " + err.getMessage());
        }
        return buscado;
    }
}
