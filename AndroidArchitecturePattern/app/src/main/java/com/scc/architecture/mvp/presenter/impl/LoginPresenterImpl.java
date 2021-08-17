package com.scc.architecture.mvp.presenter.impl;

import com.scc.architecture.mvp.model.LoginModel;
import com.scc.architecture.mvp.model.User;
import com.scc.architecture.mvp.model.impl.LoginModelImpl;
import com.scc.architecture.mvp.presenter.LoginPresenter;
import com.scc.architecture.mvp.presenter.OnLoginFinishedListener;
import com.scc.architecture.mvp.view.LoginView;
/**
  * 创建人：帅次
  * 创建时间：2021/8/17
  * 功能：实现类，引入 LoginModel(model)和LoginView(view)的引用
  */
public class LoginPresenterImpl implements OnLoginFinishedListener, LoginPresenter {
    //View层接口
    private LoginView loginView;
    //Model层接口
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }
    //第6步：通过OnLoginFinishedListener验证结果回传到Presenter层
    @Override
    public void onUserNameError() {
        if (loginView != null) {
            //第7步：通过loginView回传到View层
            loginView.setUserNameError();
            loginView.hideProgress();
        }

    }
    //第6步：通过OnLoginFinishedListener验证结果回传到Presenter层
    @Override
    public void onPasswordError() {
        if (loginView != null) {
            //第7步：通过loginView回传到View层
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }
    //第6步：通过OnLoginFinishedListener验证结果回传到Presenter层
    @Override
    public void onSuccess() {
        if (loginView != null) {
            //第7步：通过loginView回传到View层
            loginView.success();
            loginView.hideProgress();
        }
    }


    @Override
    public void verifyData(User user) {
        if (loginView != null) {
            loginView.showProgress();
        }
        //第3步：调用model层LoginModel接口的login()方法
        loginModel.login(user,this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }
}
