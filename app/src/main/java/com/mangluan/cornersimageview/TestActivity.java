package com.mangluan.cornersimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.mangluan.library.CornersImageView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        LinearLayout layout = findViewById(R.id.test_layout);
        CornersImageView cornersImageView = new CornersImageView(this, 60);
        cornersImageView.setRadius(180);
        cornersImageView.setImageResource(R.mipmap.test);
        layout.addView(cornersImageView);
    }

}
