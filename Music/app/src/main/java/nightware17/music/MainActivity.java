package nightware17.music;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer song;
    int position =0;
    CheckBox check;
    ImageButton start,pause,play,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check=(CheckBox)findViewById(R.id.check_music);
        start=(ImageButton)findViewById(R.id.imageButton);
        pause=(ImageButton)findViewById(R.id.imageButton1);
        play=(ImageButton)findViewById(R.id.imageButton2);
        stop=(ImageButton)findViewById(R.id.imageButton3);

        Enable(false);

    }
    public void Enable(boolean a){
        pause.setEnabled(a);
        play.setEnabled(a);
        stop.setEnabled(a);
    }

    public void destroy(){
        if(song!=null){
            song.release();
        }
    }

    public void init(View view){
        destroy();
        if(check.isChecked()){
            song=MediaPlayer.create(this,R.raw.himno);
            song.start();

            Enable(true);

            start.setEnabled(false);
        }else{
            Toast.makeText(this,"Please check play Music",Toast.LENGTH_SHORT).show();
        }

    }

    public void pause(View view){
        if (check.isChecked()) {
            if (song != null && song.isPlaying()) {
                position = song.getCurrentPosition();
                song.pause();
            }
        }else{
            Toast.makeText(this,"Please check play Music",Toast.LENGTH_SHORT).show();
        }
    }

    public void play(View view) {
        if (check.isChecked()) {
            if (song != null && song.isPlaying() == false) {
                song.seekTo(position);
                song.start();
            }
        }else{
            Toast.makeText(this,"Please check play Music",Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View view) {
        if (check.isChecked()) {
            if (song != null) {
                song.stop();
                position = 0;
                Enable(false);
                start.setEnabled(true);
            }
        }else{
            Toast.makeText(this,"Please check play Music",Toast.LENGTH_SHORT).show();
        }
    }
}
