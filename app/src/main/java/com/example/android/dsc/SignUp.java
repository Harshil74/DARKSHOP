package com.example.android.dsc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
        DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void onSignUpClick(View v){
        if(v.getId()== R.id.btnsignup2){
            EditText name = (EditText)findViewById(R.id.editname);
            EditText email = (EditText)findViewById(R.id.editemail);
            EditText mobile = (EditText)findViewById(R.id.editmono);
            EditText uname = (EditText)findViewById(R.id.signuname);
            EditText pass1 = (EditText)findViewById(R.id.editpass1);
            EditText pass2 = (EditText)findViewById(R.id.editpass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String mobilestr = mobile.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                Toast pass =Toast.makeText(SignUp.this,"Password don't match",Toast.LENGTH_SHORT);
                        pass.show();
            }
            else{
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setMobile(mobilestr);
                c.setPass(pass1str);
                helper.insertContact(c);

            }


        }
    }
}
