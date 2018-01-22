package com.example.android.dsc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
        DatabaseHelper helper = new DatabaseHelper(this);
    private char loginuname;
    private char loginpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final Button btn1 = (Button)findViewById(R.id.btnlogin);
        final Button btn2 = (Button)findViewById(R.id.btnsignup);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnlogin) {

                    EditText a = (EditText) findViewById(loginuname);
                    String str = a.getText().toString();
                    EditText b = (EditText) findViewById(loginpass);
                    String pass = b.getText().toString();

                    String password = helper.serachPass(str);
                    if (pass.equals(password)) {
                        Intent i = new Intent(LogIn.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast pass1 = Toast.makeText(LogIn.this, "Username and Passwrod don;t match", Toast.LENGTH_SHORT);
                        pass1.show();
                    }

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnsignup) {
                    Intent sign = new Intent(LogIn.this, SignUp.class);
                    startActivity(sign);
                }
            }
        });
    }
}

