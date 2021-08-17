package com.scc.architecture.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.scc.architecture.databinding.ActivityMvpBinding;
import com.scc.architecture.mvp.model.User;
import com.scc.architecture.mvp.presenter.impl.LoginPresenterImpl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/**
  * 创建人：帅次
  * 创建时间：2021/8/16
  * 功能：需要实现LoginView接口。
  */
public class MVPLoginActivity extends AppCompatActivity implements LoginView {
    ActivityMvpBinding mvpBinding;
    LoginPresenterImpl loginPresenterImpl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpBinding = ActivityMvpBinding.inflate(getLayoutInflater());
        setContentView(mvpBinding.getRoot());
        mvpBinding.mvpLogin.tvTitle.setText("MVP");
        //创建一个Presenter对象
        loginPresenterImpl = new LoginPresenterImpl(MVPLoginActivity.this);
        //第1步：用户点击登录
        mvpBinding.mvpLogin.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setName(mvpBinding.mvpLogin.etAccount.getText().toString());
                user.setPassword(mvpBinding.mvpLogin.etPassword.getText().toString());
                //第2步：调用Presenter接口中的验证方法
                loginPresenterImpl.verifyData(user);
            }
        });
        mvpBinding.mvpLogin.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showProgress() {
        //加载中
    }

    @Override
    public void hideProgress() {
        //加载完成
    }

    @Override
    public void setUserNameError() {
        //第7步：通过loginView回传到View层
        //账号错误
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        //第7步：通过loginView回传到View层
        //密码错误
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        //第7步：通过loginView回传到View层
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        //登录成功
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenterImpl.onDestroy();
    }
}
