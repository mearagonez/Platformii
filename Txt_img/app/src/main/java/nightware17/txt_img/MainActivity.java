package nightware17.txt_img;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lbl_text;
    EditText txtnumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img =(ImageView)findViewById(R.id.ImgFoto);
        img.setImageResource(R.mipmap.ic_launcher);
        lbl_text=(TextView)findViewById(R.id.lbl_Etiqueta);
        txtnumero=(EditText)findViewById(R.id.txtImgeHint);
        String texto=lbl_text.getText().toString();
        texto+="123";
        lbl_text.setText(texto);
        lbl_text.setBackgroundColor(Color.BLUE);

    }

    public void calcular(View view){
        int numero=Integer.parseInt(txtnumero.getText().toString());
        lbl_text.setText(pareimpar(numero));
    }
    private String pareimpar(int number){
        String result="";
        if(number%2 != 0){
            result="Es un numero impar!!";
        }else{
            result="Es un numero par!!";
        }
    return result;
    }
}
