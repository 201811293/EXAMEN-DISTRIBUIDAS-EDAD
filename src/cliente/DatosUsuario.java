package cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DatosUsuario {  
    private String nombre;
    private String apellido;
    private String fecha;

    public DatosUsuario(String nombre, String apellido, String fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
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
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String MensajeCliente() throws ParseException{
        
        String name = this.getNombre();
        String lastname = this.getApellido();
        String date = this.getFecha();   
        //Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
        //System.out.println(date+"\t"+date1);  
        String Mensaje = name + " | " + lastname + " | " + date;
        return Mensaje;
    }
    public String edad() throws ParseException{   
        String date = this.getFecha();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(date, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);       
        int año = periodo.getYears();
        String edad = Integer.toString(año);
        return edad;
    }
    public String MensajeParaElServidor() throws ParseException{
        String nombre = this.getNombre();
        String apellido = this.getApellido();
        String ead = this.edad();        
        //Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
        //System.out.println(date+"\t"+date1);  
        String Mensaje = " El señor(a) "+ nombre +" " + apellido + " tiene " + ead + " años";
        return Mensaje;
    }
}
