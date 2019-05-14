package com.meitu.sww.testcommondialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;

/**
 * @author ShaoWenWen
 * @date 2019/5/14
 */
public class CountDownTextView extends AppCompatTextView {

    // 默认开始时间
    public static final int DEFAULT_COUNT_DOWN_TIME = 3 * 1000;
    // 默认为1000毫秒的更新频率
    private static final int UPDATE_FREQUENCY_IN_MILLISECOND = 1000;

    // 当前倒计时的时间
    private int countDownTime = DEFAULT_COUNT_DOWN_TIME;
    // 倒计时变化的事件间隔
    private int updateFrequencyInMillisecond = UPDATE_FREQUENCY_IN_MILLISECOND;

    private Handler mainHandler = new Handler(Looper.getMainLooper());
    // 倒计时结束监听；
    private ICountDownTimeOver iCountDownTimeOver;
    private String originContent;
    // 默认为
    private ContentType contentType = ContentType.DialogCountDown;

    public CountDownTextView(Context context) {
        this(context, null);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCountDownTime(int countDownTime) {
        this.countDownTime = countDownTime;
    }

    public void setICountDownTimeOver(ICountDownTimeOver iCountDownTimeOver) {
        this.iCountDownTimeOver = iCountDownTimeOver;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    /**
     * 开始倒计时
     */
    public void startCountDown() {
        if (TextUtils.isEmpty(originContent)) {
            originContent = getText().toString();
        }
        updateTextView();
        mainHandler.postDelayed(new CountDownRunnable(), updateFrequencyInMillisecond);
    }

    /**
     * 结束倒计时
     */
    public void cancelCountDown() {
        mainHandler.removeCallbacksAndMessages(null);
    }

    public void updateTextView() {
        if (contentType.equals(ContentType.DialogCountDown)) {
            setText(getResources().getString(R.string.mtcp_count_down_timer, originContent, countDownTime / 1000));
        } else if (contentType.equals(ContentType.ToastShowCountDown)) {
            setText(getResources().getString(R.string.mtcp_count_down_toast_tip, countDownTime / 1000));
        } else if (contentType.equals(ContentType.ToastHideCountDown)) {
            setText(R.string.mtcp_toast_tip);
        }
    }

    public class CountDownRunnable implements Runnable {
        @Override
        public void run() {
            countDownTime -= 1000;
            if (countDownTime < 0) {
                iCountDownTimeOver.countDownTimeOver();
                return;
            }
            updateTextView();
            mainHandler.postDelayed(new CountDownRunnable(), updateFrequencyInMillisecond);
        }
    }

    public interface ICountDownTimeOver {

        /**
         * 时间走完回调给外部。
         */
        void countDownTimeOver();
    }

}
