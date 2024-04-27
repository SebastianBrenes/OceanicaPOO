package oceanica;

/**
 *
 * @author Portatil_HP
 */
public class Ataque {
    private String nombre;
    private String tipo;
    private int danno; // daño
    
    // Constructor
    public Ataque(String nombre, String tipo, int danio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.danno = danno;
    }
    
    // Métodos getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }
    
}
