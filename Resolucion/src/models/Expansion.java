package models;

import java.time.LocalDate;

public class Expansion extends JuegoBase{
    //ATRIBUTOS --------------------------------------------------
    private LocalDate fechaLanzamiento;

    //CONSTRUCTOR -----------------------------------------------
    public Expansion(String titulo,String creador,String genero,String id,LocalDate fechaLanzamiento){
        super(titulo, creador, genero, id);
        if(fechaLanzamiento == null) throw new IllegalArgumentException("La fecha de lanzamiento no puedes ser nula.");
        this.fechaLanzamiento = fechaLanzamiento;
    }

    //GETTERS ---------------------------------------------------
    public LocalDate getFechaLanzamiento(){
        return fechaLanzamiento;
    }

    //SETTERS ---------------------------------------------------

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}
