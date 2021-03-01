package com.example.midtermexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUser , editTextPass ;
    Button loginBtn;
    ImageView imageViewLogiin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUser = findViewById(R.id.editTextUser);
        editTextPass = findViewById(R.id.editTextPass);
        imageViewLogiin = findViewById(R.id.imageViewLogin);
        loginBtn = findViewById(R.id.nextBtn);
        loginBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                String[] name = {"User1", "User2", "User3"};
                String username  = editTextUser.getText().toString();
                String[] password = {"1111", "2222", "3333"};
                String pass = editTextPass.getText().toString();
                if(username.equals(name) && pass.equals(pass))
                {
                    imageViewLogiin = findViewById(R.id.imageViewLogin);
                    Intent intent = new Intent(LoginActivity.this,IntentActivity.class);
                    intent.putExtra("username",editTextUser.getText().toString());
                    Toast.makeText(LoginActivity.this, "Welcome :"+getIntent().getExtras().getString("username"), Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                else
                {
                    imageViewLogiin.setImageResource(R.drawable.g);
                    Toast.makeText(LoginActivity.this, "Invalid Username or password.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}