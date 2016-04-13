package nightware17.claudio;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageButton cat,lion;
    MediaPlayer cat_s,lion_s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cat=(ImageButton)findViewById(R.id.btn_cat);
        lion=(ImageButton)findViewById(R.id.btn_lion);

        cat_s= MediaPlayer.create(this,R.raw.cat);
        lion_s=MediaPlayer.create(this,R.raw.lion);


        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cat_s.start();
            }
        });

        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lion_s.start();
            }
        });
    }
}
