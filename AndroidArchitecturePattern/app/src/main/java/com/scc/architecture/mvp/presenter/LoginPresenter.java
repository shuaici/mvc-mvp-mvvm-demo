package com.scc.architecture.mvp.presenter;

import com.scc.architecture.mvp.model.User;

/**
  * 创建人：帅次
  * 创建时间：2021/8/16
  * 功能：登录的Presenter的接口，实现类为LoginPresenterImpl，
  * 完成登录的验证，以及销毁当前View。
  */
public interface LoginPresenter {
    //完成登录的验证
    void verifyData(User user);
    //销毁当前View
    void onDestroy();
}
