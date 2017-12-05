package com.example.admin.convenientbannerdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.admin.convenientbannerdemo.R;
import com.example.admin.convenientbannerdemo.holder.LocalImageHolder;
import com.example.admin.convenientbannerdemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/12/5.
 */

public class ViewPagerLocalActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, OnItemClickListener {

    private static final String TAG = ViewPagerLocalActivity.class.getSimpleName();
    private List<Integer> images = new ArrayList<>();
    private ConvenientBanner banner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        initView();
        initData();
    }

    private void initView() {
        banner = findViewById(R.id.banner);
    }

    private void initData() {

        for (int i = 0; i < 7; i++) {
            images.add(Utils.getResId("ic_test_" + i, R.drawable.class));
        }

        banner.setPages(new CBViewHolderCreator<LocalImageHolder>() {
            @Override
            public LocalImageHolder createHolder() {
                return new LocalImageHolder();
            }
        }, images)
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnPageChangeListener(this)
                .setOnItemClickListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d(TAG, "监听到翻到第" + position + "了");
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "点击了第：" + position + "个", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        banner.startTurning(3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        banner.stopTurning();
    }
}
