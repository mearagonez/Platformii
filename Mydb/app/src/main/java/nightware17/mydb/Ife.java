package nightware17.mydb;

/**
 * Created by drm_6 on 2016-04-21.
 */
public class Ife {
    private int id;
    private String ife;
    private String nombre;
    private String direccion;
    private int casilla;

    public Ife(){
        setId(0);
        setNombre("");
        setDireccion("");
        setCasilla(0);
        setIfe("");

    }

    public Ife(int id, String nombre, String direccion, int casilla, String ife) {
        this.casilla = casilla;
        this.direccion = direccion;
        this.nombre = nombre;
        this.ife = ife;
        this.id = id;
    }

    public int getCasilla() {
        return casilla;
    }

    public void setCasilla(int casilla) {
        this.casilla = casilla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIfe() {
        return ife;
    }

    public void setIfe(String ife) {
        this.ife = ife;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String verInfo(){
        return "Id: " + getId() + "\n" +
                "Nombre: " +getNombre() + "\n" +
                "Direccion: " + getDireccion() +"\n" +
                "Casilla: " + getCasilla()+ "\n" +
                "IFE: " + getIfe();
    }
}
