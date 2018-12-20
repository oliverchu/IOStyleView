package top.iofox.app.iostyleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by [Oliver Chu] on 2018/12/20 9:25
 */
public class Slider extends View {
    public Slider(Context context) {
        this(context,null);
    }

    public Slider(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Slider(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context, attrs);
    }

    private void setup(Context context, AttributeSet attrs){

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
    }
}
