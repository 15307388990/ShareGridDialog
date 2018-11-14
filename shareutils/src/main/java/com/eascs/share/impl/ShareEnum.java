package com.eascs.share.impl;

import com.eascs.shareutils.R;

/**
 * Created by luoming on 2018/11/13.
 */

public enum ShareEnum {
    QQ("QQ好友", R.mipmap.share_qq),
    WEIXIN("微信好友", R.mipmap.share_weixin),
    WEIBO("新浪微博", R.mipmap.share_weibo),
    PENGYOUQUAN("朋友圈", R.mipmap.share_pengyouquan),
    KONGJIAN("QQ空间", R.mipmap.share_kongjian);

    // 成员变量
    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    // 构造方法
    ShareEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
