package com.example.midtermexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TouchActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton imageButton1, imageButton2, imageButton3, imageButton4;
    ConstraintLayout layout;
    Button backBtn;
    private float x;
    private float y;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);

        backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });

        layout = (ConstraintLayout)findViewById(R.id.layout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                x = motionEvent.getX();
                y = motionEvent.getY();

                float bx1 = imageButton1.getX();
                float by1 = imageButton1.getY();

                float bx2 = imageButton2.getX();
                float by2 = imageButton2.getY();

                float bx3 = imageButton3.getX();
                float by3 = imageButton3.getY();

                float bx4 = imageButton4.getX();
                float by4 = imageButton4.getY();

                float dt1 = (float) Math.sqrt(Math.pow((bx1-x),2)+ Math.pow((by1-y),2));
                float dt2 = (float) Math.sqrt(Math.pow((bx2-x),2)+ Math.pow((by2-y),2));
                float dt3 = (float) Math.sqrt(Math.pow((bx3-x),2)+ Math.pow((by3-y),2));
                float dt4 = (float) Math.sqrt(Math.pow((bx4-x),2)+ Math.pow((by4-y),2));

                float[] dtAll = {dt1,dt2,dt3,dt4};
                float min = getMin(dtAll);

                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                    if (min == dt1){
                        imageButton1.setX(x);
                        imageButton1.setY(y);
                    }
                    else if (min == dt2){
                        imageButton2.setX(x);
                        imageButton2.setY(y);
                    }
                    else if (min == dt3){
                        imageButton3.setX(x);
                        imageButton3.setY(y);
                    }
                    else if (min == dt4){
                        imageButton4.setX(x);
                        imageButton4.setY(y);
                    }
                }
                return true;
            }
            private float getMin(float[] dtAll){
                float minValue = dtAll[0];
                for(float i=1;i<dtAll.length;i++){
                    if(dtAll[(int) i] < minValue){
                        minValue = dtAll[(int) i];
                    }
                }
                return minValue;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton1:
                Toast.makeText(this,"Button 1 cilcked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton2:
                Toast.makeText(this,"Button 2 cilcked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton3:
                Toast.makeText(this,"Button 3 cilcked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton4:
                Toast.makeText(this,"Button 4 cilcked",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}