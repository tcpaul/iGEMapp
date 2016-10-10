package com.example.edu.exigem;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;
import java.io.File;
import android.os.Environment;

public class MainActivity extends AppCompatActivity {

    private ImageButton roundcamerabutton;
    private ImageView showpicture;
    public Uri pictureuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roundcamerabutton = (ImageButton) findViewById(R.id.button_image);
        showpicture = (ImageView) findViewById(R.id.picture);


        /* Tilgang til kamera og lagring */
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            roundcamerabutton.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }
        else{
            roundcamerabutton.setEnabled(true);
        }

    }

    /* oppretter mappe og returnerer bildene i mappen */
    private static File makefolderandreturnpicture(){
        File folder = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "phoneLab");

        return new File(folder.getPath() + File.separator + ".jpg");
    }

    /* tar bilde og lager uri */
    public void takepicture(View view) {
        Intent opencamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        pictureuri = Uri.fromFile(makefolderandreturnpicture());
        opencamera.putExtra(MediaStore.EXTRA_OUTPUT, pictureuri);
        startActivityForResult(opencamera, 100);
    }

    /* viser bilde*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        View a = findViewById(R.id.info);
        a.setVisibility(View.GONE);
        View b = findViewById(R.id.button_image);
        b.setVisibility(View.GONE);
        View c = findViewById(R.id.text);
        c.setVisibility(View.GONE);

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                showpicture.setImageURI(pictureuri);
            }
        }
    }

    public void info(View view2) {
        Intent infopage = new Intent(this, FullscreenActivity.class);
        startActivity(infopage);
    }
}
