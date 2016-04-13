package nightware17.randroid;

/**
 * Created by drm_6 on 2016-04-12.
 */
public class image {

    private String nombre;
    private int idDrawable;

    public image(String nombre,int idDrawable) {
        this.idDrawable = idDrawable;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static image[] ITEMS = {
           new image("ask",R.mipmap.ic_ask),
           new image("launcher",R.mipmap.ic_launcher),
            new image("thumbs",R.mipmap.ic_thumbs),
            new image("time",R.mipmap.ic_time),
            new image("usb",R.mipmap.ic_usb)
    };

    public static image getItem(int id) {
        for (image item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
