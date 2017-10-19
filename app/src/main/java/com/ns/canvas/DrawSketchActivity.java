package com.ns.canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by sangbn on 18/10/2017.
 */

public class DrawSketchActivity extends Activity {
    RelativeLayout rlContainer;
    Paint paint;
    View view;
    Path path;
    Bitmap bitmap;
    Canvas canvas;
    Button btnClear;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_sketch);

        rlContainer = (RelativeLayout) findViewById(R.id.rlContainer);

        btnClear = (Button)findViewById(R.id.btnClear);

        view = new SketchSheetView(DrawSketchActivity.this);

        paint = new Paint();

        path = new Path();

        rlContainer.addView(view, new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));

        paint.setDither(true);

        paint.setColor(Color.parseColor("#FF0000"));

        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeJoin(Paint.Join.ROUND);

        paint.setStrokeCap(Paint.Cap.ROUND);

        paint.setStrokeWidth(5);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                path.reset();
                view.invalidate();
            }
        });
    }

    private class SketchSheetView extends View {
        public SketchSheetView(Context context) {

            super(context);

            bitmap = Bitmap.createBitmap(100,100, Bitmap.Config.RGB_565);

            canvas = new Canvas(bitmap);

            this.setBackgroundColor(Color.WHITE);
        }
//        private ArrayList<DrawingClass> DrawingClassArrayList = new ArrayList<DrawingClass>();

        @Override
        public boolean onTouchEvent(MotionEvent event) {

//           DrawingClass pathWithPaint = new DrawingClass();

          //  canvas.drawPath(path, paint);

            if (event.getAction() == MotionEvent.ACTION_DOWN) {

                path.moveTo(event.getX(), event.getY());

               // path.lineTo(event.getX(), event.getY());
            }
            else if (event.getAction() == MotionEvent.ACTION_MOVE) {

                path.lineTo(event.getX(), event.getY());

//                pathWithPaint.setPath(path);
//
//                pathWithPaint.setPaint(paint);

//                DrawingClassArrayList.add(pathWithPaint);
            }

            invalidate();
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
             super.onDraw(canvas);
            canvas.drawPath(path, paint);
//            if (DrawingClassArrayList.size() > 0) {
//
//                canvas.drawPath(
//                        DrawingClassArrayList.get(DrawingClassArrayList.size() - 1).getPath(),
//
//                        DrawingClassArrayList.get(DrawingClassArrayList.size() - 1).getPaint());
//            }
        }
    }
//    public class DrawingClass {
//
//        Path DrawingClassPath;
//        Paint DrawingClassPaint;
//
//        public Path getPath() {
//            return DrawingClassPath;
//        }
//
//        public void setPath(Path path) {
//            this.DrawingClassPath = path;
//        }
//
//
//        public Paint getPaint() {
//            return DrawingClassPaint;
//        }
//
//        public void setPaint(Paint paint) {
//            this.DrawingClassPaint = paint;
//        }
//    }
}
