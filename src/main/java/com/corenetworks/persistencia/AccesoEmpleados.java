


package com.corenetworks.persistencia;


import com.corenetworks.modelo.Empleado;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoEmpleados extends Conexion{
    public boolean alta(Empleado e) throws SQLException, ClassNotFoundException {
        //1 variables
        PreparedStatement sentencia;
        int resultado=0;
        String sql= "insert into employees (employee_id, last_name,first_name,reports_to) values (?, ?,?,?);";
        //2 abrir conexion
        abrirConexion();
        //3 crear statement
        sentencia = miConexion.prepareStatement(sql);
        //3A dar valor a los parametros
        sentencia.setInt(1,e.getIdEmpleado());
        sentencia.setString(2,e.getApellidos());
        sentencia.setString(3,e.getNombre());
        sentencia.setInt(4,e.getJefe());
        //4 actualizar
        resultado= sentencia.executeUpdate();
        //5. Devolver el resultado
        return resultado >0;

    }

    public boolean modificarSP(Empleado e) throws SQLException, ClassNotFoundException {
        //1.Declarar variables
        PreparedStatement sentencia;
        int resultado = 0;
        String sql = "update employees set first_name = ? where employee_id=?";
        //2. Abrir la conexion
       abrirConexion();
        //3. Crear el Statement
        sentencia = miConexion.prepareStatement(sql);
        //3a. insertar parámetro
        sentencia.setString(1,e.getNombre());
        sentencia.setInt(2, e.getIdEmpleado());
        //4. Modificar
        resultado = sentencia.executeUpdate();
        //5. Devolver el resultado
        return resultado > 0;
    }



    public  boolean eliminar(int id) throws SQLException, ClassNotFoundException {
        //1 variables
        Statement sentencia;
        int resultado = 0;
        String sql = "Delete from employees where employee_id=" + id;
        //2 abrir conexion
        abrirConexion();
        //3 crear statement
        sentencia=miConexion.createStatement();
        //4 eliminar
        resultado=sentencia.executeUpdate(sql);
        //5. Devolver el resultado
        return resultado>0;

    }
}

