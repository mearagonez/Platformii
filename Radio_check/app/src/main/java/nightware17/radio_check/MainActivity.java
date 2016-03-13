package nightware17.radio_check;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg;
    CheckBox chkD1,chkD2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=(RadioGroup)findViewById(R.id.radio);
        chkD1=(CheckBox)findViewById(R.id.chb1);
        chkD2=(CheckBox)findViewById(R.id.chb2);
        btn1=(Button)findViewById(R.id.btn1);

        btn1.setOnClickListener(this);
    }

    public void Calcular(){
        int pre=0;
        String cur="";
        switch(rg.getCheckedRadioButtonId()){
            case R.id.rb1:
                pre=900;
                cur="Matematicas";
                break;
            case R.id.rb2:
                pre=700;
                cur="Geografia";
                break;
            case R.id.rb3:
                pre=850;
                cur="Historia";
                break;
        }
        descuento(pre,cur);
    }

    private void descuento(int price, String curse){
        double total,D1=0,D2=0;

        if(chkD1.isChecked()){
            D1=price*0.05;
        }if(chkD2.isChecked()){
            D2=price*0.10;
        }
        total=price-D1-D2;
        Toast.makeText(getApplicationContext(),"Curso: "+ curse
                +"\n"+"Precio: "+price
                +"\n"+"Descuento1: "+D1
                +"\n"+"Descuento2: "+D2
                +"\n"+"total: "+total
                , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn1) {
            Calcular();
        }
    }
}
