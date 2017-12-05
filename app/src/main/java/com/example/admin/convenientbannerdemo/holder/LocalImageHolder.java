package com.example.admin.convenientbannerdemo.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * Created by admin on 2017/12/5.
 */

public class LocalImageHolder implements Holder<Integer> {
    ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        imageView.setImageResource(data);

    }
}
