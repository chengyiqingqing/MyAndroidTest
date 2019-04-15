package com.meitu.sww.testcustomviewcollection.canvasoperate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author ShaoWenWen
 * @date 2019/3/24
 */
public class CanvasOperateView extends View {

    private Paint paint1;
    private Paint paint2;
    private Paint paint3;

    public CanvasOperateView(Context context) {
        this(context,null);
    }

    public CanvasOperateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    public CanvasOperateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        paint1 = new Paint();
        paint1.setColor(Color.GRAY);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);
        paint2 = new Paint();
        paint2.setColor(Color.RED);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint3 = new Paint();
        paint3.setColor(Color.BLUE);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setAntiAlias(true);
//        setBackgroundColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawCircle(canvas);
//        operateScale(canvas);
//        operateScaleUnder0(canvas);
//        operateScaleForLoop(canvas);
        operateRotate(canvas);

    }

    /**
     * 1.绘制圆形区域。
     */
    public void drawCircle(Canvas canvas){
        canvas.drawCircle(60,60,50,paint2);
        canvas.translate(200,200);
        canvas.drawCircle(60,60,50,paint2);
    }

    /**
     * 2.绘制缩放的矩形
     */
    public void operateScale(Canvas canvas){
        int width = getWidth();
        int height = getHeight();
        canvas.translate(width/2,height/2);
        RectF rectF = new RectF(0,-400,400,0);
        canvas.drawRect(rectF,paint2);

        // canvas1
        canvas.save();// 保存的是canvas1
        canvas.scale(0.5f,0.5f);
        canvas.drawRect(rectF,paint1);
        canvas.restore();// 还原的是canvas1
        // canvas1
        canvas.save();// 保存的是canvas1
        canvas.scale(0.6f,0.6f);
        canvas.drawRect(rectF,paint3);
        canvas.restore();// 还原的是canvas1
        // canvas1
        canvas.scale(0.5f,0.5f);
        canvas.drawRect(rectF,paint2);
        canvas.scale(0.5f,0.5f);
        canvas.drawRect(rectF,paint2);

    }

    /**
     * 3.绘制缩放(>0)和（<0）的矩形
     */
    public void operateScaleUnder0(Canvas canvas){
        int width=getWidth();
        int height = getHeight();
        canvas.translate(width / 2, height / 2);  //将坐标移到中心
        RectF rectF = new RectF(0, -400, 400, 0);
        canvas.drawRect(rectF, paint2);
        // 以（200，0）为中心进行宽高0.5倍的缩放
        canvas.save();
        canvas.scale(0.5f, 0.5f, 200, 0);
        canvas.drawRect(rectF, paint2);
        canvas.restore();

        canvas.drawRect(rectF, paint2);
        canvas.scale(0.5f, -0.5f, 200, 0);
        canvas.drawRect(rectF, paint2);
    }

    public void operateScaleForLoop(Canvas canvas){
        int width=getWidth();
        int height=getHeight();
        canvas.translate(width/2,height/2);  //将坐标移到中心
        RectF rectF= new RectF(-300,-300,300,300);
        canvas.drawRect(rectF,paint2);
        for (int index = 0; index < 5; index++) {
            canvas.scale(0.9f, 0.9f, 0, 0);
            canvas.drawRect(rectF,paint2);
        }
    }

    /**
     * 旋转操作
     */
    public void operateRotate(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        canvas.translate(width/2,height/2);
//        RectF rectF = new RectF(0,-200,200,0);
        RectF rectF = new RectF(0,-200,200,0);
        canvas.drawRect(rectF,paint1);
        // 默认以（0，0）为中心，旋转180度的画布上进行绘制
        /*canvas.rotate(180);
        canvas.drawRect(rectF,paint2);*/

        // 以（200，0）为中心，将画布旋转180度，
        /*canvas.rotate(180,200,0);
        canvas.drawRect(rectF,paint2);*/

        // 默认以（0，0）为中心，累加角度进行旋转(270°)
        canvas.rotate(180);
        canvas.rotate(90);
        canvas.drawRect(rectF,paint2);
    }

}
