package nightware17.losign;

/**
 * Created by drm_6 on 2016-04-23.
 */
public class data {

    private String campo;
    private String dato;

    public data(String campo, String dato) {
        this.campo = campo;
        this.dato = dato;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
