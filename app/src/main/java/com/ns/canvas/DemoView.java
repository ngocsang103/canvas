package com.ns.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.fingerprint.FingerprintManager;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by sangbn on 18/10/2017.
 */

public class DemoView extends View {
    public DemoView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Customer draw style
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        //draw
        canvas.drawPaint(paint);

        //draw blue circle
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(200, 200, 150, paint);

        //draw green circle
        paint.setAntiAlias(false);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(600, 200, 150 , paint);

        //draw Rectangle
        paint.setColor(Color.RED);
        canvas.drawRect(50,360, 200, 560, paint);
        //draw roatate text
        canvas.rotate(-45);
        paint.setTextSize(50);
        canvas.drawText("Hello Android I LOVE YOU", -100,580, paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
