package com.scc.architecture.mvvm.viewmodel;

import android.util.Log;

import com.scc.architecture.mvvm.model.User;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    public User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void loginResult() {
        if(user.getName().isEmpty()||!user.getName().equals("scc001")){
            user.setName("scc005");
        }else if(user.getPassword().isEmpty()||!user.getPassword().equals("111111")){
            user.setName("scc004");
        }else {
            user.setName("scc003");
        }
        user.setPassword("111111");
        Log.e("--SCC--","LoginViewModel:"+user.getName()+":"+user.getPassword());
    }
}
