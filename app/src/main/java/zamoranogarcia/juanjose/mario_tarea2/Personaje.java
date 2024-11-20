package zamoranogarcia.juanjose.mario_tarea2;


// creamos la clase personaje con sus atributos

public class Personaje {
    private String nombre;
    private int imagen;
    private String descripcion;
    private String habilidades;

    public Personaje(String nombre, int imagen, String descripcion, String habilidades) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHabilidades() {
        return habilidades;
    }
}
