package com.example.wzw.gameapp.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.wzw.gameapp.R;
import com.example.wzw.gameapp.presenter.MainPresenter;
import com.example.wzw.gameapp.presenter.fragment.GameFragment;
import com.example.wzw.gameapp.presenter.fragment.ListFragment;
import com.example.wzw.gameapp.presenter.fragment.OnlyFragment;
import com.example.wzw.gameapp.presenter.fragment.ShopFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Inject
    MainPresenter mPresenter;
    @BindView(R.id.mainFragment)
    FrameLayout mMainFragment;
    @BindView(R.id.bottomeSwitcher)
    LinearLayout mBottomeSwitcher;

    ArrayList<Fragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //DaggerMianActivityComponent component = (DaggerMianActivityComponent) DaggerMianActivityComponent.builder()
        //      .mainActivityModel(new MainActivityModel(this))
        //        .build();
        //component.in(this);
        init();
        setListener();
    }

    private void init( ) {
        mFragments.add(new GameFragment());
        mFragments.add(new ListFragment());
        mFragments.add(new ShopFragment());
        mFragments.add(new OnlyFragment());
        onClickListener.onClick(mBottomeSwitcher.getChildAt(0));
    }

    private void setListener() {
        int childCount = mBottomeSwitcher.getChildCount();

        for (int i = 0;i<childCount;i++){
            FrameLayout childAt = (FrameLayout) mBottomeSwitcher.getChildAt(i);

            childAt.setOnClickListener(onClickListener);

        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int index = mBottomeSwitcher.indexOfChild(view);
            changUi(index);
            changFragment(index);
        }


    };

    private void changFragment(int index) {
        //获取到对应的fragment
        Fragment fragment = mFragments.get(index);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFragment,fragment)
                .commit();

    }

    /**
     * 改变所有孩子的状态
     * @param index
     */
    private void changUi(int index) {

        int childCount = mBottomeSwitcher.getChildCount();

        for (int i = 0;i<childCount;i++) {
            //判断i是否与index相同 .
            //相同时不可用状态
            if (i ==index){
                //设置不可点击
                //mBottomeSwitcher.getChildAt(i).setEnabled(false);

                setEnable(mBottomeSwitcher.getChildAt(i),false);
             }else {
                //设置可点击
                //mBottomeSwitcher.getChildAt(i).setEnabled(true);

                setEnable(mBottomeSwitcher.getChildAt(i),true);
            }
        }

    }

    /**
     * 将每个item中的状态一同改变
     * @param item
     * @param b
     */
    private void setEnable(View item, boolean b) {
        item.setEnabled(b);
        if (item instanceof ViewGroup){
            int index = ((ViewGroup) item).getChildCount();
            for (int i = 0;i<index;i++){
                setEnable(((ViewGroup) item).getChildAt(i),b);
            }
        }
    }


}
