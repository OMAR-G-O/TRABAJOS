package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDao {
    public boolean nuevoProfesor(Profesor profesor) {
        boolean registrado = false;

        String sql = "INSERT INTO maestros VALUES(?,?,?,?,?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);) {
            stm.setInt(1, profesor.getNumEmpleado());
            stm.setString(2, profesor.getPuesto());
            stm.setString(3, profesor.getNombre());
            stm.setInt(4, profesor.getEdad());
            stm.setInt(5, profesor.getCedulaProfesional());
            stm.executeUpdate();
        } catch (SQLException err) {
            System.out.println("Error al agregar Maestro" + err.getMessage());
        }
        return registrado;
    }

    public ArrayList<Profesor> extraerProfesores() {
        ArrayList<Profesor> profesoresBD = new ArrayList<Profesor>();
        String sql = "SELECT * FROM maestros";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setEdad(rs.getInt("edad"));
                profesor.setCedulaProfesional(rs.getInt("cedulaProfesional"));
                profesoresBD.add(profesor);
            }
        } catch (SQLException err) {
            System.out.println("Error al extraer los Datos: " + err.getMessage());
        }
        return profesoresBD;
    }
    public boolean actualizarProfesor(Profesor profesor){
        boolean actualizado = false;
        String sql = "UPDATE maestros SET numEmpleado = ?, puesto = ?, nombre = ?, edad = ? WHERE cedulaProfesional = ?";
        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql);){

            stm.setInt(1, profesor.getNumEmpleado());
            stm.setString(2, profesor.getPuesto());
            stm.setString(3, profesor.getNombre());
            stm.setInt(4, profesor.getEdad());
            stm.setInt(5, profesor.getCedulaProfesional());
            int registrosAfectado = stm.executeUpdate();
            if (registrosAfectado > 0) {
                System.out.println("Profesor actualizado correctamente");
            } else {
                System.out.println("Error al actualizar Profesor");
            }
        }
        catch(SQLException err){
            System.out.println("Error al actualizar Profesor" + err.getMessage());
        }
        return actualizado;
    }

    public boolean eliminarProfesor(Profesor profesor){
        boolean eliminado = false;
        String sql = "DELETE FROM maestros WHERE numEmpleado = ?";
        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql);) {
            stm.setInt(1, profesor.getNumEmpleado());
            stm.executeUpdate();
            System.out.println("Profesor eliminado correctamente");
        }
        catch(SQLException err){
            System.out.println("Error al eliminar Profesor" + err.getMessage());
        }
        return eliminado;
    }
}
