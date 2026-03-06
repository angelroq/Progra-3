/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Controlador.Jornadas;

/**
 *
 * @author Angel R
 */
public class JornadasDAO {
private static final String SQL_SELECT = "SELECT JOR_Código, JOR_Nombre FROM jornadas";
    private static final String SQL_INSERT = "INSERT INTO jornadas(JOR_Código,JOR_Nombre) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE jornadas SET JOR_Nombre=? WHERE JOR_Código = ?";
    private static final String SQL_DELETE = "DELETE FROM jornadas WHERE JOR_Código=?";
    private static final String SQL_QUERY = "SELECT JOR_Código, JOR_Nombre FROM jornadas WHERE JOR_Código = ?";

    public List<Jornadas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jornadas jornadas = null;
        List<Jornadas> jornadass = new ArrayList<Jornadas>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int JOR_Código = rs.getInt("JOR_Código");
                String JOR_Nombre = rs.getString("JOR_Nombre");
                               
                jornadas = new Jornadas();
                jornadas.setJOR_Código(JOR_Código);
                jornadas.setJOR_Nombre(JOR_Nombre);
                                
                jornadass.add(jornadas);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return jornadass;
    }

    public int insert(Jornadas jornadas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, jornadas.getJOR_Código());
            stmt.setString(2, jornadas.getJOR_Nombre());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Jornadas jornadas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, jornadas.getJOR_Nombre());
            stmt.setInt(2, jornadas.getJOR_Código());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Jornadas jornadas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, jornadas.getJOR_Código());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona empleado) { // Si se utiliza un ArrayList
    public Jornadas query(Jornadas jornadas) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Jornadas> jornadass = new ArrayList<Jornadas>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, jornadas.getJOR_Código());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int JOR_Código = rs.getInt("JOR_Código");
                String JOR_Nombre = rs.getString("JOR_Nombre");
                                
                jornadas = new Jornadas();
                jornadas.setJOR_Código(JOR_Código);
                jornadas.setJOR_Nombre(JOR_Nombre);
                
                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return jornadas;
    }
}
