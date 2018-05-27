package com.example.wzw.gameapp.dagger2.component;

import com.example.wzw.gameapp.dagger2.model.MainActivityModel;
import com.example.wzw.gameapp.ui.activity.MainActivity;

import dagger.Component;

/**
 * @项目名称 :GameApp
 * @类描述 :
 * @创建人 : wzw
 * @创建时间 : 2018/5/27 17:37
 * @修改人：wzw
 * @修改时间：2018/5/27 17:37
 * @修改备注：
 */
@Component(modules = MainActivityModel.class)
public interface MianActivityComponent {

    void in(MainActivity mainActivity);

}
