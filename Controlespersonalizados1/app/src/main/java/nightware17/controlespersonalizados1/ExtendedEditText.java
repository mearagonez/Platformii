package nightware17.controlespersonalizados1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by drm_6 on 2016-03-03.
 */
public class ExtendedEditText extends EditText {

    private Paint p1;
    private Paint p2;
    private float escala;
    public ExtendedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializacion();
    }

    public ExtendedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializacion();
    }

    public ExtendedEditText(Context context) {
        super(context);
        inicializacion();
    }


    private void inicializacion(){
        p1=new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.BLACK);
        p1.setStyle(Paint.Style.FILL);

        p2=new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.WHITE);

        escala=getResources().getDisplayMetrics().density;

    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawRect(this.getWidth()-30*escala,
                5*escala,
                this.getWidth()-5*escala,
                20*escala,p1);
        canvas.drawText(""+this.getText().toString().length(),
                this.getWidth()-28*escala,
                17*escala,p2);
    }
}
