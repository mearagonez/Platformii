package nightware17.basicop;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2,data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.txt_num1);
        num2 = (EditText) findViewById(R.id.txt_num2);
        data = (EditText) findViewById(R.id.txt_data);

        load();


    }

    public void add(View view) {
        op(1);
        load();
    }

    public void sub(View view) {
        op(2);
        load();
    }

    public void mul(View view) {
        op(3);
        load();
    }

    public void div(View view) {
        op(4);
        load();
    }

    private void op(int op) {
        String num = num1.getText().toString();
        String numt = num2.getText().toString();
        if (!num.equals("") && !numt.equals("")) {
            int answer_n = Integer.parseInt(num);
            int answer_nt = Integer.parseInt(numt);
            String result;
            switch (op) {
                case 1:
                    result = add(answer_n, answer_nt);
                    Toast.makeText(this, "ADD : " + result, Toast.LENGTH_SHORT).show();
                    save(answer_n + " + " + answer_nt + " = " + result);
                    break;
                case 2:
                    result = sub(answer_n, answer_nt);
                    Toast.makeText(this, "SUB : " + result, Toast.LENGTH_SHORT).show();
                    save(answer_n + " - " + answer_nt + " = " + result);
                    break;
                case 3:
                    result = mul(answer_n, answer_nt);
                    Toast.makeText(this, "MUL : " + result, Toast.LENGTH_SHORT).show();
                    save(answer_n + " * " + answer_nt + " = " + result);
                    break;
                case 4:
                    result = div(answer_n, answer_nt);
                    Toast.makeText(this, "DIV : " + result, Toast.LENGTH_SHORT).show();
                    save(answer_n + " / " + answer_nt + " = " + result);
                    break;
                default:
                    break;
            }
        } else {
            Toast.makeText(this, "Ingrese algun numero ", Toast.LENGTH_SHORT).show();
        }
    }

    private String add(int num1, int num2) {
        int add = num1 + num2;
        String result = "" + add;
        return result;
    }

    private String sub(int num1, int num2) {
        int sub = num1 - num2;
        String result = "" + sub;
        return result;
    }

    private String mul(int num1, int num2) {
        int mul = num1 * num2;
        String result = "" + mul;
        return result;
    }

    private String div(int num1, int num2) {
        if (num2 != 0) {
            float div = num1 / num2;
            String result = "" + div;
            return result;
        } else {
            return "Cannot Divide by zero";
        }
    }

    private void load(){
        String nomarchivo="basic_op.txt";
        nomarchivo=nomarchivo.replace('/','-');
        boolean enco = false;
        String[] archivos = fileList();
        for(int f = 0;f<archivos.length;f++)
            if(nomarchivo.equals(archivos[f]))
                enco=true;
        if(enco==true){
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput(nomarchivo));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
               data.setText(todo);
            } catch (IOException e) {
            }
        }else  {

        }
    }

    private void save(String data_1){
        String nomarchivo="basic_op.txt";
        nomarchivo=nomarchivo.replace('/','-');
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    nomarchivo, Activity.MODE_PRIVATE));
            archivo.write(data.getText().toString()+"\n"+data_1);
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }

    }


}
