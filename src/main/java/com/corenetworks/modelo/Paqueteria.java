package com.corenetworks.modelo;

import java.util.Objects;

public class Paqueteria {
    private int id_shipper;
    private String nombreCompania;
    private  String telefono;

    @Override
    public String toString() {
        return "Paqueteria{" +
                "id_shipper=" + id_shipper +
                ", nombreCompania='" + nombreCompania + '\'' +
                ", telefono='" + telefono + '\'' +
                '}'+"\n";
    }

    public Paqueteria() {
    }

    public Paqueteria(int id_shipper, String nombreCompania, String telefono) {
        this.id_shipper = id_shipper;
        this.nombreCompania = nombreCompania;
        this.telefono = telefono;
    }

    public int getId_shipper() {
        return id_shipper;
    }

    public void setId_shipper(int id_shipper) {
        this.id_shipper = id_shipper;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paqueteria that = (Paqueteria) o;
        return id_shipper == that.id_shipper && Objects.equals(nombreCompania, that.nombreCompania) && Objects.equals(telefono,
                that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_shipper, nombreCompania, telefono);
    }
}
