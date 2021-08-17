package com.scc.architecture.mvp.model.impl;

import com.scc.architecture.mvp.model.LoginModel;
import com.scc.architecture.mvp.model.User;
import com.scc.architecture.mvp.presenter.OnLoginFinishedListener;
/**
  * 创建人：帅次
  * 创建时间：2021/8/16
  * 功能：实现Model层逻辑
  */
public class LoginModelImpl implements LoginModel {
    //第4步：验证帐号密码
    @Override
    public void login(User user, OnLoginFinishedListener listener) {
        if(user.getName().isEmpty()||!user.getName().equals("scc001")){
            //第5步：Model层里面回调Presenter层listener
            listener.onUserNameError();
        }else if(user.getPassword().isEmpty()||!user.getPassword().equals("111111")){
            //第5步：Model层里面回调Presenter层listener
            listener.onPasswordError();
        }else {
            //第5步：Model层里面回调Presenter层listener
            listener.onSuccess();
        }
    }
}
