package models;

public abstract class JuegoBase {
    //ATRIBUTOS --------------------------------------------------------
    protected String titulo;
    protected String creador;
    protected String genero;
    protected String id;

    //CONSTRUCTOR -------------------------------------------------------
    public JuegoBase(String titulo,String creador,String genero,String id){
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
        this.id = id;
    }

    //GETTERS ------------------------------------------------------------
    public String getTitulo() {
        return titulo;
    }

    public String getCreador() {
        return creador;
    }

    public String getGenero() {
        return genero;
    }

    public String getId() {
        return id;
    }

    //SETTERS -----------------------------------------------------------
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //METODO EQUALS Y HASHCODE -----------------------------------------
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        JuegoBase juego = (JuegoBase) obj;
        return id.equals(juego.id);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }
}
