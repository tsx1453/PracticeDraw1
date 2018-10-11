package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class Practice11PieChartView extends View {
    private String TAG = "pieChartView";

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int[] colors = new int[]{Color.RED, Color.YELLOW, Color.BLUE, Color.GRAY, Color.GREEN};
    HashMap<String, Integer> map = new HashMap<>();

    {
        map.put("A", 2);
        map.put("B", 1);
        map.put("C", 4);
        map.put("D", 1);
        map.put("E", 3);
        map.put("F", 5);
        map.put("G", 6);
    }

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int i = 0;
        float angle = 0f;
        Log.d(TAG, "Practice11PieChartView->onDraw: start~");
        for (String key : map.keySet()) {
            Log.d(TAG, "Practice11PieChartView->onDraw: " + key + "~" + angle);
            paint.setColor(colors[i % colors.length]);
            canvas.drawArc(100, 100, 600, 600, angle,  (float) map.get(key) / 22f * 360f, true, paint);
            angle += (float) map.get(key) / 22f * 360f;
            ++i;
        }
        Log.d(TAG, "Practice11PieChartView->onDraw: end~");
    }
}
