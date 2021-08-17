package com.scc.architecture.mvc.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.scc.architecture.databinding.ActivityMvcBinding;
import com.scc.architecture.mvc.model.User;

import androidx.appcompat.app.AppCompatActivity;

public class MVCLoginActivity extends AppCompatActivity {
    private ActivityMvcBinding mvcBinding;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvcBinding = ActivityMvcBinding.inflate(getLayoutInflater());
        setContentView(mvcBinding.getRoot());
        mvcBinding.mcvLogin.tvTitle.setText("MVC");
        user = new User();
        mvcBinding.mcvLogin.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(mvcBinding.mcvLogin.etAccount.getText().toString());
                user.setPassword(mvcBinding.mcvLogin.etPassword.getText().toString());
                login(user);
            }
        });
        mvcBinding.mcvLogin.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void login(User user){
        if(!user.getName().isEmpty()&&!user.getPassword().isEmpty()){
            if(user.getName().equals("scc001")&&user.getPassword().equals("111111"))
            {
                Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
        }
    }
}