package com.scc.architecture.mvp.presenter;
/**
  * 创建人：帅次
  * 创建时间：2021/8/16
  * 功能：当Model层得到请求的结果，回调Presenter层，让Presenter层调用View层的接口方法。
  */
public interface OnLoginFinishedListener {
    void onUserNameError();

    void onPasswordError();

    void onSuccess();
}
