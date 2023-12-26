package com.corenetworks.presentacion;

import com.corenetworks.modelo.Paqueteria;
import com.corenetworks.persistencia.AccesoPaqueteria;

import java.sql.SQLException;

public class ProbarPaqueteria {
    public static void main(String[] args) {
        AccesoPaqueteria aP1=new AccesoPaqueteria();
       /* Paqueteria p1=new Paqueteria(200,"Correos","654345667");
        try {
            System.out.println("Añladir paqueteria "+aP1.alta(p1));
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        Paqueteria p2=new Paqueteria(200,"Correos","606791819");
        try {
            System.out.println("modificar telefono"+aP1.modificar(p2));
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }


        try {
            System.out.println("eliminar el ID->"+aP1.eliminar(200));
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }

        try {
            System.out.println("Consultar la id "+aP1.consultarUnShipper(1));
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
         */
        try {
            System.out.println(aP1.consultarTodo());
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
