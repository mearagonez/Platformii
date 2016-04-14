package nightware17.transform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button scale,rotation,fade,translate;
    TextView text;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scale=(Button)findViewById(R.id.btn_scale);
        rotation=(Button)findViewById(R.id.btn_rotate);
        fade=(Button)findViewById(R.id.btn_fade);
        translate=(Button)findViewById(R.id.btn_translate);

        text=(TextView)findViewById(R.id.lbl_a);

        scale.setOnClickListener(this);
        rotation.setOnClickListener(this);
        fade.setOnClickListener(this);
        translate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_scale:
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
                break;
            case R.id.btn_rotate:
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                break;
            case R.id.btn_fade:
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                break;
            case R.id.btn_translate:
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
                break;
            default:
                break;
        }
        text.startAnimation(animation);
    }
}
