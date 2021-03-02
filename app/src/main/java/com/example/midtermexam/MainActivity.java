package com.example.midtermexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    TextView textView,textView2,textView3;
    ImageButton imageButton,imageButton2,imageButton3;
    Button nextBtn, lastBtn;
    int n1=0;
    int n2=0;
    int n3=0;
    ConstraintLayout layout1;
    FrameLayout frame;
    private int request_code = 1;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton2 = (ImageButton)findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton)findViewById(R.id.imageButton3);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnTouchListener(new View.OnTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
//                    Intent intent = new Intent("com.example.midtermexam.INTENT");
//                    startActivityForResult(intent,request_code);
//                    Toast.makeText(getApplicationContext(),"Next Activity",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent("com.example.midtermexam.LOGIN");
//                    startActivityForResult(intent,request_code);
                    return true;
                }
            });
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
//        nextBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0)
//            {
//                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//                startActivity(intent);
//            }
////            public void onClick(View view) {
////                Toast.makeText(getApplicationContext(),"Next Activity",Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent("com.example.midtermexam.LOGIN");
////                startActivityForResult(intent,request_code);
//////                Intent intent = new Intent("com.example.midtermexam.INTENT");
//////                startActivityForResult(intent,request_code);
////            }
//        });
//        lastBtn = (Button) findViewById(R.id.lastBtn);
//        lastBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent touchIntent = new Intent("com.example.midtermexam.TOUCH");
//                startActivityForResult(touchIntent ,request_code);
//            }
//        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 += 1;
                textView.setText("Selected "+String.valueOf(n1)+" times");

            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n2 += 1;
                textView2.setText("Selected "+String.valueOf(n2)+" times");
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n3 += 1;
                textView3.setText("Selected "+String.valueOf(n3)+" times");
            }
        });

    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==request_code && resultCode==RESULT_OK) {
//            Toast.makeText(this,"Ok",Toast.LENGTH_SHORT).show();
//        }
//    }
}