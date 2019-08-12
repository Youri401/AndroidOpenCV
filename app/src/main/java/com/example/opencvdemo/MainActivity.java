package com.example.opencvdemo;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import org.opencv.android.OpenCVLoader;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_VIDEO_REQUEST = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!OpenCVLoader.initDebug()){
            Log.i("OpenCV","failed");
        }
        else{
            Log.i("OpenCV","successfull");
        }
        Button galleryButton = (Button)findViewById(R.id.gallery);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("video/*");
                startActivityForResult(i,PICK_VIDEO_REQUEST);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent resultData){
        if(resultData != null) {
            Log.i("intent_info", resultData.getData().toString());
            Log.i("intent_info", this.getApplicationContext().toString());
        }
        else{
            Log.i("intent_info", "null");
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode != KeyEvent.KEYCODE_BACK){
            return super.onKeyDown(keyCode,event);
        }else{
            return false;
        }
    }
}
