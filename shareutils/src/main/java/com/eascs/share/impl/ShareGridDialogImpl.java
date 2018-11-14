package com.eascs.share.impl;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.eascs.share.callback.IShareListener;
import com.eascs.share.callback.ShareCallback;
import com.eascs.share.dialog.ShareItemVM;
import com.eascs.shareutils.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;


public class ShareGridDialogImpl implements IShareListener {

    public ShareCallback shareCallback;
    private Activity activity;
    private ShareImpl shareimpl;

    public ShareGridDialogImpl(Activity activity, ShareCallback shareCallback) {
        this.shareCallback = shareCallback;
        this.activity = activity;
        shareimpl = new ShareImpl();

    }

    public ShareGridDialogImpl(Activity activity) {
        this.activity = activity;
        shareimpl = new ShareImpl();

    }


    @Override
    public void onItemClick(View view, int position, ShareItemVM shareItemVM) {
        if (TextUtils.isEmpty(shareItemVM.getTitle()) || shareItemVM.equals("null") || shareItemVM.getShareEnum() == null) {
            return;

        }
        switch (shareItemVM.getShareEnum()) {
            case QQ:
                shareToQQ(shareItemVM);
                break;
            case KONGJIAN:
                shareToQZone(shareItemVM);
                break;
            case WEIXIN:
                shareToWechat(shareItemVM);
                break;
            case PENGYOUQUAN:
                shareToWechatMoments(shareItemVM);
                break;
            case WEIBO:
                shareToSina(shareItemVM);
                break;
            default:
                Toast.makeText(activity, "没有添加该Item 点击", Toast.LENGTH_LONG).show();
                break;
        }
    }


    @Override
    public void shareToSina(ShareItemVM shareItemVM) {
        Platform sina = ShareSDK.getPlatform(SinaWeibo.NAME);
        SinaWeibo.ShareParams sp = new SinaWeibo.ShareParams();
        String title = shareItemVM.getSharetitle();
        String text = shareItemVM.getSharetext();
        String imgUrl = shareItemVM.getShareimgurl();
        sp.setTitle(title);
        sp.setText(title + "\n" + text + "\n" + shareItemVM.getShareurl());
        Bitmap bmp;
        if (TextUtils.isEmpty(imgUrl)) {
            if (shareItemVM.getDefaultshareimgurl() == -1) {
                bmp = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.logo);

            } else {
                bmp = BitmapFactory.decodeResource(activity.getResources(), shareItemVM.getDefaultshareimgurl());
            }
            sp.setImageData(bmp);
        } else {
            sp.setImageUrl(imgUrl);
        }
        sina.setPlatformActionListener(shareimpl);
        sina.share(sp);
    }

    @Override
    public void shareToQQ(ShareItemVM shareItemVM) {
        String imgUrl = shareItemVM.getShareimgurl();
        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        boolean isClientValid = qq.isClientValid();//判断QQ客户端是否可用
        if (!isClientValid) {
            Toast.makeText(activity, "分享失败，QQ客户端未安装或当前版本过低", Toast.LENGTH_LONG).show();
            return;
        }
        QQ.ShareParams sp = new QQ.ShareParams();
        sp.setTitle(shareItemVM.getSharetitle());
        sp.setTitleUrl(shareItemVM.getShareurl()); // 标题的超链接
        sp.setText(shareItemVM.getSharetext());
        Bitmap bmp;
        if (TextUtils.isEmpty(imgUrl)) {
            if (shareItemVM.getDefaultshareimgurl() == -1) {
                bmp = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.logo);

            } else {
                bmp = BitmapFactory.decodeResource(activity.getResources(), shareItemVM.getDefaultshareimgurl());
            }
            sp.setImageData(bmp);
        } else {
            sp.setImageUrl(imgUrl);
        }
        qq.setPlatformActionListener(shareimpl);
        qq.share(sp);

    }

    @Override
    public void shareToQZone(ShareItemVM shareItemVM) {
        String imgUrl = shareItemVM.getShareimgurl();

        Platform qZone = ShareSDK.getPlatform(QZone.NAME);
        QQ.ShareParams sp = new QQ.ShareParams();
        sp.setTitle(shareItemVM.getSharetitle());
        sp.setTitleUrl(shareItemVM.getShareurl()); // 标题的超链接
        sp.setText(shareItemVM.getSharetext());
//        sp.setSite(shareInfo.getSite());
//        sp.setSiteUrl(shareItemVM.getShareurl());
        Bitmap bmp;
        if (TextUtils.isEmpty(imgUrl)) {
            if (shareItemVM.getDefaultshareimgurl() == -1) {
                bmp = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.logo);

            } else {
                bmp = BitmapFactory.decodeResource(activity.getResources(), shareItemVM.getDefaultshareimgurl());
            }
            sp.setImageData(bmp);
        } else {
            sp.setImageUrl(imgUrl);
        }
        qZone.setPlatformActionListener(shareimpl);
        qZone.share(sp);
    }

    @Override
    public void shareToWechat(ShareItemVM shareItemVM) {
        String imgUrl = shareItemVM.getShareimgurl();
        WechatMoments.ShareParams sp = new WechatMoments.ShareParams();
        sp.setShareType(Platform.SHARE_WEBPAGE);
        sp.setTitle(shareItemVM.getSharetitle());
        sp.setText(shareItemVM.getSharetext());

        Bitmap bmp;
        if (TextUtils.isEmpty(imgUrl)) {
            if (shareItemVM.getDefaultshareimgurl() == -1) {
                bmp = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.logo);

            } else {
                bmp = BitmapFactory.decodeResource(activity.getResources(), shareItemVM.getDefaultshareimgurl());
            }
            sp.setImageData(bmp);
        } else {
            sp.setImageUrl(imgUrl);
        }
        sp.setUrl(shareItemVM.getShareurl());
        Platform wechatMoments = ShareSDK.getPlatform(WechatMoments.NAME);
        wechatMoments.setPlatformActionListener(shareimpl);
        wechatMoments.share(sp);
    }

    @Override
    public void shareToWechatMoments(ShareItemVM shareItemVM) {
        String imgUrl = shareItemVM.getShareimgurl();
        Wechat.ShareParams sp = new Wechat.ShareParams();
        sp.setShareType(Platform.SHARE_WEBPAGE);
        sp.setTitle(shareItemVM.getSharetitle());
        sp.setText(shareItemVM.getSharetext());
        Bitmap bmp;
        if (TextUtils.isEmpty(imgUrl)) {
            if (shareItemVM.getDefaultshareimgurl() == -1) {
                bmp = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.logo);

            } else {
                bmp = BitmapFactory.decodeResource(activity.getResources(), shareItemVM.getDefaultshareimgurl());
            }
            sp.setImageData(bmp);
        } else {
            sp.setImageUrl(imgUrl);
        }
        sp.setUrl(shareItemVM.getShareurl());
        Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
        wechat.setPlatformActionListener(shareimpl);
        wechat.share(sp);

    }


    class ShareImpl implements PlatformActionListener, Handler.Callback {
        @Override
        public boolean handleMessage(Message message) {
            return false;
        }

        @Override
        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            if (shareCallback != null) {

                shareCallback.onComplete(platform.getDb().getPlatformNname());
            } else {
                Toast.makeText(activity, "分享成功", Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onError(Platform platform, int i, Throwable throwable) {
            if (shareCallback != null) {
                shareCallback.onError(platform.getDb().getPlatformNname(), throwable);
            } else {
                Toast.makeText(activity, "分享错误", Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onCancel(Platform platform, int i) {
            if (shareCallback != null) {
                shareCallback.onCancel(platform.getDb().getPlatformNname());
            } else {
                Toast.makeText(activity, "分享取消", Toast.LENGTH_LONG).show();
            }
        }
    }

}
