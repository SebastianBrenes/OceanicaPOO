package oceanica;

/**
 *
 * @author Portatil_HP
 */
public class Luchador {
    private String nombre;
    private double porcentajeRepresentacion;
    private int fuerza;
    private int resistencia;
    private int autosanidad;
    private String grupoAtaque;
    
    // Constructor
    public Luchador(String nombre, double porcentajeRepresentacion, int fuerza, int resistencia, int autosanidad, String grupoAtaque) {
        this.nombre = nombre;
        this.porcentajeRepresentacion = porcentajeRepresentacion;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.autosanidad = autosanidad;
        this.grupoAtaque = grupoAtaque;
    }
    
    // Métodos getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentajeRepresentacion() {
        return porcentajeRepresentacion;
    }

    public void setPorcentajeRepresentacion(double porcentajeRepresentacion) {
        this.porcentajeRepresentacion = porcentajeRepresentacion;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getAutosanidad() {
        return autosanidad;
    }

    public void setAutosanidad(int autosanidad) {
        this.autosanidad = autosanidad;
    }

    public String getGrupoAtaque() {
        return grupoAtaque;
    }

    public void setGrupoAtaque(String grupoAtaque) {
        this.grupoAtaque = grupoAtaque;
    }
    
}