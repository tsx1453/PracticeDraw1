package com.hencoder.hencoderpracticedraw1.practice;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashMap;

public class Practice10HistogramView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    HashMap<String, Float> map = new HashMap<>();
    float r = 0f;

    ValueAnimator animator = ValueAnimator.ofFloat(0, 1);

    {
        map.put("Froyo", 10f);
        map.put("GB", 50f);
        map.put("ICS", 50f);
        map.put("JB", 130f);
        map.put("KitKat", 180f);
        map.put("L", 300f);
        map.put("M", 100f);
        paint.setTextSize(30);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                r = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(2000);
    }

    public Practice10HistogramView(Context context) {
        super(context);
        animator.start();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        animator.start();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        if (!animator.isRunning()) {
            animator.start();
        } else {
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.WHITE);
            canvas.drawLine(10, 700, 10, 10, paint);
            canvas.drawLine(10, 700, 1000, 700, paint);
            int drawX = 50;
            for (String key : map.keySet()) {
                paint.setColor(Color.GRAY);
                canvas.drawText(key, drawX, 750, paint);
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.GREEN);
                canvas.drawRect(drawX, 700 - map.getOrDefault(key, 0f) * r, drawX + 80, 700, paint);
                drawX += 100;
            }
        }
    }
}
