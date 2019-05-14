package com.meitu.sww.testcommondialog;

/**
 * @author ShaoWenWen
 * @date 2019/5/14
 */
public enum ContentType {

    // 弹窗样式的倒计时
    DialogCountDown(0),
    // Toast样式的'倒计时'为显示状态
    ToastShowCountDown(1),
    // Toast样式的'倒计时'为隐藏状态
    ToastHideCountDown(2);

    private int type;

    ContentType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
