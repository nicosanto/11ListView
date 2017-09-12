package nicosanto.a11listview;

import java.io.Serializable;

/**
 * Created by nicol on 31/08/2017.
 */
//Contacto implements Serializable
public class Contacto implements Serializable {
    //Declaracion de Atributos
    private int telefono;
    private String nombre;
    private String apellido;
    //------*---------
    private String remitente;
    private String destinatario;
    private String asunto;
    private String mensaje;
    private String fecha;
    private String color;
    private String email;

    //Constructor Completo
    public Contacto( String remitente, String asunto, String mensaje, String fecha, String email) {
    //public Contacto( int telefono, String nombre, String apellido) {
         //Los parametros que recibo los asigno al atributo
        //  this.telefono = telefono;
        //  this.nombre = nombre;
          //this.apellido = apellido;
        this.remitente = remitente;
         this.asunto = asunto;
        this.mensaje = mensaje;
         this.fecha = fecha;
        this.email = email;
    }


    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //------*---------
    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //Crear una propiedad con colores y devolver uno random.
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
