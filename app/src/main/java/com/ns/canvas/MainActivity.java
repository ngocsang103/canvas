package com.ns.canvas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DemoView demoView = new DemoView(this);

        setContentView(R.layout.activity_main);
        Button btnDrawShape, btnDrawSketch, btnSimpleDraw;
        btnDrawShape = (Button) findViewById(R.id.btnDrawShape);
        btnDrawSketch = (Button) findViewById(R.id.btnSketch);
        btnSimpleDraw = (Button) findViewById(R.id.btnSimpleDraw);
        btnDrawShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawShapeActivity.class);
                startActivity(intent);
            }
        });
        btnDrawSketch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawSketchActivity.class);
                startActivity(intent);
            }
        });
        btnSimpleDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleDrawActivity.class);
                startActivity(intent);
            }
        });
    }
}
