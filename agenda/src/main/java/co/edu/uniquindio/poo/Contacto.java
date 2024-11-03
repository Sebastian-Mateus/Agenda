package co.edu.uniquindio.poo;

public class Contacto {

    public String nombre;
    public String alias;
    public String telefono;
    public String direccion;
    public String email;

    public Contacto(String nombre, String alias, String telefono, String direccion, String email) {

        this.nombre = nombre;
        this.alias = alias;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    @Override
    public String toString() {
        return "\tNombre: " + nombre + "\n\tAlias: " + alias + "\n\tTelefono: " + telefono + "\n\tDireccion: " + direccion
                + "\n\tEmail: " + email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}