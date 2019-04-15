package com.meitu.sww.testcustomviewcollection.draw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.meitu.sww.testcustomviewcollection.R;
import com.meitu.sww.testcustomviewcollection.util.DeviceUtil;

/**
 * @author ShaoWenWen
 * @date 2019/3/24
 */
public class DrawView extends View {

    public Paint paint1;
    public Paint paint2;

    public DrawView(Context context) {
        this(context,null);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        paint1 = new Paint();
//        paint1.setColor(getResources().getColor(R.color.colorPrimary));
        paint1.setColor(Color.GRAY);
        paint1.setStyle(Paint.Style.FILL);
        // 抗锯齿；
        paint1.setAntiAlias(true);

        paint2 = new Paint();
        paint2.setColor(Color.RED);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint2.setStrokeWidth(10);
//        paint2.setStrokeWidth(DeviceUtil.dpToPx(10));
//        canvas.drawPoint(DeviceUtil.getScreenWidth()/4,DeviceUtil.getScreenHeight((Activity) getContext())/8,paint2);
        //画点
        canvas.drawPoint(100, 100, paint2);
        canvas.drawPoints(new float[]{100, 120, 120, 120, 140, 120},paint2);
//        canvas.drawPoints(new float[]{120,120,140,140,160,160},paint2);

        canvas.drawLine(100,150,200,150,paint2);
        canvas.drawLines(new float[]{100, 170, 300, 170, 100, 190, 500, 190}, paint2);

        canvas.drawRect(100,210,300,280,paint2);
        Rect rect = new Rect(100,290,250,380);
        canvas.drawRect(rect,paint2);

        // 绘制椭圆
        RectF rect1 = new RectF(100,390,250,450);
        canvas.drawOval(rect1,paint2);
        // 绘制圆角矩形
        RectF rect2 = new RectF(260,390,500,450);
        canvas.drawRoundRect(rect2,18,18,paint2);

        canvas.drawCircle(500+50,(390+450)/2,30,paint2);// 圆心x,圆心y,半径r

        // 绘制圆弧
        RectF rectF = new RectF(100,500,300,700);
        canvas.drawArc(rectF,0,45,true,paint2);

        canvas.drawArc(rectF,90,135,false,paint2);

        super.onDraw(canvas);

    }



}
