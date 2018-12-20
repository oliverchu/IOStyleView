package top.iofox.app.iostyleview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.math.MathUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

import top.iofox.app.iostyleview.R;

/**
 * Created by [Oliver Chu] on 2018/12/20 9:14
 */
public class ActivityIndicatorView extends View {

    private Rect rect;
    private Paint paint;
    private int indicatorColor ;
    private int indicatorShape ;
    private int delayMillis;
    public static final int INDICATOR_SHAPE_ROUND = 0;
    public static final int INDICATOR_SHAPE_SQUARE = 1;
    public static final int INDICATOR_SHAPE_BUTT = 2;
    private static final int DEFAULT_DELAY = 50;

    public ActivityIndicatorView(Context context) {
        this(context,null);
    }

    public ActivityIndicatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ActivityIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context,attrs);
    }

    public void setIndicatorColor(int color) {
        this.indicatorColor = color;
        paint.setColor(color);
    }

    public void setDelayMillis(int delayMillis) {
        this.delayMillis = delayMillis;
    }

    public void setIndicatorShape(int indicatorShape) {
        this.indicatorShape = indicatorShape;
        if(indicatorShape == 1){
            paint.setStrokeCap(Paint.Cap.SQUARE);
        }else if(indicatorShape == 2){
            paint.setStrokeCap(Paint.Cap.BUTT);
        }else {
            paint.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    private void setup(Context context, AttributeSet attrs){
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ActivityIndicatorView);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rect = new Rect();
        setIndicatorColor(array.getColor(R.styleable.ActivityIndicatorView_indicatorColor,Color.rgb(106,113,125)));
        setIndicatorShape(array.getInt(R.styleable.ActivityIndicatorView_indicatorShape,INDICATOR_SHAPE_ROUND));
        setDelayMillis(array.getInt(R.styleable.ActivityIndicatorView_delayMillis,DEFAULT_DELAY));
        array.recycle();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    startAlpha -= 21;
                    if(startAlpha == 3){
                        startAlpha = 255;
                    }
                    postInvalidate();
                    try {
                        Thread.sleep(delayMillis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }


    @Override
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        layoutParams.height = layoutParams.width;
        return layoutParams;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int centerX = (int) ((left+right)/2f);
        paint.setStrokeWidth(getWidth()/10f);
        rect.set((int) (centerX-paint.getStrokeWidth()/2f), (int) (top + paint.getStrokeWidth()/2f), (int) (centerX+paint.getStrokeWidth()/2f), (int) (bottom/2f-paint.getStrokeWidth()));
    }

    private int startAlpha =  255;

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setAlpha(startAlpha);
        for (int i = 0; i < 12;i++) {
            canvas.drawLine(rect.centerX(),rect.top,rect.centerX(),rect.centerY(),paint);
            canvas.save();
            int alpha = paint.getAlpha() - 21;
            if(alpha==3){
                alpha = 255;
            }
            paint.setAlpha(alpha);
            canvas.rotate(30,rect.centerX(),rect.centerX());
        }
        super.onDraw(canvas);
    }


}
