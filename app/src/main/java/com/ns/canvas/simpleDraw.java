package com.ns.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangbn on 19/10/2017.
 */

public class simpleDraw extends View {
    // setup initial color
    private final int paintColor = Color.GREEN;
    // defines paint and canvas
    private Paint drawPaint;
    // Store circles to draw each time the user touches down
    private Path path = new Path();
    private List<Point> circlePoints;
    private  Point point;

    public simpleDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //setFocusable(true);
        //setFocusableInTouchMode(true);
        circlePoints = new ArrayList<Point>();
        setupPaint();
    }
    // Setup paint with color and stroke styles
    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawCircle(50, 50, 30, drawPaint);
//        drawPaint.setColor(Color.GREEN);
//        canvas.drawCircle(50, 150, 40, drawPaint);
//        drawPaint.setColor(Color.BLUE);
//        canvas.drawCircle(50, 250, 50, drawPaint);
        for (Point p : circlePoints) {
            canvas.drawCircle(p.x, p.y, 25, drawPaint);
        }

    }
    // Append new circle each time user presses on screen
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        point = new Point(Math.round(touchX), Math.round(touchY));
        circlePoints.add(point);
        // indicate view should be redrawn
        postInvalidate();
        //invalidate();
        return true;
    }
}
