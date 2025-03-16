package models;

public class Juego extends JuegoBase{
    //ATRIBUTOS ------------------------------------------------------
    private int version;

    //CONSTRUCTOR ----------------------------------------------------
    public Juego(String titulo,String creador,String genero,String id,int version){
        super(titulo,creador,genero,id);
        //Valido que la version sea positiva
        if(version <=0) throw new IllegalArgumentException("La version debe ser positiva.");
        this.version = version;
    }

    //GETTERS --------------------------------------------------------
    public int getVersion() {
        return version;
    }

    //SETTERS --------------------------------------------------------
    public void setVersion(int version) {
        this.version = version;
    }
}
