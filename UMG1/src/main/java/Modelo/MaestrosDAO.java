/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Maestros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel R
 */
public class MaestrosDAO {
    // Consultas SQL para interactuar con la base de datos
private static final String SQL_SELECT = "SELECT MAE_Código, MAE_Nombre, MAE_Dirección, MAE_Status FROM Maestros";
private static final String SQL_INSERT = "INSERT INTO MAESTROS (MAE_Código, MAE_Nombre, MAE_Dirección, MAE_Status) VALUES (?, ?, ?, ?)";
private static final String SQL_UPDATE = "UPDATE MAESTROS SET MAE_Nombre = ?, MAE_Dirección = ?, MAE_Status = ? WHERE MAE_Código = ?";
private static final String SQL_DELETE = "DELETE FROM MAESTROS WHERE MAE_Código = ?";
private static final String SQL_QUERY = "SELECT MAE_Código, MAE_Nombre, MAE_Dirección, MAE_Status FROM MAESTROS WHERE MAE_Código = ?";

/**
 * Obtiene todos los registros de la tabla MAESTROS.
 * @return Una lista de objetos Maestros.
 */
public List<Maestros> select() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Maestros maestros = null;
    List<Maestros> maestross = new ArrayList<Maestros>();
    try {
        // Establecer la conexión con la base de datos
        conn = Conexion.getConnection();
        // Preparar la consulta SQL
        stmt = conn.prepareStatement(SQL_SELECT);
        // Ejecutar la consulta SQL
        rs = stmt.executeQuery();
        // Procesar los resultados
        while (rs.next()) {
            int MAE_Código = rs.getInt("MAE_Código");
            String MAE_Nombre = rs.getString("MAE_Nombre");
            String MAE_Dirección = rs.getString("MAE_Dirección");
            String MAE_Status = rs.getString("MAE_Status");
            maestros = new Maestros();
            maestros.setMAE_Código(MAE_Código);
            maestros.setMAE_Nombre(MAE_Nombre);
            maestros.setMAE_Dirección(MAE_Dirección);
            maestros.setMAE_Status(MAE_Status);
            maestross.add(maestros);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        // Cerrar los recursos
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return maestross;
}

/**
 * Inserta un nuevo registro en la tabla MAESTROS.
 * @param maestros El objeto Maestros a insertar.
 * @return El número de registros insertados.
 */
public int insert(Maestros maestros) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
        // Establecer la conexión con la base de datos
        conn = Conexion.getConnection();
        // Preparar la consulta SQL
        stmt = conn.prepareStatement(SQL_INSERT);
        // Establecer los parámetros
        stmt.setInt(1, maestros.getMAE_Código());
        stmt.setString(2, maestros.getMAE_Nombre());
        stmt.setString(3, maestros.getMAE_Dirección());
        stmt.setString(4, maestros.getMAE_Status());
        System.out.println("ejecutando query:" + SQL_INSERT);
        // Ejecutar la consulta SQL
        rows = stmt.executeUpdate();
        System.out.println("Registros afectados:" + rows);
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        // Cerrar los recursos
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return rows;
}

/**
 * Actualiza un registro existente en la tabla MAESTROS.
 * @param maestros El objeto Maestros a actualizar.
 * @return El número de registros actualizados.
 */
public int update(Maestros maestros) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
        // Establecer la conexión con la base de datos
        conn = Conexion.getConnection();
        System.out.println("ejecutando query: " + SQL_UPDATE);
        // Preparar la consulta SQL
        stmt = conn.prepareStatement(SQL_UPDATE);
        // Establecer los parámetros
        stmt.setString(1, maestros.getMAE_Nombre());
        stmt.setString(2, maestros.getMAE_Dirección());
        stmt.setString(3, maestros.getMAE_Status());
        stmt.setInt(4, maestros.getMAE_Código());
        // Ejecutar la consulta SQL
        rows = stmt.executeUpdate();
        System.out.println("Registros actualizado:" + rows);
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        // Cerrar los recursos
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return rows;
}

/**
 * Elimina un registro existente en la tabla MAESTROS.
 * @param maestros El objeto Maestros a eliminar.
 * @return El número de registros eliminados.
 */
public int delete(Maestros maestros) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
        // Establecer la conexión con la base de datos
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query:" + SQL_DELETE);
        // Preparar la consulta SQL
        stmt = conn.prepareStatement(SQL_DELETE);
        // Establecer los parámetros
        stmt.setInt(1, maestros.getMAE_Código());
        // Ejecutar la consulta SQL
        rows = stmt.executeUpdate();
        System.out.println("Registros eliminados:" + rows);
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        // Cerrar los recursos
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return rows;
}

/**
 * Busca un registro en la tabla MAESTROS por código.
 * @param maestros El objeto Maestros a buscar.
 * @return El objeto Maestros encontrado.
 */
public Maestros query(Maestros maestros) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        // Establecer la conexión con la base de datos
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query:" + SQL_QUERY);
        // Preparar la consulta SQL
        stmt = conn.prepareStatement(SQL_QUERY);
        // Establecer los parámetros
        stmt.setInt(1, maestros.getMAE_Código());
        // Ejecutar la consulta SQL
        rs = stmt.executeQuery();
        // Procesar los resultados
        while (rs.next()) {
            int MAE_Código = rs.getInt("MAE_Código");
            String MAE_Nombre = rs.getString("MAE_Nombre");
            String MAE_Dirección = rs.getString("MAE_Dirección");
            String MAE_Status = rs.getString("MAE_Status");
            maestros.setMAE_Código(MAE_Código);
            maestros.setMAE_Nombre(MAE_Nombre);
            maestros.setMAE_Dirección(MAE_Dirección);
            maestros.setMAE_Status(MAE_Status);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        // Cerrar los recursos
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return maestros;
}
}
