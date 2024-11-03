package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;



public class Agenda {

    private String nombre;
    public Collection<Contacto> contactos;
    public Collection<Grupo> grupos;
    public Collection<Reunion> reuniones;

    public Agenda(String nombre) {
        this.nombre = nombre;
        contactos = new LinkedList<>();
        grupos = new LinkedList<>();
        reuniones = new LinkedList<>();
    }

    // Metodos //

    public void menu() {
        imprimir("------------------------");
        imprimir("Agenda de Contactos: " + nombre);
        imprimir("1. Acceso a Contactos.");
        imprimir("2. Acceso a Grupo.");
        imprimir("3. Acceso a Reuniones.");
        imprimir("4. Salir.");
        int num = ingresarEntero("¿Qué quieres consultar?:");
        switch (num) {
            case 1:
                submenu(num);
                break;
            case 2:
                submenu(num);
                break;
            case 3:
                submenu(num);
                break;
            case 4:
                imprimir("Saliendo del Aplicativo...");
                System.exit(0);
                break;
            default:
                imprimir("La opción ingresada es incorrecta.");
                menu();
                break;
        }
    }

    public void submenu(int num) {
        switch (num) {
            case 1:
                operacionContacto();
                break;
            case 2:
                operacionGrupo();
                break;
            case 3:
                operacionReunion();
                break;
            default:
                break;
        }
    }

    public void operacionContacto() {
        imprimir("------------------------");
        imprimir("1. Crear Contacto.");
        imprimir("2. Eliminar Contacto.");
        imprimir("3. Mostrar Contacto.");
        imprimir("4. Modificar Contacto.");
        imprimir("5. Regresar.");

        int num = ingresarEntero("Seleccione una opción:");
        switch (num) {
            case 1:
                crearContacto();
                break;
            case 2:
                eliminarContacto();
                break;
            case 3:
                mostrarContacto();
                break;
            case 4:
                modificarContacto();
                break;
            case 5:
                menu();
                break;
            default:
                imprimir("Opción Incorrecta.");
                operacionContacto();
                break;
        }
    }

    public void crearContacto() {
        imprimir("------------------------");
        String nombre = ingresarCadena("Nombre: ");
        String telefono = ingresarCadena("Telefono: ");

        if (verificarContacto(nombre, telefono)) {
            imprimir("El contacto ya existe.");
            submenu(1);
        } else {
            String alias = ingresarCadena("Alias: ");
            String direccion = ingresarCadena("Direccion: ");
            String email = ingresarCadena("Email: ");
            Contacto contacto = new Contacto(nombre, alias, telefono, direccion, email);
            agregarContacto(contacto);
            imprimir("Se ha creado el contacto.");
            submenu(1);
        }
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public boolean verificarContacto(String nombre, String telefono) {
        boolean verificar = false;
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)) {
                verificar = true;
            }
        }
        return verificar;
    }

    public void eliminarContacto() {
        imprimir("------------------------");
        String nombre = ingresarCadena("Ingrese el nombre: ");
        String celular = ingresarCadena("Ingrese el telefono: ");
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(celular)) {
                contactos.remove(contacto);
                imprimir("El contacto se ha eliminado con exito.");
                submenu(1);
            }
        }
        imprimir("No existe el contacto.");
        submenu(1);
    }

    public void mostrarContacto() {
        String nombre = ingresarCadena("Ingrese el nombre: ");
        String celular = ingresarCadena("Ingrese el telefono: ");
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(celular)) {
                imprimir("------------------------");
                imprimir(contacto.toString());
                submenu(1);
            }
        }
        imprimir("No existe el contacto.");
        submenu(1);
    }

    public void modificarContacto() {
        imprimir("------------------------");
        String nombre = ingresarCadena("Ingrese el nombre: ");
        String celular = ingresarCadena("Ingrese el telefono: ");
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(celular)) {
                imprimir("------------------------");
                imprimir(contacto.toString());
                imprimir("------------------------");
                imprimir("1. Nombre.");
                imprimir("2. Alias.");
                imprimir("3. Telefono.");
                imprimir("4. Dirección");
                imprimir("5. Email.");
                imprimir("6. Regresar.");
                boolean repetir = true;
                while (repetir) {
                    imprimir("------------------------");
                    int num = ingresarEntero("Seleccione una modificación: ");
                    switch (num) {
                        case 1:
                            contacto.setNombre(ingresarCadena("Ingrese un nuevo Nombre: "));
                            break;
                        case 2:
                            contacto.setAlias(ingresarCadena("Ingrese un nuevo Alias: "));
                            break;
                        case 3:
                            contacto.setTelefono(ingresarCadena("Ingrese un nuevo Telefono: "));
                            break;
                        case 4:
                            contacto.setDireccion(ingresarCadena("Ingrese una nueva Direccion: "));
                            break;
                        case 5:
                            contacto.setEmail(ingresarCadena("Ingrese un nuevo Email: "));
                            break;
                        case 6:
                            submenu(1);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        imprimir("El contacto no existe.");
        submenu(1);
    }

    public void operacionGrupo() {
        imprimir("------------------------");
        imprimir("1. Crear Grupo.");
        imprimir("2. Eliminar Grupo.");
        imprimir("3. Mostrar Grupo.");
        imprimir("4. Modificar Grupo.");
        imprimir("5. Regresar.");
        int num = ingresarEntero("Seleccione una opción:");
        switch (num) {
            case 1:
                crearGrupo();
                break;
            case 2:
                eliminarGrupo();
                break;
            case 3:
                mostrarGrupo();
                break;
            case 4:
                modificarGrupo();
                break;
            case 5:
                menu();
                break;
            default:
                imprimir("Opción Incorrecta.");
                operacionGrupo();
                break;
        }
    }

    public void crearGrupo() {
        imprimir("------------------------");
        String nombre = ingresarCadena("Nombre del grupo: ");
        if (verificarGrupo(nombre)) {
            imprimir("El grupo ya existe");
        } else {
            imprimir("------------------------");
            String categoria = determinarCategoria();
            Grupo grupo = new Grupo(nombre, categoria);
            grupos.add(grupo);
            imprimir("El grupo se ha creado con exito.");

        }
        submenu(2);
    }

    /**
     * 
     * @param verificacion
     * @param nombre
     */
    public void opcionesGrupo(boolean verificacion, String nombre) {
        if (verificacion) {
            Grupo grupo = buscarGrupo(nombre);
            imprimir("--------------------\n" + grupo.toString() + "\n--------------------");
            imprimir(
                    "¿Qué desea modificar?\n\n1. Nombre\n2. Categoria\n3. Agregar integrantes\n4. Eliminar integrantes\n5. Regresar");
            int contador = grupo.getContactosg().size();
            int opcion = ingresarEntero("Seleccione una modificación:");
            switch (opcion) {
                case 1:
                    String nombre1 = ingresarCadena("Ingrese un nuevo nombre para el grupo: ");
                    grupo.setNombre(nombre1);
                    opcionesGrupo(verificacion, nombre1);
                    break;
                case 2:
                    grupo.setCategoria(determinarCategoria());
                    opcionesGrupo(verificacion, nombre);
                    break;
                case 3:
                    if (contador < 5) {
                        Contacto contacto = buscarContacto();
                        if (contacto != null) {
                            if (grupo.getContactosg().contains(contacto)) {
                                imprimir("El contacto ya esta en el grupo.");
                            } else {
                                grupo.getContactosg().add(contacto);
                                contador += 1;
                                imprimir("El contacto ha sido agregado.");
                            }
                        } else {
                            imprimir("El contacto no existe.");
                        }
                    }
                    if (contador > 4) {
                        imprimir("El grupo tiene el maximo de integrantes permitidos.");
                    }
                    opcionesGrupo(verificacion, nombre);
                    break;
                case 4:
                    Contacto contacto = buscarContacto();
                    if (contacto != null) {
                        if (grupo.getContactosg().contains(contacto)) {
                            grupo.getContactosg().remove(contacto);
                            imprimir("Contacto eliminado con exito.");
                        } else {
                            imprimir("El contacto no esta en el grupo.");
                        }
                    } else {
                        imprimir("El contacto no existe.");
                    }
                    opcionesGrupo(verificacion, nombre);
                    break;
                case 5:
                    submenu(2);
                    break;
                default:
                    imprimir("Opción incorrecta.");
                    opcionesGrupo(verificacion, nombre);
                    break;
            }
        } else {
            imprimir("El grupo no existe");
            submenu(2);
        }
    }

    public void modificarGrupo() {
        imprimir("------------------------");
        String nombre = ingresarCadena("Nombre del grupo a modificar: ");
        opcionesGrupo(verificarGrupo(nombre), nombre);
    }

    public void eliminarGrupo() {
        imprimir("------------------------");
        String nombre = ingresarCadena("Ingrese el nombre del grupo a eliminar: ");
        boolean verificar = verificarGrupo(nombre);
        if (verificar) {
            for (Grupo grupo : grupos) {
                if (grupo.getNombre().equals(nombre)) {
                    grupos.remove(grupo);
                    imprimir("El grupo ha sido eliminado");
                }
            }
        } else {
            imprimir("El grupo no existe");
        }
        submenu(2);
    }

    public Grupo buscarGrupo(String nombre) {
        for (Grupo grupo : grupos) {
            if (grupo.getNombre().equals(nombre)) {
                return grupo;
            }
        }
        return null;
    }

    public boolean verificarGrupo(String nombre) {
        boolean verificar = false;
        for (Grupo grupo : grupos) {
            if (grupo.getNombre().equals(nombre)) {
                verificar = true;
            }
        }
        return verificar;
    }


    /**
     * Metodo para imprimir la informacion de un grupo
     */
    public void mostrarGrupo() {
        String nombre = ingresarCadena("Ingrese el nombre del grupo a buscar:");
        boolean existe = false;
        for (Grupo grupo : grupos) {
            if (grupo.getNombre().equals(nombre)) {
                imprimir("------------------------");
                imprimir(grupo.toString());
                operacionGrupo();
                existe = true;
                break;
            }
        }
        if (!existe) {
            imprimir("El grupo no existe");
            operacionGrupo();
        }
    }

    /**
     * Metodo para determinar la categoria de un grupo
     * @return
     */
    public String determinarCategoria() {
        int numero = ingresarEntero("Categoria:\n1. Oficina\n2. Familia\n3. Amigos\n4. Fiesta");
        String categoria = ("");
        switch (numero) {
            case 1:
                categoria = ("Oficina");
                break;
            case 2:
                categoria = ("Familia");
                break;
            case 3:
                categoria = ("Amigos");
                break;
            case 4:
                categoria = ("Fiesta");
                break;
        }
        return categoria;
    }

/**
 * Metodo para gestionar las reuniones 
 */
    public void operacionReunion() {
        imprimir("------------------------");
        imprimir("1. Crear Reunion.");
        imprimir("2. Eliminar Reunion.");
        imprimir("3. Mostrar Reunion.");
        imprimir("4. Modificar Reunion.");
        imprimir("5. Regresar.");
        int num = ingresarEntero("Seleccione una opción:");
        switch (num) {
            case 1:
                crearReunion();
                break;
            case 2:
                eliminarReunion();
                break;
            case 3:
                mostrarReunion();
                break;
            case 4:
                modificarReunion();
                break;
            case 5:
                menu();
                break;
            default:
                imprimir("Opción Incorrecta.");
                operacionReunion();
                break;
        }
    }

    /**
     * Metodo para crear una reunion verificando que la fecha y hora no estén duplicadas
     */
    public void crearReunion() {
        imprimir("------------------------");
        String fecha = ingresarCadena("Ingrese Fecha de la Reunion: ");
        String hora = ingresarCadena("Ingrese Hora de la Reunion: ");
        if (verificarReunion(fecha, hora)) {
            imprimir("Se ha encontrado una Reunion en dicho momento.");
            submenu(3);
        } else {
            String descripcion = ingresarCadena("Ingrese Descripcion de la Reunion: ");
            Reunion reunion = new Reunion(descripcion, fecha, hora);
            agregarReunion(reunion);
            imprimir("Se ha creado la Reunion.");
            submenu(3);
        }
    }

    /*
     * Metodo para agregar una reunion a la lista de reuniones
     */
    public void agregarReunion(Reunion reunion) {
        reuniones.add(reunion);
    }

    /**
     * Metodo para verificar la existencia de una reunion 
     * @param fecha
     * @param hora
     * @return verificar 
     */
    public boolean verificarReunion(String fecha, String hora) {
        boolean verificar = false;
        for (Reunion reunion : reuniones) {
            if (reunion.getFecha().equals(fecha) && reunion.getHora().equals(hora)) {
                verificar = true;
            }
        }
        return verificar;
    }

    /**
     * Metodo para eliminar una reunion
     */
    public void eliminarReunion() {
        imprimir("------------------------");
        String fecha = ingresarCadena("Ingrese Fecha de la Reunion: ");
        String hora = ingresarCadena("Ingrese Hora de la Reunion: ");
        for (Reunion reunion : reuniones) {
            if (reunion.getFecha().equals(fecha) && reunion.getHora().equals(hora)) {
                reuniones.remove(reunion);
                imprimir("Se ha eliminado con exito la Reunion.");
                submenu(3);
            }
        }
        imprimir("No se ha encontrado una Reunion en dicho momento.");
        submenu(3);
    }

/**
 * Metodo para mostrar la informacion de una reunion
 */
    public void mostrarReunion() {
        imprimir("------------------------");
        String fecha = ingresarCadena("Ingrese Fecha de la Reunion: ");
        String hora = ingresarCadena("Ingrese Hora de la Reunion: ");
        for (Reunion reunion : reuniones) {
            if (reunion.getFecha().equals(fecha) && reunion.getHora().equals(hora)) {
                imprimir("------------------------");
                imprimir(reunion.toString());
                submenu(3);
            }
        }
        imprimir("No se ha encontrado una Reunion en dicho momento.");
        submenu(3);
    }
/**
 * Metodo para buscar una reunion que se quiera modificar
 */
    public void modificarReunion() {
        imprimir("------------------------");
        String fecha = ingresarCadena("Ingrese Fecha de la Reunion: ");
        String hora = ingresarCadena("Ingrese Hora de la Reunion: ");
        for (Reunion reunion : reuniones) {
            if (reunion.getFecha().equals(fecha) && reunion.getHora().equals(hora)) {
                opcionesReunion(reunion);
                break;
            }
            imprimir("No se ha encontrado una Reunion en dicho momento.");
            submenu(3);
        }
    }

    /**
     * Metodo para gestionar las modificaciones realizables de una reunion
     * @param reunion
     */
    public void opcionesReunion(Reunion reunion) {
        imprimir("------------------------");
        imprimir(reunion.toString());
        imprimir("------------------------");
        imprimir("1. Fecha.");
        imprimir("2. Hora");
        imprimir("3. Descripción.");
        imprimir("4. Agregar Asistente.");
        imprimir("5. Eliminar Asistente.");
        imprimir("6. Regresar.");
        int num = ingresarEntero("Seleccione una modifación: ");
        switch (num) {
            case 1:
                reunion.setFecha(ingresarCadena("Ingrese nueva Fecha: "));
                opcionesReunion(reunion);
                break;
            case 2:
                reunion.setHora(ingresarCadena("Ingrese nueva Hora: "));
                opcionesReunion(reunion);
                break;
            case 3:
                reunion.setDescripcion(ingresarCadena("Ingrese nueva Descripción: "));
                opcionesReunion(reunion);
                break;
            case 4:      
                Contacto contacto = buscarContacto();
                if (contacto != null) {
                    if (reunion.getContactosR().contains(contacto)) {
                    imprimir("El contacto ya está en el reunion.");
                    opcionesReunion(reunion);
                    } else {
                    reunion.getContactosR().add(contacto);
                    imprimir("El contacto se ha agregado exitosamente.");
                    opcionesReunion(reunion);
                    }
                } else {
                    imprimir("El contacto no existe.");
                    opcionesReunion(reunion);
                }
                break;
            case 5:
                Contacto contacto1 = buscarContacto();
                if (contacto1 != null) {
                    if (reunion.getContactosR().contains(contacto1)) {
                    reunion.getContactosR().remove(contacto1);
                    imprimir("El contacto ha sido eliminado.");
                    opcionesReunion(reunion);
                    } else {
                    imprimir("El contacto no está en la reunion.");
                    opcionesReunion(reunion);
                    }
                } else {
                    imprimir("El contacto no existe.");
                    opcionesReunion(reunion);
                }
                break;
            case 6:
                submenu(3);
                break;
            default:
                imprimir("Opción incorrecta.");
                opcionesReunion(reunion);
                break;
        }
    }

    /**
     * Metodo para buscar un contacto en la lista de contactos.
     * @return contacto
     */
    public Contacto buscarContacto() {
        String nombre = ingresarCadena("Ingrese nombre del contacto: ");
        String telefono = ingresarCadena("Ingrese telefono del contacto: ");
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)) {
                return contacto;
            }
        }
        return null;
    }

    /**
     * Metodo para imprimir en la consola
     * @param texto
     */

    public static void imprimir(String texto) {
        System.out.println(texto);
    }

/**
 * Metodo para ingresa una cadena
 * @param texto
 * @return cadena
 */

    public static String ingresarCadena(String texto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(texto);
        String cadena = scanner.nextLine();
        return cadena;
    }

  

    /**
     * Metodo para ingresar un numero entero, cualquier dato invalido
     * @param texto
     * @return num
     */
    public static int ingresarEntero(String texto) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean repetir = true;
        while (repetir) {
            try {
                System.out.println(texto);
                num = Integer.parseInt(scanner.nextLine());
                repetir = false;
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado es invalido.");
            }
        }
        return num;
    }
}