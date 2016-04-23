package nightware17.mydb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Vector;

public class buscar extends AppCompatActivity {
    public static Vector<Ife> resultadoIfe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }

    public void sePulsoBuscar(View view){
        EditText t = (EditText)   findViewById(R.id.txtBusqueda);
        String criterio = t.getText().toString();
        criterio = criterio.replace('*', '%');
        Vector<Ife> resultado = MainActivity.d.consultarIfec(criterio);
        int cuantos = resultado.toArray().length;
        if (cuantos <=0 ){
            Toast.makeText(getApplicationContext(), "La busqueda no produjo resultados", Toast.LENGTH_LONG).show();
        }
        resultadoIfe= new Vector<Ife>();
        resultadoIfe =  resultado;

        String[] nombre = new String[cuantos];

        for (int x=0; x<=cuantos-1; x++) {
            Ife ife = resultado.elementAt(x);
            nombre[x] = ife.getIfe();
        }


        GridView gridView = (GridView) findViewById(R.id.gridViewIfe);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nombre);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Ife tempIfe = resultadoIfe.elementAt(position);

                Toast.makeText(getApplicationContext(), tempIfe.verInfo()+"\n"+"Long Click to Update", Toast.LENGTH_SHORT).show();
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v,int position, long id) {
                 Ife tempIfe = resultadoIfe.elementAt(position);

                Intent i = new Intent (getApplicationContext(), captura.class);
                i.putExtra("tipo", "actualizar");
                i.putExtra("id",""+tempIfe.getId());
                i.putExtra("nombre",tempIfe.getNombre());
                i.putExtra("direccion",tempIfe.getDireccion());
                i.putExtra("casilla",""+tempIfe.getCasilla());
                i.putExtra("ife",tempIfe.getIfe());
                startActivity(i);
                return true;
            }
        });

    }
}
