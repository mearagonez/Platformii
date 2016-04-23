package nightware17.mydb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

/**
 * Created by drm_6 on 2016-04-21.
 */
public class Datos extends SQLiteOpenHelper {
    public Datos(Context context){
        super (context, "ife", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE IFE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT, direccion TEXT, casilla TEXT, ife TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void guardarIfe(Ife ife){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO IFE ( nombre,direccion, casilla, ife) ";
        sql = sql +" VALUES(upper('"+ ife.getNombre() +"'),upper('" + ife.getDireccion()+"'),'"+ife.getCasilla() +"',upper('"+ife.getIfe()+"'))";
        db.execSQL(sql);
    }

    public void eliminarIfe(int id){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM IFE WHERE id = " + id;
        db.execSQL(sql);
    }
    public void actualizarIfe( Ife ife){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "UPDATE IFE"+
                " SET nombre=upper('"+ife.getNombre()+"'),direccion=upper('"+ife.getDireccion()+"'),"+
                "casilla='"+ife.getCasilla()+"',ife=upper('"+ife.getIfe()+"')"+
                " WHERE id = " + ife.getId();
        db.execSQL(sql);

    }

    public Vector<Ife> consultarIfec(){
        String sql = "SELECT id,nombre,direccion,casilla,ife FROM IFE ORDER BY nombre";
        return consultarIfe(sql);
    }

    private Vector <Ife> consultarIfe(String sql){
        Vector<Ife> resultado = new Vector<Ife>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext())
        {
            Ife ife = new Ife();
            ife.setId(cursor.getInt(0));
            ife.setNombre(cursor.getString(1));
            ife.setDireccion(cursor.getString(2));
            ife.setCasilla(cursor.getInt(3));
            ife.setIfe(cursor.getString(4));
            resultado.add(ife);
        }
        cursor.close();
        return resultado;
    }

    public Vector <Ife> consultarIfec(String criterio){
        String sql = "SELECT id,nombre,direccion,casilla,ife " +
                " FROM IFE " +
                " WHERE nombre like '"+ criterio + "'" +
                " OR ife like '" + criterio + "'" +
                " ORDER BY nombre";
        return consultarIfe(sql);
    }

    private Vector <String> consultar(String sql){
        Vector<String> resultado = new Vector<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            resultado.add(cursor.getString(0));
        }
        cursor.close();
        return resultado;
    }
}
