package com.eascs.share.dialog;

import android.support.annotation.NonNull;

import com.eascs.share.impl.ShareEnum;

/**
 * @Author luoming
 * @Date 2018/11/6 7:17 PM
 */

public class ShareItemVM {
    private String title;
    private int iconUrl;
    private int defaultshareimgurl;//默认的分享图片
    private String sharetitle;//分享标题
    private String shareimgurl;//分享的图片地址
    private String shareurl;//分享的链接
    private String sharetext;//分享的文本
    private ShareEnum shareEnum;


    /**
     * @param shareEnum   图标枚举
     * @param sharetitle  分享标题
     * @param shareimgurl 分享的图片地址
     * @param shareurl    分享的链接
     */
    public ShareItemVM(@NonNull ShareEnum shareEnum, String sharetitle, String shareimgurl, String shareurl) {
        this(shareEnum, sharetitle, shareimgurl, shareurl, null);

    }


    /**
     * @param shareEnum   图标枚举
     * @param sharetitle  分享标题
     * @param shareimgurl 分享的图片地址
     * @param shareurl    分享的链接
     * @param sharetext   分享的文本
     */
    public ShareItemVM(@NonNull ShareEnum shareEnum, String sharetitle, String shareimgurl, String shareurl, String sharetext) {
        this(shareEnum, sharetitle, shareimgurl, shareurl, null, -1);
    }

    /**
     * @param shareEnum   图标枚举
     * @param sharetitle  分享标题
     * @param shareimgurl 分享的图片地址
     * @param shareurl    分享的链接
     * @param sharetext   分享的文本
     */
    public ShareItemVM(@NonNull ShareEnum shareEnum, String sharetitle, String shareimgurl, String shareurl, String sharetext, int defaultshareimgurl) {
        if (shareEnum != null) {
            this.shareEnum = shareEnum;
            this.title = shareEnum.getName();
            this.iconUrl = shareEnum.getIndex();
            this.sharetitle = sharetitle;
            this.shareimgurl = shareimgurl;
            this.shareurl = shareurl;
            this.sharetext = sharetext;
            this.defaultshareimgurl = defaultshareimgurl;
        }
    }

    /**
     * @param title       item 标题
     * @param iconUrl     item 图片资源地址
     * @param sharetitle  分享标题
     * @param shareimgurl 分享的图片地址
     * @param shareurl    分享的链接
     */
    public ShareItemVM(@NonNull String title, int iconUrl, String sharetitle, String shareimgurl, String shareurl) {
        this(title, iconUrl, sharetitle, shareimgurl, shareurl, null);
    }

    /**
     * @param title       item 标题
     * @param iconUrl     item 图片资源地址
     * @param sharetitle  分享标题
     * @param shareimgurl 分享的图片地址
     * @param shareurl    分享的链接
     * @param sharetext   分享的文本
     */
    public ShareItemVM(@NonNull String title, int iconUrl, String sharetitle, String shareimgurl, String shareurl, String sharetext) {
        this(title, iconUrl, sharetitle, shareimgurl, shareurl, null, -1);

    }

    /**
     * @param title              item 标题
     * @param iconUrl            item 图片资源地址
     * @param sharetitle         分享标题
     * @param shareimgurl        分享的图片地址
     * @param shareurl           分享的链接
     * @param sharetext          分享的文本
     * @param defaultshareimgurl 默认的分享图片
     */
    public ShareItemVM(@NonNull String title, int iconUrl, String sharetitle, String shareimgurl, String shareurl, String sharetext, int defaultshareimgurl) {
        this.title = title;
        this.iconUrl = iconUrl;
        this.sharetitle = sharetitle;
        this.shareimgurl = shareimgurl;
        this.shareurl = shareurl;
        this.sharetext = sharetext;
        this.defaultshareimgurl = defaultshareimgurl;

    }

    public int getDefaultshareimgurl() {
        return defaultshareimgurl;
    }

    public void setDefaultshareimgurl(int defaultshareimgurl) {
        this.defaultshareimgurl = defaultshareimgurl;
    }

    public ShareEnum getShareEnum() {
        return shareEnum;
    }

    public void setShareEnum(ShareEnum shareEnum) {
        this.shareEnum = shareEnum;
    }

    public String getSharetext() {
        return sharetext;
    }

    public void setSharetext(String sharetext) {
        this.sharetext = sharetext;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(int iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getSharetitle() {
        return sharetitle;
    }

    public void setSharetitle(String sharetitle) {
        this.sharetitle = sharetitle;
    }

    public String getShareimgurl() {
        return shareimgurl;
    }

    public void setShareimgurl(String shareimgurl) {
        this.shareimgurl = shareimgurl;
    }

    public String getShareurl() {
        return shareurl;
    }

    public void setShareurl(String shareurl) {
        this.shareurl = shareurl;
    }
}
