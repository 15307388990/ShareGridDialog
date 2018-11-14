package com.eascs.share.sharedemo;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;

import com.eascs.share.callback.ShareCallback;
import com.eascs.share.dialog.ShareItemVM;
import com.eascs.share.impl.ShareGridDialogImpl;


/**
 * Created by luoming on 2018/11/12.
 *
 */

public class YDShareInvoiceyImpl extends ShareGridDialogImpl {
    public YDShareInvoiceyImpl(Activity activity, ShareCallback shareCallback) {
        super(activity, shareCallback);
    }

    public YDShareInvoiceyImpl(Activity activity) {
        super(activity);
    }

    @Override

    public void onItemClick(View view, int position, ShareItemVM shareItemVM) {
        super.onItemClick(view, position, shareItemVM);
        if (("null").equals(shareItemVM.getTitle()) || TextUtils.isEmpty(shareItemVM.getTitle())) {
            return;
        }
        if (("复制链接").equals(shareItemVM.getTitle())) {
            shareCallback.onComplete("复制链接");
        }
    }
}
