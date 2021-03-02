package com.example.midtermexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editTextName , editTextPass ;
    Button loginBtn,next2Btn, backBtn;
    ImageView loginimageView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPass = (EditText)findViewById(R.id.editTextPass);
        loginimageView = (ImageView) findViewById(R.id.loginimageView);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                String[] name = {"User1", "User2", "User3"};
                String username  = editTextName.getText().toString();
                String[] password = {"1111", "2222", "3333"};
                String pass = editTextPass.getText().toString();
                if((username.equals(name[0]) && pass.equals(password[0])) || (username.equals(name[1]) && pass.equals(password[1]))
                        || (username.equals(name[2]) && pass.equals(password[2])))
                {
                    loginimageView.setImageResource(R.drawable.welcom);
                    Toast.makeText(LoginActivity.this, "Welcome :"+username, Toast.LENGTH_LONG).show();
                }
                else
                {
                    loginimageView.setImageResource(R.drawable.error);
                    Toast.makeText(LoginActivity.this, "Invalid Username or password.", Toast.LENGTH_LONG).show();
                }
            }
        });
//        backBtn = (Button) findViewById(R.id.backBtn);
//        backBtn.setOnTouchListener(new View.OnTouchListener() {
//            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
//                @Override
//                public boolean onDoubleTap(MotionEvent e) {
////                    Toast.makeText(getApplicationContext(),"Next Activity",Toast.LENGTH_SHORT).show();
//                    Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
//                    setResult(RESULT_OK,mainIntent );
//                    //---close activity ---
//                    finish();
//                    return true;
//                }
//            });
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                gestureDetector.onTouchEvent(motionEvent);
//                return false;
//            }
//        });
        next2Btn = (Button) findViewById(R.id.next2Btn);
        next2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0)
            {
                Intent intent = new Intent(LoginActivity.this,IntentActivity.class);
                startActivity(intent);
            }
//            public void onClick(View view) {
//                Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
//                setResult(RESULT_OK,mainIntent );
//                //---close activity ---
//                finish();
////                Intent loginIntent =  new Intent("com.example.midtermexam.INTENT");
//////                loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//////                loginIntent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
////                startActivity(loginIntent);
//            }
        });
//        next2Btn.setOnTouchListener(new View.OnTouchListener() {
//            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
//                @Override
//                public boolean onDoubleTap(MotionEvent e) {
//                    Intent loginIntent =  new Intent("com.example.midtermexam.INTENT");
//                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
//                    startActivity(loginIntent);
//                    return true;
//                }
//            });
//            @SuppressLint("ClickableViewAccessibility")
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                gestureDetector.onTouchEvent(motionEvent);
//                return false;
//            }
//        });

//        backBtn = (Button) findViewById(R.id.backBtn);
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mainIntent = new Intent(view.getContext(),MainActivity.class);
//                setResult(RESULT_OK,mainIntent );
//                //---close activity ---
//                finish();
//            }
//        });
    }
}