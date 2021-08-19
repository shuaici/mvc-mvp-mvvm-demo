package com.scc.architecture.mvvm.model;

import com.scc.architecture.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
  * 创建人：帅次
  * 创建时间：2021/8/16
  * 功能：实体类bean
  */
public class User extends BaseObservable{
    private String name;
    private String password;
    public User() {
    }
    //BR 的域则是通过在 get 方法上加 @Bindable 生成的
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //刷新UI
        //BR 的域则是通过在 get 方法上加 @Bindable 生成的
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        //刷新UI
        notifyPropertyChanged(BR.password);
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
