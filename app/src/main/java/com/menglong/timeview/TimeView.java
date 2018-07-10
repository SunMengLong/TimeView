package com.menglong.timeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Pooh on 2018/7/11.
 */

public class TimeView extends View {

    private Random random;
    private int rgb;
    private String time;
    private Rect mBounds = new Rect();

    public TimeView(Context context) {
        super(context);
        initView();
    }

    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TimeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        //随机背景颜色
        random = new Random();
        rgb = Color.rgb(100 + random.nextInt(155), 100 + random.nextInt(155),
                random.nextInt(100 + 155));
    }

    /**
     * 提供外界设置的单个条目展示的时间
     */
    public void setTime(String time) {
        this.time = time;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔
        Paint paint = new Paint();
        //设置画笔颜色
        paint.setColor(rgb);
        //抗锯齿
        paint.setAntiAlias(true);
        //消除锯齿
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //画圆   参数1+参数2=圆心的坐标，参数3=圆的半径
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2,
                paint);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        paint.getTextBounds(time, 0, time.length(), mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        //再绘制文字   参数2+参数3=文字显示的左上角坐标
        canvas.drawText(time, getWidth() / 2 - textWidth / 2, getHeight() / 2
                + textHeight / 2, paint);
    }
}
