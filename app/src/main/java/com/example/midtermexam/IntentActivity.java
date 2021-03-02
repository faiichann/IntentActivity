package com.example.midtermexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {
    ImageButton cameraBtn, photoBtn,dateBtn, youtubeBtn,mapBtn,googleBtn;
    Button next3Btn, backBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        next3Btn = (Button) findViewById(R.id.next3Btn);
        next3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0)
            {
                Intent touchintent = new Intent(IntentActivity.this,TouchActivity.class);
                startActivity(touchintent);
            }
        });
        backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnTouchListener(new View.OnTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    Toast.makeText(getApplicationContext(),"back Activity",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(IntentActivity.this,MainActivity.class);
                    startActivity(intent);
//                    Intent mainIntent = new Intent(IntentActivity.this,MainActivity.class);
//                    setResult(RESULT_OK,mainIntent );
//                    //---close activity ---
//                    finish();
                    return true;
                }
            });
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mainIntent = new Intent(view.getContext(),MainActivity.class);
//                setResult(RESULT_OK,mainIntent );
//                //---close activity ---
//                finish();
//            }
//        });

        cameraBtn = findViewById(R.id.cameraBtn);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        photoBtn = findViewById(R.id.photoBtn);
        photoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String packageName = "com.google.android.apps.photos";
                startApp(packageName);
            }
        });
        dateBtn = findViewById(R.id.dateBtn);
        dateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String packageName = "com.google.android.calendar";
                startApp(packageName);
            }
        });
        youtubeBtn = findViewById(R.id.youtubeBtn);
        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String packageName = "com.google.android.youtube";
                startApp(packageName);
            }
        });
        mapBtn = findViewById(R.id.mapBtn);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }
        });
        googleBtn = findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "http://www.google.com";
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
    public void startApp(String packageName) {
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(intent);
        } catch (NullPointerException e) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            startActivity(intent);
        }
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode== RESULT_CANCELED) {
//            setResult(resultCode);
//            finish();
//        }
//    }
}