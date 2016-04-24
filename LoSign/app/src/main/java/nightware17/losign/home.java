
package nightware17.losign;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;


public class home extends AppCompatActivity {
    private ArrayList<data> listadatos;

    ListView lista;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        SharedPreferences prefe=getSharedPreferences("register", Context.MODE_PRIVATE);
        listadatos=new ArrayList<data>();
        listadatos.add(new data("Name",prefe.getString("name","")));
        listadatos.add(new data("Email",prefe.getString("email","")));
        listadatos.add(new data("Password-Encrypted",random()));

        AdaptadorData adaptador = new AdaptadorData(this);
        lista = (ListView)findViewById(R.id.lista);
        lista.setAdapter(adaptador);

    }

    public void edit(View view){
        Intent i = new Intent(this, register.class);
        i.putExtra("tipo","editar");
        startActivity(i);
        finish();
    }

    class AdaptadorData extends ArrayAdapter<data> {

        AppCompatActivity appCompatActivity;

        AdaptadorData(AppCompatActivity context) {
            super(context, R.layout.lista, listadatos);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista, null);

            TextView txtcampo = (TextView)item.findViewById(R.id.txt_campo);
            TextView txtdata = (TextView)item.findViewById(R.id.txt_data);

            txtcampo.setText(listadatos.get(position).getCampo());
            txtdata.setText(listadatos.get(position).getDato());

            return(item);
        }
    }

    private String random(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }


}
