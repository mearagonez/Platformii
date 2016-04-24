package nightware17.losign;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText s_email,s_pass;
    private String Mail="",Pass="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s_email=(EditText)findViewById(R.id.txt_cemail);
        s_pass=(EditText)findViewById(R.id.txt_cpassword);
        SharedPreferences prefe=getSharedPreferences("register", Context.MODE_PRIVATE);
        Mail=prefe.getString("email","");
        Pass=prefe.getString("pass","");
    }

    public void goRegister(View view){
        Intent i = new Intent(this, register.class);
        i.putExtra("tipo","registrar");
        startActivity(i);
        finish();
    }

    public void goHome(View view){
        String u_email=s_email.getText().toString();
        String u_pass=s_pass.getText().toString();
        if(u_email.equals(Mail)&&u_pass.equals(Pass)){

            Intent i = new Intent(this, home.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this,"User or Pass incorrect. Try Again",Toast.LENGTH_SHORT).show();
        }
    }
}
