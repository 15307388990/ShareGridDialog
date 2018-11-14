package com.eascs.share.callback;

import android.view.View;

import com.eascs.share.dialog.ShareItemVM;

/**
 * @Author luoming
 * @Date 2018/11/9 5:41 PM
 */
public interface IShareListener {
    void onItemClick(View view, int position, ShareItemVM shareItemVM);

    void shareToSina(ShareItemVM shareItemVM);

    void shareToQQ(ShareItemVM shareItemVM);

    void shareToQZone(ShareItemVM shareItemVM);

    void shareToWechat(ShareItemVM shareItemVM);

    void shareToWechatMoments(ShareItemVM shareItemVM);

}
