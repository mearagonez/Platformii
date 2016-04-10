package nightware17.graphpixel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layout1=(RelativeLayout)findViewById(R.id.layout1);
        Lienzo fondo=new Lienzo(this);
        layout1.addView(fondo);
    }


    class Lienzo extends View{

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas){
            int ancho=canvas.getWidth();
            int alto=canvas.getHeight();

            Paint pincel=new Paint();
            pincel.setARGB(255,255,0,0);
           // canvas.drawPoint(ancho/2,alto/2,pincel);
            canvas.drawLine(0,30,ancho,30,pincel);
            pincel.setStrokeWidth(4);
            canvas.drawLine(0,60,ancho,60,pincel);
        }

    }
}
