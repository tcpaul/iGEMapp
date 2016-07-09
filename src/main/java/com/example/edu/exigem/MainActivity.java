package com.example.edu.exigem;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.view.CollapsibleActionView;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.penta);
        textView = (TextView) findViewById(R.id.pent);

        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache(true);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                bitmap = imageView.getDrawingCache();
                int topPixel = bitmap.getPixel(222, 164);
                int rightPixel = bitmap.getPixel(88, 297);
                int midPixel = bitmap.getPixel(214, 305);
                int leftPixel = bitmap.getPixel(356, 291);
                int botPixel = bitmap.getPixel(212, 431);
/*
                int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b = Color.blue(pixel);
*/
                textView.setText("pixels are:"+topPixel+"\n:"+leftPixel+"\n:"+midPixel+"\n:"+rightPixel+"\n:"+botPixel+"\n:");

                /*//HOW to find specific pixels by touching
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                    bitmap = imageView.getDrawingCache();
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pixel = bitmap.getPixel(x, y);
//todo instead of getx gety we predetermine these values then average them and make a pixel seed
                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    //textView.setBackgroundColor(Color.rgb(r,g,b));
                    textView.setText("R("+r+")\n"+"G("+g+")\n"+"B("+b+")\n\n"+"pixel is:"+pixel+"\nx:"+x+"\ny:"+y);
                */
                //}//
            return true;
        }

        });
    }

}
