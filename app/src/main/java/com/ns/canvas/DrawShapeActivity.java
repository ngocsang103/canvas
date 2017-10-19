package com.ns.canvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DrawShapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DemoView(this));
    }
}
