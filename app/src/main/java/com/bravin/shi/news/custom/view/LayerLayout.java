package com.bravin.shi.news.custom.view;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.security.InvalidParameterException;

/**
 * created by bravin on 2018/10/8.
 */
public class LayerLayout extends FrameLayout {
    public LayerLayout(@NonNull Context context) {
        super(context);
    }

    public LayerLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LayerLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LayerLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private int[] layerState;

    private int[] layers;

    private int currentLayer;

    private int mAlpha;
    private int mAlphaFrom;
    private int mAlphaTo;
    private int mLayerFrom;
    private int mLayerTo;

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
        currentLayer = 0;
        // inflate第一个view
        addLayer(0);
    }

    private void addLayer(int index) {
        if (layerState[index] == 0) {
            View layer = inflate(getContext(), layers[index], null);
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            layer.setVisibility(INVISIBLE);
            addView(layer, getInsertIndex(index), lp);
            layerState[index] = 1;
        }
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
}
