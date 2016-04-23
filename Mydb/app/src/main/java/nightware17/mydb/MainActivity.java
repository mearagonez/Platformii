package nightware17.mydb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static Datos d;
    public static Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=this;
        d= new Datos(c);
    }

    public void captura(View view){
        Intent i = new Intent (this, captura.class);
        i.putExtra("tipo", "captura");
        startActivity(i);
    }

    public void buscar(View view){
        change(buscar.class);
    }
    public void borrar(View view){
        change(borrar.class);
    }

    public void change(Class cl){
        Intent i = new Intent (this, cl);
        startActivity(i);
    }
}
