/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.Conexion;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo
 */
public class UsuarioDAO extends Conexion implements Crud{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    // Declarar variables del modulo(VO)
    private String id_Usuarios = "", Nombre = "", Documento = "", Telefono = "",
            Email = "", Direccion = "", Estado = "", Contrasena = "";

    //2. Crear metodo principal para recibir los datos del VO
    public UsuarioDAO(UsuarioVO usuVO) {
        super();

        //3. Conectarse a la base de datos
        try {

            conexion = this.obtenerConexion();
            // 4. traer al DAO los datos del VO para hacer las operaciones.

            id_Usuarios = usuVO.getIdUsuarios();
            Nombre = usuVO.getNombre();
            Documento = usuVO.getDocumento();
            Telefono = usuVO.getTelefono();
            Email = usuVO.getEmail();
            Direccion = usuVO.getDireccion();
            Estado = usuVO.getEstado();
            Contrasena = usuVO.getContrasena();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            //Armar sentencia
            sql = "insert into usuarios( Nombre, Documento, Telefono, Email, Direccion,"
                    + " Estado, Contrasena) values (?,?,?,?,?,?,?)";
            // crear el camino por donde va la sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Nombre);
            puente.setString(2, Documento);
            puente.setString(3, Telefono);
            puente.setString(4, Email);
            puente.setString(5, Direccion);
            puente.setString(6, Estado);
            puente.setString(7, Contrasena);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {

        try {
            sql = "update usuarios set ( Nombre = ?, Documento = ?, Telefono = ?, Email = ?"
                    + ", Direccion = ?, Estado = ?, Contrasena = ?) where id_Usuarios = ? " ;
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Nombre);
            puente.setString(2, Documento);
            puente.setString(3, Telefono);
            puente.setString(4, Email);
            puente.setString(5, Direccion);
            puente.setString(6, Estado);
            puente.setString(7, Contrasena);
            puente.setString(8, id_Usuarios);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {

        try {
            //Armar sentencia
            sql = "delete from usuarios where id_Usuarios" + id_Usuarios;
            puente = conexion.prepareStatement(sql);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
    
    public boolean iniciarSesion(String Documento, String Contrasena) {

        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuarios where Documento = ? and Contrasena = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Documento);
            puente.setString(2, Contrasena);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {

                operacion = true;

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

}
