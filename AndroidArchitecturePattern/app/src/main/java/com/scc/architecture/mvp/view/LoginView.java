package com.scc.architecture.mvp.view;
/**
  * 创建人：帅次
  * 创建时间：2021/8/16
  * 功能：Presenter与View交互是通过接口。
  * 接口中方法的定义是根据Activity用户交互需要展示的控件确定的。
  */
public interface LoginView {
    //login是个耗时操作,加载中(一般用ProgressBar)
    void showProgress();
    //加载完成
    void hideProgress();
    //login账号失败给出提示
    void setUserNameError();
    //login密码失败给出提示
    void setPasswordError();
    //login成功
    void success();
}
