package com.bravin.shi.news.custom.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

import java.security.InvalidParameterException;

/**
 * created by bravin on 2018/10/8.
 */
public class TransitionLayout extends FrameLayout {
    public TransitionLayout(@NonNull Context context) {
        super(context);
    }

    public TransitionLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TransitionLayout(@NonNull Context context, @Nullable AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TransitionLayout(@NonNull Context context, @Nullable AttributeSet attrs,
                            int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private int[] layerState;

    private int[] layers;

    private int currentLayer = -1;
    private int layerFrom;
    private int layerTo;

    private float preValue;
    private boolean changeVisible;

    private ValueAnimator animator = new ValueAnimator();

    private int duration = 1000;

    private Interpolator internalError = new LinearInterpolator();

    public void showLayer(int index) {
        if (currentLayer == index) {
            return;
        }

        if (animator != null && animator.isRunning()) {
            return;
        }
        addLayer(index);

        if (currentLayer == -1) {
            animator.setFloatValues(0, 255);
            animator.setDuration(duration / 2);
            layerFrom = 0;
            preValue = 0;
            layerTo = index;
        } else {
            animator.setFloatValues(255, 0, 255);
            animator.setDuration(duration);
            layerFrom = currentLayer;
            layerTo = index;
            preValue = 255;
        }
        animator.setInterpolator(internalError);
        animator.setRepeatCount(0);
        animator.addUpdateListener(updateListener);
        changeVisible = false;
        animator.start();
    }

    public void setTransDuration(int duration) {
        this.duration = duration;
    }

    private ValueAnimator.AnimatorUpdateListener updateListener =
            new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float currentValue = (float) animation.getAnimatedValue();
                    setAlpha(currentValue / 255);
                    if (!changeVisible && currentValue - preValue > 0) {
                        changeVisible = true;
                        View from = getChildAt(layerFrom);
                        from.setVisibility(GONE);
                        View to = getChildAt(layerTo);
                        to.setVisibility(VISIBLE);
                        currentLayer = layerTo;
                    }
                    preValue = currentValue;
                }
            };

    public void setLayers(@LayoutRes int[] layers) {
        int length = layers.length;
        if (length == 0) {
            throw new InvalidParameterException("length of layers is 0");
        }

        if (this.layers != null) {
            throw new IllegalStateException("layers has been initialized");
        }
        this.layers = layers;
        layerState = new int[length];
        showLayer(0);
    }

    private void addLayer(int index) {
        if (layerState[index] == 0) {
            View layer = inflate(getContext(), layers[index], null);
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            layer.setVisibility(GONE);
            addView(layer, getInsertIndex(index), lp);
            layerState[index] = 1;
        }
    }

    public View getLayer(int index) {
        addLayer(index);
        return getChildAt(index);
    }

    private int getInsertIndex(int layerIndex) {
        if (layerIndex == 0) {
            return layerIndex;
        }
        int insertIndex = 0;
        for (int i = 0;i < layerIndex;i++) {
            if (layerState[i] > 0) {
                insertIndex++;
            }
        }

        return insertIndex;
    }

    public int getCurrentLayer(){
        return currentLayer;
    }

    public int getDuration(){
        return duration;
    }
}
