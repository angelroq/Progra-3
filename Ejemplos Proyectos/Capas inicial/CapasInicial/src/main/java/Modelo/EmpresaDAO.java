/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author visitante
 */
public class EmpresaDAO {

    private static final String SQL_SELECT = "SELECT codigoempresa, nombreempresa FROM empresa";
    private static final String SQL_INSERT = "INSERT INTO empresa(nombreempresa) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE empresa SET nombreempresa=? WHERE codigoempresa = ?";
    private static final String SQL_DELETE = "DELETE FROM empresa WHERE codigoempresa=?";
    private static final String SQL_QUERY = "SELECT codigoempresa, nombreempresa FROM empresa WHERE codigoempresa = ?";

    public List<Empresa> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empresa empresa = null;
        List<Empresa> empresas = new ArrayList<Empresa>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoempresa = rs.getInt("codigoempresa");
                String nombreempresa = rs.getString("nombreempresa");
                               
                empresa = new Empresa();
                empresa.setCodigoEmpresa(codigoempresa);
                empresa.setNombreEmpresa(nombreempresa);
                                
                empresas.add(empresa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return empresas;
    }

    public int insert(Empresa empresa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empresa.getNombreEmpresa());
            
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

    public int update(Empresa empresa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empresa.getNombreEmpresa());
            stmt.setInt(2, empresa.getCodigoEmpresa());
            
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

    public int delete(Empresa empresa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empresa.getCodigoEmpresa());
            
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
    public Empresa query(Empresa empresa) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Empresa> empresas = new ArrayList<Empresa>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, empresa.getCodigoEmpresa());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoempresa = rs.getInt("codigoempresa");
                String nombreempresa = rs.getString("nombreempresa");
                                
                empresa = new Empresa();
                empresa.setCodigoEmpresa(codigoempresa);
                empresa.setNombreEmpresa(nombreempresa);
                
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
        return empresa;
    }
    
}
