package com.example.wzw.gameapp.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wzw.gameapp.R;
import com.example.wzw.gameapp.ui.activity.GameListActivity;
import com.example.wzw.gameapp.ui.views.ViewPagerTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @项目名称 :GameApp
 * @类描述 :
 * @创建人 : wzw
 * @创建时间 : 2018/5/28 22:59
 * @修改人：wzw
 * @修改时间：2018/5/28 22:59
 * @修改备注：
 */

public class GameFragment extends BaseFragment implements  ViewPager.OnPageChangeListener {

    @BindView(R.id.viewpager)
    ViewPagerTransform mViewpager;
    @BindView(R.id.main_linear)
    LinearLayout mMainLinear;
    Unbinder unbinder;

    private final int[]           pics       = {R.drawable.type_image,R.drawable.type_image, R.drawable.type_image, R.drawable.type_image, R.drawable.type_image,R.drawable.type_image,R.drawable.type_image};
    private       int             mNum       = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewpager.addOnPageChangeListener(this);
        setPoint();
        initAdapter();
    }

    private void initAdapter( ) {
        // 设置页面间距
        mViewpager.setPageMargin(0);
        mViewpager.setAdapter(new PagerAdapter() {
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
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), GameListActivity.class));
                    }
                });
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

        mMainLinear.getChildAt(0).setEnabled(true);
    }

    private void setPoint() {
        ImageView imageView;
        View view;
        for (int pic:pics){

            view = new View(getActivity());
            view.setBackgroundResource(R.drawable.point);
            view.setEnabled(false);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20,20);

            layoutParams.leftMargin = 23;

            mMainLinear.addView(view, layoutParams);
        }
    }

    @Override
    public void onDestroyView( ) {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("显示", ""+position);
        mMainLinear.getChildAt(mNum).setEnabled(false);
        mMainLinear.getChildAt(position).setEnabled(true);
        mNum = position;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
