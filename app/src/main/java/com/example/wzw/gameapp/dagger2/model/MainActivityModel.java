package com.example.wzw.gameapp.dagger2.model;

import com.example.wzw.gameapp.presenter.MainPresenter;
import com.example.wzw.gameapp.ui.activity.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @项目名称 :GameApp
 * @类描述 :
 * @创建人 : wzw
 * @创建时间 : 2018/5/27 17:33
 * @修改人：wzw
 * @修改时间：2018/5/27 17:33
 * @修改备注：
 */
@Module
public class MainActivityModel {
    MainActivity mActivity;

    public MainActivityModel(MainActivity activity) {
        mActivity = activity;
    }

    @Provides
    public MainPresenter newMianPresent(){
        return new MainPresenter(mActivity);
    }
}
