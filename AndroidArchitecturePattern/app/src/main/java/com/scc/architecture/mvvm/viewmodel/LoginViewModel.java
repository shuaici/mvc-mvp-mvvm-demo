package com.scc.architecture.mvvm.viewmodel;

import com.scc.architecture.mvvm.Callback;
import com.scc.architecture.mvvm.model.User;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    public ViewDataBinding binding;
    public LoginViewModel(ViewDataBinding binding){
        this.binding = binding;
    }
    public void getUser(String userName, String password, Callback callback) {
        //逻辑处理
        User user = new User();
        user.setPassword("111111");
        if(userName.isEmpty()||!userName.equals("scc001")){
            user.setName("scc005");
        }else if(password.isEmpty()||!password.equals("111111")){
            user.setName("scc004");
        }else {
            user.setName("scc003");
        }
        callback.onCallBack(user);
    }
}
