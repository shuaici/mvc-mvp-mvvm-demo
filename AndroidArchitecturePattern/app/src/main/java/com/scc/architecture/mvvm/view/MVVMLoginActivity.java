package com.scc.architecture.mvvm.view;

import android.os.Bundle;
import android.view.View;

import com.scc.architecture.R;
import com.scc.architecture.databinding.ActivityMvvmBinding;
import com.scc.architecture.mvvm.model.User;
import com.scc.architecture.mvvm.viewmodel.LoginViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MVVMLoginActivity extends AppCompatActivity {
    private LoginViewModel loginVM;
    ActivityMvvmBinding mvvmBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //返回activity_mvvm的实体对象
        mvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        mvvmBinding.setLifecycleOwner(this);
        loginVM = new LoginViewModel();
        //创建数据源
        User user = new User( "scc001", "111111");
        //将数据源交给DataBinding
        loginVM.setUser(user);
        //设置et_account：scc001|et_password：111111
        mvvmBinding.setLoginViewModel(loginVM);
    }
    public void login(View view){
        loginVM.loginResult();
    }
    public void back(View view){
        finish();
    }
}
