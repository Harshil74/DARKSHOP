package com.example.android.dsc;
/**
 * Created by Harshil on 1/21/2018.
 */

public class Contact {

    String name,email,mobile,pass,uname;

    public void setUname(String uname){
        this.uname = uname;
    }
    public String getUname(){
        return this.uname;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return this.mobile;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public String getPass(){
        return this.pass;
    }
}
