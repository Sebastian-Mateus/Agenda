package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Reunion {
    public String descripcion;
    public String fecha;
    public String hora;
    public Collection<Contacto> contactosR;

    /*
     * 
     */
    public Reunion(String descripcion, String fecha, String hora) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        contactosR = new LinkedList<>();
    }



    @Override
    public String toString() {
        String mensaje = "-Reunion-\nDescripcion: " + descripcion + "\nFecha: " + fecha + "\nHora: " + hora + "\nLista de Contactos:\n";
        int i = 1;
        for (Contacto contacto : contactosR) {
            mensaje += "- Contacto #" + i + ":\n" + contacto.toString() + "\n";
            i++;
        }
        return mensaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Collection<Contacto> getContactosR() {
        return contactosR;
    }

    public void setContactosR(Collection<Contacto> contactosR) {
        this.contactosR = contactosR;
    }

}