package com.eascs.share.sharedemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.eascs.share.callback.ShareCallback;
import com.eascs.share.dialog.ShareDialogParams;
import com.eascs.share.dialog.ShareGridDialog;
import com.eascs.share.dialog.ShareItemVM;
import com.eascs.share.impl.ShareEnum;

import java.util.ArrayList;

/**
 * Created by luoming on 2018/11/12.
 */

public class YDShareUtils {


    public static void showGoodsDetailShareDialog(final Activity context) {
        ArrayList<ShareItemVM> list = new ArrayList<>();
        list.add(new ShareItemVM(ShareEnum.WEIXIN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.PENGYOUQUAN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.WEIBO,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com", "分享文本"));
        list.add(new ShareItemVM(ShareEnum.QQ,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.KONGJIAN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM("图文下载", R.mipmap.share_tuwen1,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM("二维码海报", R.mipmap.share_erweima,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM("复制链接", R.mipmap.share_link,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        ShareDialogParams shareDialogParams = new ShareDialogParams();
        shareDialogParams.setShareItemVMS(list);
        shareDialogParams.setSpanCount(4);
        ShareGridDialog shareDialog = ShareGridDialog.newInstance(shareDialogParams);
        View view = LayoutInflater.from(context).inflate(R.layout.share_goods_head, null);
        shareDialog.setHeadview(view);

        YDShareGoodsImpl ydShareGoods = new YDShareGoodsImpl(context, new ShareCallback() {
            @Override
            public void onCancel(String name) {
                Toast.makeText(context, name + "分享取消", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete(String name) {
                Toast.makeText(context, name + "分享成功", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String name, Throwable throwable) {
                Toast.makeText(context, name + "分享失败", Toast.LENGTH_LONG).show();
            }
        });
        shareDialog.setDialogImpl(ydShareGoods);
        shareDialog.showDialog(context);
        shareDialog.setMargins(74, 0, 74, 94);
    }

    /**
     * 活动分享
     *
     * @param context
     */
    public static void showActivityShareDialog(final Activity context) {
        ArrayList<ShareItemVM> list = new ArrayList<>();
        list.add(new ShareItemVM(ShareEnum.WEIXIN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.PENGYOUQUAN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.QQ,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.KONGJIAN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.WEIBO,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com", "分享文本"));
        list.add(new ShareItemVM("复制链接", R.mipmap.share_link,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        ShareDialogParams shareDialogParams = new ShareDialogParams();
        shareDialogParams.setShareItemVMS(list);
        shareDialogParams.setSpanCount(3);
        ShareGridDialog shareDialog = ShareGridDialog.newInstance(shareDialogParams);
//        View view = LayoutInflater.from(context).inflate(R.layout.share_goods_head, null);
//        shareDialog.setHeadview(view);

        YDShareActivityImpl ydShareActivity = new YDShareActivityImpl(context, new ShareCallback() {
            @Override
            public void onCancel(String name) {
                Toast.makeText(context, name + "分享取消", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete(String name) {
                Toast.makeText(context, name + "分享成功", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String name, Throwable throwable) {
                Toast.makeText(context, name + "分享失败", Toast.LENGTH_LONG).show();
            }
        });
        shareDialog.setDialogImpl(ydShareActivity);
        shareDialog.showDialog(context);
        shareDialog.setMargins(64, 0, 64, 92);
    }

    /**
     * 发票分享
     *
     * @param context
     */
    public static void showInvoiceShareDialog(final Activity context) {
        ArrayList<ShareItemVM> list = new ArrayList<>();
        list.add(new ShareItemVM(ShareEnum.WEIXIN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.QQ,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM("复制链接", R.mipmap.share_link,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        ShareDialogParams shareDialogParams = new ShareDialogParams();
        shareDialogParams.setShareItemVMS(list);
        shareDialogParams.setSpanCount(3);
        ShareGridDialog shareDialog = ShareGridDialog.newInstance(shareDialogParams);
        View view = LayoutInflater.from(context).inflate(R.layout.share_invoice_head, null);
        shareDialog.setHeadview(view);

        YDShareInvoiceyImpl ydShareInvoicey = new YDShareInvoiceyImpl(context, new ShareCallback() {
            @Override
            public void onCancel(String name) {
                Toast.makeText(context, name + "分享取消", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete(String name) {
                Toast.makeText(context, name + "分享成功", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String name, Throwable throwable) {
                Toast.makeText(context, name + "分享失败", Toast.LENGTH_LONG).show();
            }
        });
        shareDialog.setDialogImpl(ydShareInvoicey);
        shareDialog.showDialog(context);
        shareDialog.setMargins(0, 0, 0, 56);
    }

    /**
     * 发现分享
     *
     * @param context
     */
    public static void showFundShareDialog(final Activity context) {
        ArrayList<ShareItemVM> list = new ArrayList<>();
        list.add(new ShareItemVM(ShareEnum.WEIXIN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.PENGYOUQUAN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.WEIBO,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com", "分享文本"));
        list.add(new ShareItemVM(ShareEnum.QQ,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.KONGJIAN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM("二维码海报", R.mipmap.share_erweima,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM("复制链接", R.mipmap.share_link,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM("图文分享", R.mipmap.share_tuwen1,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        ShareDialogParams shareDialogParams = new ShareDialogParams();
        shareDialogParams.setShareItemVMS(list);
        shareDialogParams.setSpanCount(4);
        ShareGridDialog shareDialog = ShareGridDialog.newInstance(shareDialogParams);
//        View view = LayoutInflater.from(context).inflate(R.layout.share_goods_head, null);
//        shareDialog.setHeadview(view);

        YDShareFundlmpl ydShareFundlmpl = new YDShareFundlmpl(context, new ShareCallback() {
            @Override
            public void onCancel(String name) {
                Toast.makeText(context, name + "分享取消", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete(String name) {
                Toast.makeText(context, name + "分享成功", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String name, Throwable throwable) {
                Toast.makeText(context, name + "分享失败", Toast.LENGTH_LONG).show();
            }
        });
        shareDialog.setDialogImpl(ydShareFundlmpl);
        shareDialog.showDialog(context);
        shareDialog.setMargins(74, 0, 74, 94);
    }

    /**
     * 发现分享
     *
     * @param context
     */
    public static void showOtherDialog(final Activity context) {
        ArrayList<ShareItemVM> list = new ArrayList<>();
        list.add(new ShareItemVM(ShareEnum.WEIXIN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(null, 0, null, null, null, null));
        list.add(new ShareItemVM(ShareEnum.PENGYOUQUAN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.QQ,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(ShareEnum.KONGJIAN,
                "标题",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3357139565,1548309168&fm=26&gp=0.jpg",
                "http://wwww.baidu.com"));
        list.add(new ShareItemVM(null, 0, null, null, null, null));
        ShareDialogParams shareDialogParams = new ShareDialogParams();
        shareDialogParams.setShareItemVMS(list);
        ShareGridDialog shareDialog = ShareGridDialog.newInstance(shareDialogParams);
        shareDialog.showDialog(context);
    }
}



