package nightware17.losign;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText nombre,email,pass,rpass;
    String t="";
    Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        nombre=(EditText)findViewById(R.id.txt_name);
        email=(EditText)findViewById(R.id.txt_email);
        pass=(EditText)findViewById(R.id.txt_pass);
        rpass=(EditText)findViewById(R.id.txt_rpass);
        extras = getIntent().getExtras();
        t = extras.getString("tipo");
        SharedPreferences prefe=getSharedPreferences("register", Context.MODE_PRIVATE);

        Button btnlog=(Button)findViewById(R.id.btn_log);
        if(t.equals("editar")){
            btnlog.setVisibility(View.INVISIBLE);
            nombre.setText(prefe.getString("name",""));
            email.setText(prefe.getString("email",""));
            pass.setText(prefe.getString("pass",""));
        }

    }

    public void goLogin(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void save(View view){
        if(pass.getText().toString().equals(rpass.getText().toString())) {
            SharedPreferences preferences = getSharedPreferences("register", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("name", nombre.getText().toString());
            editor.putString("email", email.getText().toString());
            editor.putString("pass", pass.getText().toString());
            editor.commit();

            Intent i = new Intent(this, home.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this,"Password don't match",Toast.LENGTH_SHORT).show();
        }
    }
}
