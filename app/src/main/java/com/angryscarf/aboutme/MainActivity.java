package com.angryscarf.aboutme;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shareInfo(View v) {


        Uri pictureUri = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + R.drawable.picture_round);

        String message =
                getResources().getString(R.string.name) + "\n"+
                    ""+getResources().getString(R.string.major) + "\n"+
                    "Git: " + getResources().getString(R.string.txt_gitaccount) + "\n"+
                        "Facebook: " + getResources().getString(R.string.txt_facebookaccount) + "\n"+
                        "UCA: " + getResources().getString(R.string.txt_ucaId) + "\n"+
                        "Número: " + getResources().getString(R.string.txt_phonenumber);
        Intent i = new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.setType("image/*");

        i.putExtra(Intent.EXTRA_STREAM, pictureUri);
        i.putExtra(Intent.EXTRA_TEXT, message);

        if(i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }

    }
}
