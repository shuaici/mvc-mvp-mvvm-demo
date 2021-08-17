package com.scc.architecture.mvvm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.scc.architecture.R;
import com.scc.architecture.databinding.ActivityMvvmBinding;
import com.scc.architecture.mvvm.Callback;
import com.scc.architecture.mvvm.model.User;
import com.scc.architecture.mvvm.viewmodel.LoginViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MVVMLoginActivity extends AppCompatActivity {
    private LoginViewModel loginVM;
    ActivityMvvmBinding mvvmBinding;
    private EditText et_account,et_password;
    private Button btn_login,btn_back;
    private TextView tv_title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        et_account =findViewById(R.id.et_account);
        et_password =findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_back = findViewById(R.id.btn_back);
        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("MVVM");

        loginVM = new LoginViewModel(mvvmBinding);
        User user = new User( "scc001", "111111");
        mvvmBinding.setUser(user);//设置et_account：scc001|et_password：111111
        //第1步：用户点击登录
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(et_account.getText().toString(),et_password.getText().toString());
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void login(String name,String password) {
        loginVM.getUser(name,password, new Callback<User>() {
            @Override
            public void onCallBack(User user) {
                mvvmBinding.setUser(user);//同步设置控件
            }
        });
    }

}
