package nightware17.semail;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private TextView last_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.editText);
        last_email=(TextView)findViewById(R.id.textView2);

        SharedPreferences saved_email=getSharedPreferences("datos", Context.MODE_PRIVATE);
        last_email.setText("Last email saved: "+saved_email.getString("mail",""));
    }

    public void Save(View view){
        SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("mail", email.getText().toString());
        editor.commit();
        finish();
    }
}
