/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.loteMateriaPrimaVO;
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
 * @author Sena
 */
public class loteMateriaPrimaDAO extends Conexion implements Crud{
    
     private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    // Declarar variables del modulo(VO)
    private String Id_loteMateria_Prima = "",cantidad = "", observaciones = "", fecha_ingreso = "", fecha_salida = "", Id_Materia_Prima = "";

    //2. Crear metodo principal para recibir los datos del VO
    public loteMateriaPrimaDAO(loteMateriaPrimaVO loteMPVO) {
        super();

        //3. Conectarse a la base de datos
        try {

            conexion = this.obtenerConexion();
            // 4. traer al DAO los datos del VO para hacer las operaciones.

            Id_loteMateria_Prima = loteMPVO.getId_loteMateria_Prima();
            cantidad = loteMPVO.getCantidad();
            observaciones = loteMPVO.getObservaciones();
            fecha_ingreso = loteMPVO.getFecha_ingreso();
            fecha_salida = loteMPVO.getFecha_salida();
            Id_Materia_Prima = loteMPVO.getId_Materia_Prima();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            //Armar sentencia
            sql = "insert into lotemateria_prima( cantidad, observaciones, fecha_ingreso, fecha_salida, Id_Materia_Prima) values (?,?,?,?,?)";
            // crear el camino por donde va la sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, cantidad);
            puente.setString(2, observaciones);
            puente.setString(3, fecha_ingreso);
            puente.setString(4, fecha_salida);
            puente.setString(5, Id_Materia_Prima);
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
            sql = "update lotemateria_prima set ( cantidad = ?, observaciones = ? fecha_ingreso = ?, fecha_salida = ?) where Id_loteMateria_Prima = ? " ;
            puente = conexion.prepareStatement(sql);
            puente.setString(1, cantidad);
            puente.setString(2, observaciones);
            puente.setString(3, fecha_ingreso);
            puente.setString(4, fecha_salida);
            puente.setString(5, Id_loteMateria_Prima);
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
            sql = "delete from lotemateria_prima where Id_loteMateria_Prima" + Id_loteMateria_Prima;
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
    
}
