package nightware17.randroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class Main2Activity extends AppCompatActivity {

    private GridView gridView;
    private AdaptadorDeimagenes adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gridView = (GridView) findViewById(R.id.grid);
        adaptador = new AdaptadorDeimagenes(this);
        gridView.setAdapter(adaptador);
    }
}
