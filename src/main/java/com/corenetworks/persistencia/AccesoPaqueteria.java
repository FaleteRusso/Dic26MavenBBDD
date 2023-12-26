package com.corenetworks.persistencia;

import com.corenetworks.modelo.Paqueteria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoPaqueteria extends Conexion {
    public boolean alta(Paqueteria p) throws SQLException, ClassNotFoundException {
        //1 variables
        PreparedStatement sentencia;
        int resultado = 0;
        String sql = "insert into shippers (shipper_id,company_name,phone) values (?, ?,?);";
        //2 abrir conexion
        abrirConexion();
        //3 crear statement
        sentencia = miConexion.prepareStatement(sql);
        //3A dar valor a los parametros
        sentencia.setInt(1, p.getId_shipper());
        sentencia.setString(2, p.getNombreCompania());
        sentencia.setString(3, p.getTelefono());

        //4 actualizar
        resultado = sentencia.executeUpdate();
        //5. Devolver el resultado
        return resultado > 0;
    }


    public boolean modificar(Paqueteria p) throws SQLException, ClassNotFoundException {
        //1.Declarar variables
        PreparedStatement sentencia;
        int resultado = 0;
        String sql = "update shippers set phone = ? where shipper_id=?";
        //2. Abrir la conexion
        abrirConexion();
        //3. Crear el Statement
        sentencia = miConexion.prepareStatement(sql);
        //3a. insertar parámetro
        sentencia.setString(1, p.getTelefono());
        sentencia.setInt(2, p.getId_shipper());
        //4. Modificar
        resultado = sentencia.executeUpdate();
        //5. Devolver el resultado
        return resultado > 0;
    }

    public boolean eliminar(int id) throws SQLException, ClassNotFoundException {
        //1 variables
        Statement sentencia;
        int resultado = 0;
        String sql = "Delete from shippers where shipper_id=" + id;
        //2 abrir conexion
        abrirConexion();
        //3 crear statement
        sentencia = miConexion.createStatement();
        //4 eliminar
        resultado = sentencia.executeUpdate(sql);
        //5. Devolver el resultado
        return resultado > 0;
    }

    //consultar uno
    //entrada -> id
    //salida -> shipper
    public Paqueteria consultarUnShipper(int id) throws SQLException, ClassNotFoundException {
        //1. Declarar variables
        PreparedStatement sentencia;
        Paqueteria resultado = null;
        String sql = "Select shipper_id, Company_name, phone from shippers where shipper_id = ?;";
        ResultSet rejilla = null;
        //2. Abrir la conexion
        abrirConexion();
        //3. Crear el statement
        sentencia = miConexion.prepareStatement(sql);
        //3a dar valor a los parámetros
        sentencia.setInt(1, id);
        //4. Actualizar
        rejilla = sentencia.executeQuery();
        if (rejilla.next()) {
            resultado = new Paqueteria(rejilla.getInt("shipper_id")
                    , rejilla.getString("Company_name")
                    , rejilla.getString("phone"));
        }
        //5. Devolver el resultado
        return resultado;
    }

    //consulta todos
    //dato entrada vacio
    //salida  List<Shipper>
    public List<Paqueteria> consultarTodo() throws SQLException, ClassNotFoundException {
        //1. Declarar variables
        Statement sentencia;
        List<Paqueteria> resultado= new ArrayList<>();
        String sql = "Select shipper_id, Company_name, phone from shippers";
        ResultSet rejilla = null;
        //2. Abrir la conexion
        abrirConexion();
        //3. Crear el statement
        sentencia = miConexion.createStatement();

        //4. Actualizar
        rejilla = sentencia.executeQuery(sql);
        while(rejilla.next()){
            resultado.add( new Paqueteria(rejilla.getInt("shipper_id")
                    ,rejilla.getString("Company_name")
                    ,rejilla.getString("phone")));
        }
        //5. Devolver el resultado
        return resultado;
    }

    }



