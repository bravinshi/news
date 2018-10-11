package com.bravin.shi.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bravin.shi.news.custom.view.TransitionLayout;

/**
 * created by bravin on 2018/10/10.
 */
public class TestActivity extends AppCompatActivity {
    private TransitionLayout transitionLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        transitionLayout = findViewById(R.id.ll);
        int[] aaa = new int[]{R.layout.ll_2, R.layout.ll_1};
        transitionLayout.setLayers(aaa);

        transitionLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                transitionLayout.showLayer(1);
            }
        },2 * 1000);

        transitionLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                transitionLayout.showLayer(0);
            }
        },5 * 1000);
    }
}
