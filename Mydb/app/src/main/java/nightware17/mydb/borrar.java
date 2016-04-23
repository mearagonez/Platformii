package nightware17.mydb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Vector;

public class borrar extends AppCompatActivity {
    public static Vector<Ife> r;
    public static Vector<String> vs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        llenanombres();
    }

    public void llenanombres(){
        r = MainActivity.d.consultarIfec();
        vs = new Vector<String>();
        for(Ife ife : r){
            vs.add(ife.getIfe());
        }
        Spinner s = (Spinner) findViewById(R.id.spName);
        colocarEnSpinner(vs, s);
    }

    private void colocarEnSpinner(Vector<String>r, Spinner s){
        Object[] ss = r.toArray();
        int longitud = ss.length;
        String[] a = new String[longitud];

        for (int x=0; x<=a.length-1; x++){
            a[x] = String.valueOf(ss[x]);
        }

        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,a);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void sePulsoEliminarIfe(View view){
        try{
            Spinner s = (Spinner) findViewById(R.id.spName);
            int pos = s.getSelectedItemPosition();
            int idABorrar = ((Ife)r.elementAt(pos)).getId();
            MainActivity.d.eliminarIfe(idABorrar);
            Toast.makeText(this, "IFE eliminado\n", Toast.LENGTH_SHORT).show();
            finish();
        }catch(Exception ex){
            Toast.makeText(this, "ERROR : \n"+ ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        llenanombres();
    }




}
