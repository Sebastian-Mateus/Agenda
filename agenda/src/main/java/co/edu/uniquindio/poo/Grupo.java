package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Grupo {
    public String nombre;
    public String categoria;
    public Collection<Contacto> contactosg;

    /**
     * Metodo constructor de la clase Grupo
     * @param nombre
     * @param categoria
     */
    public Grupo(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        contactosg = new LinkedList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Collection<Contacto> getContactosg() {
        return contactosg;
    }

    public void setContactosg(Collection<Contacto> contactosg) {
        this.contactosg = contactosg;
    }

    /**
     * Metodo toString de la clase Grupo
     */
    @Override
    public String toString() {
        String mensaje = "-Grupo-\nNombre: " + nombre + "\nCategoría: " + categoria + "\nLista de Contactos:\n";
        int i = 1;
        for (Contacto contacto : contactosg) {
            mensaje += "- Contacto #" + i + ":\n" + contacto.toString() + "\n";
            i++;
        }
        return mensaje;
    }
}