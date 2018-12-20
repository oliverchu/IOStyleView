package top.iofox.app.iostyleview;

import android.graphics.Color;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;

import java.util.Arrays;

import top.iofox.app.iostyleview.view.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,MyFragment.newInstance()).commit();
//        android.widget.Button btnColor = findViewById(R.id.btnColor);
//        Drawable background =
//                btnColor.getBackground();
//        Log.d(TAG, "onCreate: "+ Arrays.toString(background.getState()));
//        PaintDrawable paintDrawable = new PaintDrawable(Color.RED);
//        paintDrawable.setCornerRadius(10);
//        btnColor.setBackgroundDrawable(paintDrawable);
    }
}
