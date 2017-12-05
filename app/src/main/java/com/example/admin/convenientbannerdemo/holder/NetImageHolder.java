package com.example.admin.convenientbannerdemo.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.admin.convenientbannerdemo.R;
import com.squareup.picasso.Picasso;

/**
 * Created by admin on 2017/12/5.
 */

public class NetImageHolder implements Holder<String> {
    ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        Picasso.with(context).load(data).placeholder(R.drawable.ic_default_adimage).error(R.drawable.ic_default_adimage).into(imageView);
    }
}
