package nightware17.mydb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class captura extends AppCompatActivity {
    String t="";
    Bundle extras;
    EditText nombre,direccion,ife,casilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);
        extras = getIntent().getExtras();
        t = extras.getString("tipo");

        nombre = (EditText) findViewById(R.id.txt_iname);
        direccion = (EditText) findViewById(R.id.txt_idir);
        ife = (EditText) findViewById(R.id.txt_iife);
        casilla = (EditText) findViewById(R.id.txt_icas);

        if(t.contentEquals("actualizar")){
            nombre.setText(extras.getString("nombre"));
            direccion.setText(extras.getString("direccion"));
            casilla.setText(extras.getString("casilla"));
            ife.setText(extras.getString("ife"));
        }
    }

    public void sePulsoGuardar(View view){
        try {
            Ife i_ife = new Ife();
            i_ife.setNombre(nombre.getText().toString());
            i_ife.setDireccion(direccion.getText().toString());
            i_ife.setCasilla(Integer.parseInt(casilla.getText().toString()));
            i_ife.setIfe(ife.getText().toString());
            if (t.contentEquals("captura")) {

                MainActivity.d.guardarIfe(i_ife);

                Toast.makeText(this, "ALMACENADO : \n" + i_ife.getIfe(), Toast.LENGTH_SHORT).show();
                finish();
            }else{
                i_ife.setId(Integer.parseInt(extras.getString("id")));
                MainActivity.d.actualizarIfe(i_ife);

                Toast.makeText(this, "ACTUALIZADO : \n" + i_ife.getIfe(), Toast.LENGTH_SHORT).show();
                finish();
            }
        } catch (Exception ex) {
            Toast.makeText(this, "ERROR: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
