package com.example.wzw.gameapp.ui.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wzw.gameapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzw on 2018/5/29.
 */

public class pageActivity extends AppCompatActivity
        implements ViewPager.OnPageChangeListener
{

    private ViewPagerTransform viewPager;
    private LinearLayout       mLinearLayout;
    private final int[]           pics       = {R.drawable.type_image,R.drawable.type_image, R.drawable.type_image, R.drawable.type_image, R.drawable.type_image,R.drawable.type_image,R.drawable.type_image};
    private       int             mNum       = 0;
    //ImageView动态数组
    private       List<ImageView> mImageList = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageadapter);
        viewPager = (ViewPagerTransform) findViewById(R.id.viewpager);
        mLinearLayout = (LinearLayout) findViewById(R.id.main_linear);
        viewPager.addOnPageChangeListener(this);
        setPoint();
        initAdapter();

    }

    private void initAdapter() {
        // 设置页面间距
        viewPager.setPageMargin(50);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return pics.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            //            @Override
            //            public float getPageWidth(int position) {
            //                return 0.8f;
            //            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = View.inflate(container.getContext(),R.layout.widget_gallery_view, null);

                //                view.setLayoutParams(getPageLayoutParams());
                ImageView iv = (ImageView) view.findViewById(R.id.headRIV);
                iv.setImageResource(pics[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

        mLinearLayout.getChildAt(0).setEnabled(true);
    }

    private void setPoint() {
        ImageView imageView;
        View view;
        for (int pic:pics){

            view = new View(pageActivity.this);
            view.setBackgroundResource(R.drawable.shape_selector);
            view.setEnabled(false);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(10,10);

            layoutParams.leftMargin = 13;

            mLinearLayout.addView(view, layoutParams);
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("显示", ""+position);
        mLinearLayout.getChildAt(mNum).setEnabled(false);
        mLinearLayout.getChildAt(position).setEnabled(true);
        mNum = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
