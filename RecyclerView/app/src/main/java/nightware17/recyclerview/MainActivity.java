package nightware17.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Titular> datos;
    RecyclerView RecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos=new ArrayList<>();
        datos.add(new Titular("DATO1"));
        datos.add(new Titular("DATO2"));
        datos.add(new Titular("DATO3"));
        datos.add(new Titular("DATO4"));
        datos.add(new Titular("DATO5"));
        RecView=(RecyclerView)findViewById(R.id.Recview);
        RecView.setAdapter(new AdaptadorTitulares(datos));
        RecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    public class AdaptadorTitulares extends RecyclerView.Adapter<AdaptadorTitulares.TitularesViewHolder>{

        private ArrayList<Titular> datos;

        public AdaptadorTitulares(ArrayList<Titular> datos){
            this.datos=datos;
        }

        @Override
        public TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
            View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_titular,viewGroup,false);
            return new TitularesViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(TitularesViewHolder holder, int position) {
                holder.bindTitular(datos.get(position));
        }


        @Override
        public int getItemCount(){
            return datos.size();
        }

        public class TitularesViewHolder extends RecyclerView.ViewHolder{

            private TextView txtTitulo;
            public TitularesViewHolder(View itemView) {
                super(itemView);
                txtTitulo=(TextView)itemView.findViewById(R.id.LblTitulo);
            }
            public void bindTitular(Titular t){
                txtTitulo.setText(t.getTitulo());
            }
        }

    }



    public class Titular{
        private String titulo;

        public Titular(String dato1) {
            this.titulo=dato1;
        }

        public String getTitulo() {
            return titulo;
        }
    }
}
