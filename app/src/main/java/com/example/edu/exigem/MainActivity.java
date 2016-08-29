package com.example.edu.exigem;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.view.CollapsibleActionView;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
/*
    private ImageView imageView;
    private TextView textView;
    private Bitmap bitmap;

*/
   // public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void doTest(View view2) {
        Intent intent = new Intent(this, DisplayTest.class);
       // EditText editText = (EditText) findViewById(R.id.edit_message);
       // String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        // Do something in response to button
    }
    public void info(View view2) {

        Intent intent = new Intent(this, FullscreenActivity.class);

        startActivity(intent);

    }
}
