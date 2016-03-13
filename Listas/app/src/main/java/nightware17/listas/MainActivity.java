package nightware17.listas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView lblEtiqueta;
    private ListView lstOptiones;

    private Titular[] datos= new Titular[]{
            new Titular("Titulo 1","Subtitulo largo 1"),
            new Titular("Titulo 2","Subtitulo largo 2"),
            new Titular("Titulo 3","Subtitulo largo 3"),
            new Titular("Titulo 4","Subtitulo largo 4"),
            new Titular("Titulo 5","Subtitulo largo 5"),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblEtiqueta=(TextView)findViewById(R.id.lblEtiqueta);
        lstOptiones=(ListView)findViewById(R.id.lstOpciones);

        AdaptadorTitulares adaptador=new AdaptadorTitulares(this,datos);
        lstOptiones.setAdapter(adaptador);

        lstOptiones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcionSelecionado=((Titular)parent.getItemAtPosition(position)).getTitulo();
                lblEtiqueta.setText("Opcion seleccionada: "+opcionSelecionado);
            }
        });

    }
    class AdaptadorTitulares extends ArrayAdapter<MainActivity.Titular>{
        AdaptadorTitulares(Context context,MainActivity.Titular[] datos){
            super(context,R.layout.second_activity,datos);
        }
        public View getView(int position,View convertView, ViewGroup parent){
            View item=convertView;
            ViewHolder holder;
            if (item==null){
                LayoutInflater inflater= LayoutInflater.from(getContext());
                item= inflater.inflate(R.layout.second_activity,null);

                holder =new ViewHolder();
                holder.titulo=(TextView)item.findViewById(R.id.lblTitulo);
                holder.subtitulo=(TextView)item.findViewById(R.id.lblSubtitulo);

                item.setTag(holder);
            }else{
                holder=(ViewHolder)item.getTag();
            }
            holder.titulo.setText(datos[position].getTitulo());
            holder.subtitulo.setText(datos[position].getSubtitulo());

            return (item);
        }
    }

    public class Titular{
        private String titulo;
        private String subtitulo;

        public Titular(String subtitulo, String titulo) {
            this.subtitulo = subtitulo;
            this.titulo = titulo;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getSubtitulo() {
            return subtitulo;
        }
    }

    static class ViewHolder{
        TextView titulo;
        TextView subtitulo;
    }
}
