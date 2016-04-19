package nightware17.randomnumber;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText answer;
    private TextView wgames,type;
    private int wscore,win;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer=(EditText)findViewById(R.id.answer);
        wgames=(TextView)findViewById(R.id.wgame);
        type=(TextView)findViewById(R.id.lbl_type);

        random();
        board();
    }

    public void random(){
        wscore = 1 + (int) (Math.random() * ((50 - 1) + 1));
    }
    public int getWgame(){
        return wscore;
    }
    public void setWin(int win) {
        this.win = win;
    }
    public int getWin() {
        return win;
    }

    public void board(){
        SharedPreferences overwall_score=getSharedPreferences("score", Context.MODE_PRIVATE);
        setWin(overwall_score.getInt("wins",0));
        if(getWin()==0){
            saveScore(0);
        }
        wgames.setText("Win Games: "+getWin() );
    }

    public void saveScore(int number){
        SharedPreferences preferencias=getSharedPreferences("score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putInt("wins",number);
        editor.commit();
    }


    public void game(int user_answer){
        if(getWgame()==user_answer){
            random();
            setWin(getWin()+1);
            saveScore(getWin());

            wgames.setText("Win Games: "+getWin() );
            type.setText("Status:"+"\n"+"You Guess it :D");
            answer.setText("");
        }else{
            if(user_answer>getWgame()){
                type.setText("Status:"+"\n"+"The number is lower!");
            }else{
                type.setText("Status:"+"\n"+"The number is greater!");
            }
        }
    }

    public void check(View view){
        String num = answer.getText().toString();
        if (!num.equals("")) {
            int answer_n = Integer.parseInt(num);
            game(answer_n);
        }else{
            type.setText("Status:"+"\n"+"insert a number");
        }
    }
}
