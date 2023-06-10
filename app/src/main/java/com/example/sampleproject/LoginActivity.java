package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    TextView signInTxtVw, fgtPassTxtVw;
    EditText user,pass;
    Button loginBtn;
    private static final String USER = "OrangeToolz";
    private static final String PASS = "786786";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }

        //initializing all buttons
        initializeAllButtons();

        //authentication part(Dummy)
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticate();
            }
        });




    }

    private void authenticate() {
        String userName = user.getText().toString();
        String passWord = pass.getText().toString();
        if(userName.equals(USER) && passWord.equals(PASS)){
            Toast.makeText(this, "Welcome to the Activity", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(this, "Wrong Password!!", Toast.LENGTH_SHORT).show();
        }

    }

    private void initializeAllButtons() {
//        signInTxtVw = findViewById(R.id.signin);
        fgtPassTxtVw = findViewById(R.id.forgotpass);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginbtn);

    }
}