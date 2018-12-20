package top.iofox.app.iostyleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by [Oliver Chu] on 2018/12/20 15:15
 */
public class Button extends View {
    private static final String TAG = "Button";
    public Button(Context context) {
        this(context,null);
    }

    public Button(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Button(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context,attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        rect.set(left,top,right,bottom);
        Log.d(TAG, "onLayout: "+rect.toString());
        invalidate();
    }

    private Paint pBg,pText;
    private RectF rect;
    private void setup(Context context, AttributeSet attrs){
        rect = new RectF();
        pBg = new Paint(Paint.ANTI_ALIAS_FLAG);
        pBg.setColor(Color.BLUE);
        pBg.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(rect,0,0,pBg);
        super.onDraw(canvas);
    }
}
