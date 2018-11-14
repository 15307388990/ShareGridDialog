package com.eascs.share.callback;

/**
*
*  @Author luoming
*  @Date 2018/11/12 4:42 PM
*
*/

public interface ShareCallback {

    void onCancel(String name);

    void onComplete(String name);

    void onError(String name, Throwable throwable);


}
